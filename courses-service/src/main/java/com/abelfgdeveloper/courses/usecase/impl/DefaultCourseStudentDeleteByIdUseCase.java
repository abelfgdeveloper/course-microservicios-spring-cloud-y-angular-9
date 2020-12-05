package com.abelfgdeveloper.courses.usecase.impl;

import com.abelfgdeveloper.courses.service.CourseService;
import com.abelfgdeveloper.courses.usecase.CourseDeleteByIdUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Component
public class DefaultCourseStudentDeleteByIdUseCase implements CourseDeleteByIdUseCase {

  private final CourseService courseService;

  @Transactional
  @Override
  public void execute(String id) {
    courseService.deleteById(id);
  }
}
