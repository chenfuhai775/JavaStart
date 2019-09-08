package com.example.demo.impl;

import com.alibaba.dubbo.common.URL;
import com.example.demo.api.Car;

public class BlackCar implements Car {
    public void getColor(URL url) {
        System.out.println("BlackCar");
    }
}
