package com.example.demo.dao;

import com.example.demo.entity.User;
import java.util.List;

public interface UserDao {

  void insert(User user);

  User findUserById(User user);

  List<User> findAllUsers();
}
