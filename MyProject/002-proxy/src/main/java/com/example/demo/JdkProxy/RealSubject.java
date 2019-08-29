package com.example.demo.JdkProxy;

public class RealSubject implements Subject {
  @Override
  public void dosomething() {
    System.out.println(" call something! ");

  }
}
