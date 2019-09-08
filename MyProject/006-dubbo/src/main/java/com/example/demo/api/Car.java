package com.example.demo.api;

import com.alibaba.dubbo.common.URL;
import com.alibaba.dubbo.common.extension.Adaptive;
import com.alibaba.dubbo.common.extension.SPI;

@SPI
public interface Car {
    @Adaptive(value = "carType")
    void getColor(URL url);
}
