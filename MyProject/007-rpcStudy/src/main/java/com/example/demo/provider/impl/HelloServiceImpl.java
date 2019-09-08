package com.example.demo.provider.impl;

import com.example.demo.provider.api.HelloService;

public class HelloServiceImpl implements HelloService {

    public String sayHello(String username) {
        return "hello" + username;
    }
}