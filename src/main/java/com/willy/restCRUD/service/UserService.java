package com.willy.restCRUD.service;

import com.willy.restCRUD.dto.UserDto;
import com.willy.restCRUD.entity.User;
import java.util.List;

public interface UserService {

  User saveSingleUser(UserDto userDto);

  List<User> getAllUsers();

  User getSingleUserById(int id);

  void deleteSingleUserById(int id);

  User updateSingleUser(UserDto userDto, int id);
}
