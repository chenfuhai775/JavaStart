package com.example.demo;

import com.alibaba.dubbo.common.URL;
import com.alibaba.dubbo.common.extension.ExtensionLoader;
import com.example.demo.api.Driver;

import java.util.HashMap;
import java.util.Map;

public class DriverDemo {
    public static void main(String[] args) {
        ExtensionLoader<Driver> extensionLoader = ExtensionLoader.getExtensionLoader(Driver.class);
        Driver driver = extensionLoader.getExtension("trucker");
        Map<String, String> hashMap = new HashMap();
        hashMap.put("carType", "red");
        URL url = new URL("", "", 0, hashMap);
        driver.driveCar(url);
    }
}
