package com.example.demo.impl;

import com.alibaba.dubbo.common.URL;
import com.example.demo.api.Car;

public class CarWrapper implements Car {
    private Car car;

    public CarWrapper(Car car) {
        this.car = car;
    }

    public void getColor(URL url) {
        System.out.println("before...");
        car.getColor(url);
        System.out.println("after...");
    }
}
