package com.willy.restCRUD.repository;

import com.willy.restCRUD.entity.Course;
import com.willy.restCRUD.entity.Instructor;
import java.util.List;
import java.util.Set;

public interface InstructorDao {

  void saveInstructor(Instructor instructor);

  List<Instructor> getAllInstructors();

  Instructor getIntructorById(int id);

  void deleteInstructorById(int id);

  void addCoursesToInstructor(int instructorId, Set<Course> courses);

  void removeCoursesFromInstructor(int instructorId, Set<Course> courses);

  //  Instructor updateInstructor(Instructor instructor);
}
