package com.example.demo;

public class ThreadD extends Thread{
    private ObjectService objectService;

    public ThreadD(ObjectService objectService) {
        super();
        this.objectService = objectService;
    }

    @Override
    public void run() {
        super.run();
        objectService.serviceMethodD();
    }
}
