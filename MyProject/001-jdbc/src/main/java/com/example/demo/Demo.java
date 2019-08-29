package com.example.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Demo {

  public static void main(String[] args) throws ClassNotFoundException, SQLException {
    Class.forName("com.mysql.cj.jdbc.Driver");
    String url = "jdbc:mysql://172.18.21.188:3306/wtsdb?useUnicode=true&characterEncoding=UTF-8";
    String user = "fitpbs";
    String password = "fitpbs2019dev";

    //建立数据库连接
    Connection conn = DriverManager.getConnection(url, user, password);

    String sql = "select * from basedatadict";
    Statement stmt = conn.createStatement();    //创建一个statement对象
    ResultSet rs = stmt.executeQuery(sql);        //执行查询

    int id, value;
    String username;
    System.out.println("id\t姓名\t性别\t地址\t");

    while (rs.next()) {        //遍历结果集
      id = rs.getInt("DataDictID");
      username = rs.getString("DisPlayName");
      value = rs.getInt("DisPlayValue");
      System.out.println(id + "\t" + username + "\t" + value);
    }
  }
}
