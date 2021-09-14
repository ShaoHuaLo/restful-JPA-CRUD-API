package com.willy.restCRUD.service;

import com.willy.restCRUD.dto.InstructorDto;
import com.willy.restCRUD.entity.Course;
import com.willy.restCRUD.entity.Instructor;
import java.util.List;
import java.util.Set;

public interface InstructorService {

  Instructor saveInstructor(InstructorDto dto);

  List<Instructor> getAllInstructors();

  Instructor getInstructorById(int id);

  void deleteInstructorById(int id);

  void addCoursesToIntructor(int instructorId, Set<Course> courses);

  void removeCoursesFromInstructor(int instructorId, Set<Course> courses);

//  Instructor updateInstructor(InstructorDto dto, int id);
}
