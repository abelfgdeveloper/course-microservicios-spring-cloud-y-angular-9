package com.abelfgdeveloper.courses.usecase;

import com.abelfgdeveloper.courses.domain.Course;

public interface CourseUpdateUseCase {

  Course execute(String id, Course course);
}
