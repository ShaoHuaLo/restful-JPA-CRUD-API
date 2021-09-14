package com.willy.restCRUD.repository;

import com.willy.restCRUD.entity.Course;
import com.willy.restCRUD.entity.Instructor;
import java.util.List;
import java.util.Set;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class InstructorDaoImpl implements InstructorDao {

  private EntityManager em;

  @Autowired
  public InstructorDaoImpl(EntityManager em) {
    this.em = em;
  }

  @Override
  public void saveInstructor(Instructor instructor) {
    em.persist(instructor);
  }

  @Override
  public List<Instructor> getAllInstructors() {
    TypedQuery<Instructor> query = em.createQuery("from Instructor", Instructor.class);
    return query.getResultList();
  }

  @Override
  public Instructor getIntructorById(int id) {
    return em.find(Instructor.class, id);
  }

  @Override
  public void deleteInstructorById(int id) {
    em.remove(em.find(Instructor.class, id));
  }


  @Override
  public void addCoursesToInstructor(int instructorId, Set<Course> courses) {
    Instructor instructor = getIntructorById(instructorId);
    courses.forEach(course -> {
      instructor.addCourse(course);
    });
    em.merge(instructor);
  }

  @Override
  public void removeCoursesFromInstructor(int instructorId, Set<Course> courses) {
    Instructor instructor = getIntructorById(instructorId);
    instructor.removeCourses(courses);
    em.merge(instructor);
  }

//  @Override
//  public Instructor updateInstructor(Instructor instructor) {
//    return null;
//  }


}
