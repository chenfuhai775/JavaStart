package com.example.demo;

import com.example.demo.dao.UserDao;
import com.example.demo.entity.User;
import java.io.IOException;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MybatisHelloWorld {

  public static void main(String[] args) {
    SqlSession sqlSession = getSessionFactory().openSession();
    UserDao userMapper = sqlSession.getMapper(UserDao.class);
    User user = userMapper.findUserById(2);
    if (user != null) {
      System.out.println("編號:" + user.getContactID() + ",訂單號:" + user.getOrderNo());
    }
  }

  private static SqlSessionFactory getSessionFactory() {
    SqlSessionFactory sessionFactory = null;
    String resource = "configuration.xml";
    try {
      sessionFactory = new SqlSessionFactoryBuilder().build(Resources
          .getResourceAsReader(resource));
    } catch (IOException e) {
      e.printStackTrace();
    }
    return sessionFactory;
  }
}
