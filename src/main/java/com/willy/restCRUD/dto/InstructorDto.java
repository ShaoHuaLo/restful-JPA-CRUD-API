package com.willy.restCRUD.dto;

import com.willy.restCRUD.entity.Course;
import java.util.List;
import java.util.Set;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class InstructorDto {
  private String name;
  private Set<Course> courses;

  public InstructorDto() {
  }
}
