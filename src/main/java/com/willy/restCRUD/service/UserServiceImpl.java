package com.willy.restCRUD.service;

import com.willy.restCRUD.dto.UserDto;
import com.willy.restCRUD.entity.User;
import com.willy.restCRUD.entity.UserProfile;
import com.willy.restCRUD.repository.UserDao;
import java.sql.SQLException;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

  private UserDao userDao;

  @Autowired
  public UserServiceImpl(UserDao userDao) {
    this.userDao = userDao;
  }


  @Transactional(rollbackOn = SQLException.class)
  @Override
  public User saveSingleUser(UserDto userDto) {
    User user = userDto.getUser();
    UserProfile userProfile = userDto.getUserProfile();

    user.setUserProfile(userProfile);
    userProfile.setUser(user);
    User res = userDao.saveSingleUser(user);
    if (res == null) {
      throw new RuntimeException();
    }
    return res;
  }

  @Transactional
  @Override
  public List<User> getAllUsers() {
    List<User> users = userDao.getAllUsers();
    if (users == null) {
      throw new RuntimeException();
    }
    return users;
  }

  @Transactional
  @Override
  public User getSingleUserById(int id) {
    User user = userDao.getSingleUserById(id);
    if (user == null) {
      throw new RuntimeException();
    }
    return user;
  }

  @Transactional(rollbackOn = SQLException.class)
  @Override
  public void deleteSingleUserById(int id) {
    userDao.deleteSingleUserById(id);
  }

  @Transactional(rollbackOn = SQLException.class)
  @Override
  public User updateSingleUser(UserDto userDto, int id) {
    User user = userDto.getUser();
    UserProfile userProfile = userDto.getUserProfile();

    user.setUserProfile(userProfile);
    userProfile.setUser(user);

    user.setId(id);
    userProfile.setId(id);

    User updateUser = userDao.updateSingleUser(user);
    if (updateUser == null) {
      throw new RuntimeException();
    }
    return updateUser;
  }
}
