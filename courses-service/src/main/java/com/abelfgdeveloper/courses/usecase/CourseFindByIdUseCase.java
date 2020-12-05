package com.abelfgdeveloper.courses.usecase;

import com.abelfgdeveloper.courses.domain.Course;

public interface CourseFindByIdUseCase {

  Course execute(String id);
}
