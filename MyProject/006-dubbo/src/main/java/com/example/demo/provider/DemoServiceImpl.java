package com.example.demo.provider;

import com.alibaba.dubbo.config.annotation.Service;
import com.example.demo.api.DemoService;

@Service
public class DemoServiceImpl implements DemoService {

  @Override
  public String sayHello(String name) {
    return name;
  }
}
