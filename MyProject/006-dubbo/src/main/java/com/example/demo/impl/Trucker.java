package com.example.demo.impl;

import com.alibaba.dubbo.common.URL;
import com.example.demo.api.Car;
import com.example.demo.api.Driver;

public class Trucker implements Driver {
    public void setCar(Car car) {
        this.car = car;
    }
    private Car car;

    public void driveCar(URL url) {
        car.getColor(url);
    }
}
