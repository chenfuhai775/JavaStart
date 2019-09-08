package com.example.demo.consumer;

import com.example.demo.framework.Invocation;
import com.example.demo.protocol.http.HttpClient;
import com.example.demo.provider.api.HelloService;

public class Consumer {
    public static void main(String[] args) {

        HttpClient httpClient = new HttpClient();
        Invocation invocation = new Invocation(HelloService.class.getName(), "sayHello", new Class[]{String.class}, new Object[]{"cfg"});

        String result = httpClient.send("127.0.0.1", 9090, invocation);

        System.out.println(result);

    }
}
