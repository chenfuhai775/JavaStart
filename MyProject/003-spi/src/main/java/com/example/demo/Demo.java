package com.example.demo;

import com.example.demo.InterFace.IDefaultInterFace;
import java.util.Iterator;
import java.util.ServiceLoader;
import java.util.function.Function;

public class Demo {

  protected void Demo(String a, String b, String c, String d, String e, String f) {

  }

  public static void main(String[] args) {
    ServiceLoader<IDefaultInterFace> serviceLoader = ServiceLoader.load(IDefaultInterFace.class);
    Iterator<IDefaultInterFace> defaultInterFaceIterators = serviceLoader.iterator();
    boolean notFound = true;
    while (defaultInterFaceIterators.hasNext()) {
      notFound = false;
      IDefaultInterFace defaultInterFace = defaultInterFaceIterators.next();
      System.out.println(defaultInterFace.mul(1, 2));
    }
    if (notFound) {
      System.out.println("未发现实现");
    }
    Function<String, String> func = String::toUpperCase;
    System.out.println(func.apply("abc"));
  }
}
