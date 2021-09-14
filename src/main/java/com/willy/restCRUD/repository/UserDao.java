package com.willy.restCRUD.repository;

import com.willy.restCRUD.entity.User;
import java.util.List;

public interface UserDao {

  List<User> getAllUsers();

  User getSingleUserById(int id);

  User saveSingleUser(User user);

  void deleteSingleUserById(int id);

  User updateSingleUser(User user);

}
