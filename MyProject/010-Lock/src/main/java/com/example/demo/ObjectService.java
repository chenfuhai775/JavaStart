package com.example.demo;

public class ObjectService {

    private String a = new String();

    public void serviceMethodA() {
        try {
            synchronized (this) {
                System.out.println("A begin time=" + System.currentTimeMillis());
                Thread.sleep(2000);
                System.out.println("A end   time=" + System.currentTimeMillis());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void serviceMethodB() {
        synchronized (this) {
            System.out.println("B begin time=" + System.currentTimeMillis());
            System.out.println("B end   time=" + System.currentTimeMillis());
        }
    }

    public void serviceMethodC() {
        try {
            synchronized (a) {
                System.out.println("C begin time=" + System.currentTimeMillis());
                Thread.sleep(2000);
                System.out.println("C end   time=" + System.currentTimeMillis());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized void serviceMethodD() {
//        synchronized (a) {
        System.out.println("D begin time=" + System.currentTimeMillis());
        System.out.println("D end   time=" + System.currentTimeMillis());
//        }
    }

}
