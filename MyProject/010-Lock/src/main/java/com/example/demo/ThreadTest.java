package com.example.demo;

public class ThreadTest {
    public static void main(String[] args) {

        ObjectService service = new ObjectService();

        ThreadA a = new ThreadA(service);
        a.setName("a");
        a.start();
        ThreadB b = new ThreadB(service);
        b.setName("b");
        b.start();

        ThreadC c = new ThreadC(service);
        c.setName("c");
        c.start();
        ThreadD d = new ThreadD(service);
        d.setName("d");
        d.start();

        //this 鎖住當前方法
        //object 鎖住類内所有方法

    }
}
