package com.example.demo;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class Demo {

  public static void main(String[] args) {
    //创建真正的对象
    final MyBusiness obj = new MyBusinessImpl();

    //重写method1的实现---->不修改源码
    //生成真正的代理对象
		/*
		 Proxy.newProxyInstance(loader, 类加载器
		 						obj, 真正对象实现的接口
		 						arg2)InvocationHandler表示客户端如何调用代理对象
		  */
    MyBusiness proxyObj = (MyBusiness) Proxy.newProxyInstance(Demo.class.getClassLoader(),
        obj.getClass().getInterfaces(),
        new InvocationHandler() {
          public Object invoke(Object proxy, Method method, Object[] params)
              throws Throwable {
            if ("method1".equals(method.getName())) {
              System.out.println("********重写了method1***********");
              return null;
            } else {
              //不感兴趣的方法
              return method.invoke(obj, params);
            }
          }
        });
    proxyObj.method1();
    proxyObj.method2();
  }
}
