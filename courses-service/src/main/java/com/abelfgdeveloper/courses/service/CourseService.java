package com.abelfgdeveloper.courses.service;

import com.abelfgdeveloper.courses.domain.Course;
import java.util.List;

public interface CourseService {

  Course create(Course course);

  Course update(String id, Course course);

  void deleteById(String id);

  Course findById(String id);

  List<Course> findAll();

  Course addStudent(String id, String studentId);

  Course deleteStudent(String id, String studentId);

  List<Course> findByStudentId(String studentId);
}
