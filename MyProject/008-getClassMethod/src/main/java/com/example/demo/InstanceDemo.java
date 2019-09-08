package com.example.demo;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Constructor;

public class InstanceDemo {
    public static void main(String[] args) {
        // 使用new关键字} → 调用了构造函数
        System.out.println("=================new关键字:");
        PrintTest printtest1 = new PrintTest();
        printtest1.setName("printtest1");
        System.out.println(printtest1 + ",hashcode:" + printtest1.hashCode());
        printtest1.hello();
        try {
            // 使用Class类的newInstance方法} → 调用了构造函数
            System.out.println("=========Class类的newInstance方法:");
            PrintTest printtest2 = (PrintTest) Class.forName("com.example.demo.PrintTest").newInstance();
            //或者可以
            // PringtTest pringttest2 = PringtTest.class.newInstance();
            printtest2.setName("printtest2");
            System.out.println(printtest2 + ",hashcode:" + printtest2.hashCode());
            printtest2.hello();

            // 使用Constructor类的newInstance方法 } → 调用了构造函数
            System.out.println("=======Constructor类的newInstance方法:");
            Constructor<PrintTest> constructor = PrintTest.class.getConstructor();
            PrintTest printTest3 = (PrintTest) constructor.newInstance();
            printTest3.setName("printTest3");
            System.out.println(printTest3 + ",hashcode:" + printTest3.hashCode());
            printTest3.hello();

            // 使用clone方法 } → 没有调用构造函数
            System.out.println("=======使用clone方法 } → 没有调用构造函数");
            PrintTest printTest4 = (PrintTest) printTest3.clone();
            printTest4.setName("printTest4");
            System.out.println(printTest4 + ",hashcode:" + printTest4.hashCode());

            //序列化
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("data.obj"));
            out.writeObject(printTest4);
            out.close();

            // 使用反序列化 } → 没有调用构造函数
            System.out.println("===========使用反序列化");
            ObjectInputStream in = new ObjectInputStream(new FileInputStream("data.obj"));
            PrintTest printTest5 = (PrintTest) in.readObject();
            printTest5.setName("printTest5");
            System.out.println(printTest5 + ",hashcode:" + printTest5.hashCode());
            printTest5.hello();

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
