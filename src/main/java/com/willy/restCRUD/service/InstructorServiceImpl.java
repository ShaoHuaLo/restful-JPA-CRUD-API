package com.willy.restCRUD.service;

import com.willy.restCRUD.dto.InstructorDto;
import com.willy.restCRUD.entity.Course;
import com.willy.restCRUD.entity.Instructor;
import com.willy.restCRUD.repository.InstructorDao;
import java.sql.SQLException;
import java.util.List;
import java.util.Set;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InstructorServiceImpl implements InstructorService {

  private InstructorDao dao;

  @Autowired
  public InstructorServiceImpl(InstructorDao dao) {
    this.dao = dao;
  }

  @Transactional(rollbackOn = SQLException.class)
  @Override
  public Instructor saveInstructor(InstructorDto dto) {
    Instructor instructor = new Instructor(dto.getName());
    Set<Course> courses = dto.getCourses();
    courses.forEach(instructor::addCourse);
    dao.saveInstructor(instructor);
    return instructor;
  }

  @Transactional(rollbackOn = SQLException.class)
  @Override
  public List<Instructor> getAllInstructors() {
    List<Instructor> instructors = dao.getAllInstructors();
    if (instructors == null) {
      throw new RuntimeException();
    }
    return instructors;
  }

  @Transactional(rollbackOn = SQLException.class)
  @Override
  public Instructor getInstructorById(int id) {
    Instructor instructor = dao.getIntructorById(id);
    if (instructor == null) {
      throw new RuntimeException();
    }
    return instructor;
  }

  @Transactional(rollbackOn = SQLException.class)
  @Override
  public void deleteInstructorById(int id) {
    try {
      dao.deleteInstructorById(id);
    } catch (Exception e) {
      throw e;
    }
  }

  @Transactional(rollbackOn = SQLException.class)
  @Override
  public void addCoursesToIntructor(int instructorId, Set<Course> courses) {
    dao.addCoursesToInstructor(instructorId, courses);
  }

  @Transactional(rollbackOn = SQLException.class)
  @Override
  public void removeCoursesFromInstructor(int instructorId, Set<Course> courses) {
    dao.removeCoursesFromInstructor(instructorId, courses);
  }


  // TODO ::
//  @Transactional(rollbackOn = SQLException.class)
//  @Override
//  public Instructor updateInstructor(InstructorDto dto, int id) {
//    Instructor instructor = new Instructor(dto.getName());
//    instructor.setId(id);
//    Set<Course> courses = dto.getCourses();
//    courses.forEach(instructor::addCourse);
//
//    Instructor updated = dao.updateInstructor(instructor);
//    if (updated == null) {
//      throw new RuntimeException();
//    }
//    return updated;
//  }
}
