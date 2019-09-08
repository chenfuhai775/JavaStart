package com.example.demo.impl;

import com.alibaba.dubbo.common.URL;
import com.example.demo.api.Car;

public class RedCar implements Car {
    public void getColor(URL url) {
        System.out.println("RedCar");
    }
}
