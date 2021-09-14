package com.willy.restCRUD.controller;

import com.willy.restCRUD.repository.CrudDao;
import com.willy.restCRUD.dto.UserDto;
import com.willy.restCRUD.entity.User;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api")
public class CrudController {
  private static final Logger LOG = LoggerFactory.getLogger(CrudController.class);

  private CrudDao dao;

  @Autowired
  public CrudController(CrudDao dao) {
    this.dao = dao;
  }

  @GetMapping(path = "/users")
  public List<User> getUsers() {
    return dao.getUsers();
  }

  @GetMapping(path = "/users/{id}")
  public User getUserById(@PathVariable int id) {
    return dao.getUserById(id);
  }

  @PostMapping(path = "/users")
  public User saveUser(@RequestBody UserDto dto) {
    return dao.saveUser(dto);
  }

  @DeleteMapping(path = "/users/{id}")
  public void deleteUserById(@PathVariable int id) {
    dao.deleteUserById(id);
  }

  @PutMapping(path = "/users")
  public User updateUser(@RequestBody UserDto dto) {
    return dao.updateUser(dto);
  }



}
