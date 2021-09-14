package com.willy.restCRUD.dto;

import com.willy.restCRUD.entity.User;
import com.willy.restCRUD.entity.UserProfile;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class UserDto {
  private User user;
  private UserProfile userProfile;
  public UserDto() {
  }
}
