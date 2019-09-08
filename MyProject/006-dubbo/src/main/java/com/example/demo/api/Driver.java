package com.example.demo.api;

import com.alibaba.dubbo.common.URL;
import com.alibaba.dubbo.common.extension.SPI;

@SPI
public interface Driver {
    void driveCar(URL url);
}
