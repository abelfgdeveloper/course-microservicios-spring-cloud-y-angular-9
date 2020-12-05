package com.abelfgdeveloper.courses.usecase.impl;

import com.abelfgdeveloper.courses.domain.Course;
import com.abelfgdeveloper.courses.service.CourseService;
import com.abelfgdeveloper.courses.usecase.CourseFindByStudentIdUseCase;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Component
public class DefaultCourseFindByStudentIdUseCase implements CourseFindByStudentIdUseCase {

  private final CourseService courseService;

  @Transactional(readOnly = true)
  @Override
  public List<Course> execute(String studentId) {
    return courseService.findByStudentId(studentId);
  }
}
