package com.example.demo.api;

import com.alibaba.dubbo.common.extension.SPI;

@SPI
public interface Car {
    public void getColor();
}
