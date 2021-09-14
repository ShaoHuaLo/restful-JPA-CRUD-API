package com.willy.restCRUD.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class UserProfile {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  @Column
  private String sex;

  @Column
  private String job;

  @JsonIgnore
  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "user_id")
  private User user;

  public UserProfile() {
  }

  public UserProfile(String sex, String job) {
    this.sex = sex;
    this.job = job;
  }

  @Override
  public String toString() {
    return "UserProfile{" +
        "id=" + id +
        ", sex='" + sex + '\'' +
        ", job='" + job + '\'' +
        '}';
  }
}
