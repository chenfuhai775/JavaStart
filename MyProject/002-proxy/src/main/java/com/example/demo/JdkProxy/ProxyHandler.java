package com.example.demo.JdkProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyHandler implements InvocationHandler {
  private Object targetObject;//代理目标

  public Object bind(Object obj){
    this.targetObject  = obj;
    return Proxy.newProxyInstance(obj.getClass().getClassLoader(),
        obj.getClass().getInterfaces(),
        this);
  }

  @Override
  public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
    System.out.println("开启事务...");
    Object returnValue = method.invoke(targetObject, args);//回调被代理目标的方法userDaoImpl.add();
    System.out.println("提交事务");
    return returnValue;
  }
}
