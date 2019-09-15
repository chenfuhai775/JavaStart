package com.example.demo.ObjectFactory;

import com.example.demo.MybatisHelloWorld;
import org.apache.ibatis.session.SqlSession;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ExampleObjectFactoryTest {
    public static void main(String[] args) throws IOException {
       SqlSession sqlSession = MybatisHelloWorld.getSessionFactory().openSession();
        ExampleObjectFactory e = new ExampleObjectFactory();
        List constructorArgTypes = new ArrayList();
        constructorArgTypes.add(int.class);
        constructorArgTypes.add(String.class);
        constructorArgTypes.add(int.class);
        constructorArgTypes.add(double.class);
        constructorArgTypes.add(double.class);

        List constructorArgs = new ArrayList();
        constructorArgs.add(1);
        constructorArgs.add("运动鞋");
        constructorArgs.add(5);
        constructorArgs.add(300);
        constructorArgs.add(0.0);

        ShoppingCart sCart = (ShoppingCart)e.create(ShoppingCart.class,constructorArgTypes,constructorArgs);
        System.out.println(sCart.getTotalAmount());
        sqlSession.close();
    }
}
