package com.example.demo;

/* 事务管理：碰到异常，事务会回滚
 * @throws Exception
 */
@Test
public class testTransaction {

    public static void main(String[] args) {
        //定义几个基本操作
        CuratorOp createOp = client.transactionOp().create()
                .forPath("/curator/one_path", "some data".getBytes());

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
