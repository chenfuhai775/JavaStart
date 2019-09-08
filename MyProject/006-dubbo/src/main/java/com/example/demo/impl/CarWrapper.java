package com.example.demo.impl;

import com.example.demo.api.Car;

public class CarWrapper implements Car {
    private Car car;

    public CarWrapper(Car car) {
        this.car = car;
    }

    public void getColor() {
        System.out.println("before...");
        car.getColor();
        System.out.println("after...");
    }
}
