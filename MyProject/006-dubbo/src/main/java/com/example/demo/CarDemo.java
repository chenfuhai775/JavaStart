package com.example.demo;

import com.alibaba.dubbo.common.extension.ExtensionLoader;
import com.example.demo.api.Car;

public class CarDemo {
    public static void main(String[] args) {
        ExtensionLoader<Car> extensionLoader = ExtensionLoader.getExtensionLoader(Car.class);
        Car redCar = extensionLoader.getExtension("red");
        redCar.getColor();
    }
}
