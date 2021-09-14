package com.willy.restCRUD.controller;

import com.willy.restCRUD.dto.InstructorDto;
import com.willy.restCRUD.entity.Course;
import com.willy.restCRUD.entity.Instructor;
import com.willy.restCRUD.repository.InstructorDao;
import com.willy.restCRUD.service.InstructorService;
import java.util.List;
import java.util.Set;
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
@RequestMapping(path = "/api/instructors")
public class InstructorController {

  private InstructorService service;

  @Autowired
  public InstructorController(InstructorService service) {
    this.service = service;
  }

  @GetMapping(path = "/")
  public List<Instructor> getAllInstructor() {
    return service.getAllInstructors();
  }

  @GetMapping(path = "/{id}")
  public Instructor getInstructorById(@PathVariable int id) {
    return service.getInstructorById(id);
  }

  @PostMapping(path = "/")
  public Instructor saveIntructor(@RequestBody InstructorDto dto) {
    return service.saveInstructor(dto);
  }

  @DeleteMapping(path = "/{id}")
  public void deleteIntructorById(@PathVariable int id) {
    service.deleteInstructorById(id);
  }


  @PostMapping(path = "/{id}/addCourses")
  public void addCoursesToInstructor(@PathVariable int id, @RequestBody InstructorDto dto) {
    service.addCoursesToIntructor(id, dto.getCourses());
  }

  @PostMapping(path = "/{id}/removeCourses")
  public void removeCoursesFromInstructor(@PathVariable int id, @RequestBody InstructorDto dto) {
    service.removeCoursesFromInstructor(id, dto.getCourses());
  }

  //  @PutMapping
//  public Instructor updateInstructor(InstructorDto dto, int id) {
//    return null;
//  }

}
