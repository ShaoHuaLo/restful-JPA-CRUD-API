package com.willy.restCRUD.dao;

import com.willy.restCRUD.dto.UserDto;
import com.willy.restCRUD.entity.User;
import java.util.List;

public interface CrudDao {
  List<User> getUsers();
  User saveUser(UserDto userDto);
  User getUserById(int id);
  void deleteUserById(int id);

}
