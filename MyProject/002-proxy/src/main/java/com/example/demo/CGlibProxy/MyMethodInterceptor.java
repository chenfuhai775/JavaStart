package com.example.demo.CGlibProxy;


import java.lang.reflect.Method;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;


public class MyMethodInterceptor implements MethodInterceptor {

  @Override
  public Object intercept(Object sub, Method method, Object[] objects, MethodProxy methodProxy)
      throws Throwable {
    System.out.println("======插入前置通知======");
    Object object = methodProxy.invokeSuper(sub, objects);
    System.out.println("======插入后者通知======");
    return object;
  }
}
