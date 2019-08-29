package com.example.demo.spi;

import com.example.demo.InterFace.IDefaultInterFace;

public class SpiInterface implements IDefaultInterFace {

    @Override
    public int mul(int x, int y) {
        return x+y;
    }

    @Override
    public int mul2(int x, int y) {
        return 0;
    }
}
