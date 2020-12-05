package com.abelfgdeveloper.courses.usecase.impl;

import com.abelfgdeveloper.courses.domain.Course;
import com.abelfgdeveloper.courses.service.CourseService;
import com.abelfgdeveloper.courses.usecase.CourseDeleteStudentUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Component
public class DefaultCourseDeleteStudentUseCase implements CourseDeleteStudentUseCase {

  private final CourseService courseService;

  @Transactional
  @Override
  public Course execute(String id, String studentId) {
    return courseService.deleteStudent(id, studentId);
  }
}
