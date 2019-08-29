package com.example.demo.InterFace;

public interface IDefaultInterFace {

    default int mul(int x, int y) {
        return x*y;
    }
    default int mul2(int x, int y) {
        return x*x*y*y;
    }
}
