package com.example.demo;

import org.elasticsearch.action.DocWriteRequest;
import org.elasticsearch.action.DocWriteResponse;
import org.elasticsearch.action.bulk.BulkItemResponse;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.update.UpdateResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.text.Text;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightBuilder;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightField;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class TestController {

    @Autowired
    RestHighLevelClient  highLevelClient;

    @RequestMapping("/test")
    public void test(@RequestParam String keyword) {
        Integer pageIndex = 1;
        Integer pageSize = 5;
        String indexName = "bamboo";
        Map<String, Object> data = new HashMap<>();
        data.put("name", keyword);

        List<Map<String, Object>> result = new ArrayList<Map<String, Object>>();
        SearchRequest searchRequest = new SearchRequest(indexName);
        // searchRequest.types(indexName);
        queryBuilder(pageIndex, pageSize, data, indexName, searchRequest);
        try {
            SearchResponse response = highLevelClient.search(searchRequest, RequestOptions.DEFAULT);
            for (SearchHit hit : response.getHits().getHits()) {
                Map<String, Object> map = hit.getSourceAsMap();
                map.put("id", hit.getId());
                result.add(map);

                // 取高亮结果
                Map<String, HighlightField> highlightFields = hit.getHighlightFields();
                HighlightField highlight = highlightFields.get("name");
                Text[] fragments = highlight.fragments(); // 多值的字段会有多个值
                String fragmentString = fragments[0].string();
                System.out.println("高亮：" + fragmentString);
            }
            System.out.println("pageIndex:" + pageIndex);
            System.out.println("pageSize:" + pageSize);
            System.out.println(response.getHits().getTotalHits());
            System.out.println(result.size());
            for (Map<String, Object> map : result) {
                System.out.println(map.get("name"));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void queryBuilder(Integer pageIndex, Integer pageSize, Map<String, Object> query, String indexName,
                              SearchRequest searchRequest) {
        if (query != null && !query.keySet().isEmpty()) {
            SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
            if (pageIndex != null && pageSize != null) {
                searchSourceBuilder.size(pageSize);
                if (pageIndex <= 0) {
                    pageIndex = 0;
                }
                searchSourceBuilder.from((pageIndex - 1) * pageSize);
            }
            BoolQueryBuilder boolBuilder = QueryBuilders.boolQuery();
            query.keySet().forEach(key -> {
                boolBuilder.must(QueryBuilders.matchQuery(key, query.get(key)));

            });
            searchSourceBuilder.query(boolBuilder);

            HighlightBuilder highlightBuilder = new HighlightBuilder();
            HighlightBuilder.Field highlightTitle =
                    new HighlightBuilder.Field("title").preTags("<strong>").postTags("</strong>");
            highlightTitle.highlighterType("unified");
            highlightBuilder.field(highlightTitle);
            searchSourceBuilder.highlighter(highlightBuilder);

            SearchRequest source = searchRequest.source(searchSourceBuilder);
        }
    }
}
