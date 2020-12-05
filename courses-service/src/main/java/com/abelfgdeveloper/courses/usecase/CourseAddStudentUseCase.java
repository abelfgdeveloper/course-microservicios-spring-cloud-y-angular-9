package com.abelfgdeveloper.courses.usecase;

import com.abelfgdeveloper.courses.domain.Course;

public interface CourseAddStudentUseCase {

  Course execute(String id, String studentId);
}
