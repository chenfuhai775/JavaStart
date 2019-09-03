package com.example.demo.consumer;

import com.example.demo.api.DemoService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Consumer {

  public static void main(String[] args) {
    ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("consumer.xml");
    context.start();
    DemoService demoService = (DemoService) context.getBean("demoService");
    String hello = demoService.sayHello("你好!");
    System.out.println(hello);
  }
}
