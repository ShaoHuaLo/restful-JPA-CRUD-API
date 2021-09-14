package com.willy.restCRUD.entity;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class Instructor {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  @Column
  private String name;

  @OneToMany(mappedBy = "instructor", cascade = {CascadeType.PERSIST, CascadeType.MERGE}, orphanRemoval = true)
  private  Set<Course> courses = new HashSet<>();

  public Instructor() {
  }

  public Instructor(String name) {
    this.name = name;
  }

  public void addCourse(Course course) {
    course.setInstructor(this);
    this.courses.add(course);
  }

  public void removeCourses(Set<Course> toRemove) {
    // should set to null ?
    this.courses = this.courses.stream()
        .filter(course -> !toRemove.contains(course))
        .collect(Collectors.toSet());
  }
}
