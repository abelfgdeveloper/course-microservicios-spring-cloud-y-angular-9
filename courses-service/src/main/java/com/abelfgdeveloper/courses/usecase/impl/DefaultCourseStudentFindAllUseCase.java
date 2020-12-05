package com.abelfgdeveloper.courses.usecase.impl;

import com.abelfgdeveloper.courses.domain.Course;
import com.abelfgdeveloper.courses.service.CourseService;
import com.abelfgdeveloper.courses.usecase.CourseFindAllUseCase;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Component
public class DefaultCourseStudentFindAllUseCase implements CourseFindAllUseCase {

  private final CourseService courseService;

  @Transactional(readOnly = true)
  @Override
  public List<Course> execute() {
    return courseService.findAll();
  }
}
