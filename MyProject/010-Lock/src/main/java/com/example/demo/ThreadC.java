package com.example.demo;

public class ThreadC extends Thread{
    private ObjectService objectService;

    public ThreadC(ObjectService objectService) {
        super();
        this.objectService = objectService;
    }

    @Override
    public void run() {
        super.run();
        objectService.serviceMethodC();
    }
}
