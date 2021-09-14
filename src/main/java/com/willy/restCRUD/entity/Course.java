package com.willy.restCRUD.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Persistence;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class Course {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  @Column(name = "course_title")
  private String courseTitle;

  @JsonIgnore
  @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
  @JoinColumn(name = "instructor_id")
  private Instructor instructor;

  public Course() {
  }

  public Course(String courseTitle) {
    this.courseTitle = courseTitle;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Course course = (Course) o;
    return courseTitle.equals(course.courseTitle);
  }

  @Override
  public int hashCode() {
    return Objects.hash(courseTitle);
  }
}
