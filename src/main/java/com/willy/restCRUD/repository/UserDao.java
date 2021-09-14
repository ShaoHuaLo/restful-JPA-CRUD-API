package com.willy.restCRUD.repository;

import com.willy.restCRUD.dto.UserDto;
import com.willy.restCRUD.entity.User;
import com.willy.restCRUD.entity.UserProfile;
import java.util.List;

public interface UserDao {

  List<User> getAllUsers();

  User getSingleUserById(int id);

  User saveSingleUser(User user);

  void deleteSingleUserById(int id);

  User updateSingleUser(User user);

}
