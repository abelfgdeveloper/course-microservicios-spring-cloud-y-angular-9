package com.abelfgdeveloper.courses.usecase.impl;

import com.abelfgdeveloper.courses.domain.Course;
import com.abelfgdeveloper.courses.service.CourseService;
import com.abelfgdeveloper.courses.usecase.CourseFindByIdUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Component
public class DefaultCourseStudentFindByIdUseCase implements CourseFindByIdUseCase {

  private final CourseService courseService;

  @Transactional(readOnly = true)
  @Override
  public Course execute(String id) {
    return courseService.findById(id);
  }
}
