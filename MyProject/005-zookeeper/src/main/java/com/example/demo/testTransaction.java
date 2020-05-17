package com.example.demo;

import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.api.transaction.CuratorOp;
import org.apache.curator.framework.api.transaction.CuratorTransactionResult;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.curator.retry.RetryNTimes;
import org.apache.zookeeper.ZooKeeper;

import java.util.List;

/* 事务管理：碰到异常，事务会回滚
 * @throws Exception
 */
public class testTransaction {
    //ZooKeeper服务地址
    private static final String CONNECT_ADDR = "192.168.91.133:2181";

    public static void main(String[] args) throws Exception {
        CuratorFramework client = CuratorFrameworkFactory.newClient(
                CONNECT_ADDR,
                new RetryNTimes(10, 5000)
        );
        client.start();

        System.out.println(ZooKeeper.States.CONNECTED);
        System.out.println(client.getState());

        //定义几个基本操作
        CuratorOp createOp = client.transactionOp().create()
                .forPath("/curator", "some data".getBytes());

        CuratorOp setDataOp = client.transactionOp().setData()
                .forPath("/curator", "other data".getBytes());

        CuratorOp deleteOp = client.transactionOp().delete()
                .forPath("/curator");

        //事务执行结果
        List<CuratorTransactionResult> results = client.transaction()
                .forOperations(createOp, setDataOp, deleteOp);

        //遍历输出结果
        for (CuratorTransactionResult result : results) {
            System.out.println("执行结果是： " + result.getForPath() + "--" + result.getType());
        }
    }
}
