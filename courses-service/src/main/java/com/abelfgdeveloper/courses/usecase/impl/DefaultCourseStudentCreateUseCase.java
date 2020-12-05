package com.abelfgdeveloper.courses.usecase.impl;

import com.abelfgdeveloper.courses.domain.Course;
import com.abelfgdeveloper.courses.service.CourseService;
import com.abelfgdeveloper.courses.usecase.CourseCreateUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Component
public class DefaultCourseStudentCreateUseCase implements CourseCreateUseCase {

  private final CourseService courseService;

  @Transactional
  @Override
  public Course execute(Course course) {
    return courseService.create(course);
  }
}
