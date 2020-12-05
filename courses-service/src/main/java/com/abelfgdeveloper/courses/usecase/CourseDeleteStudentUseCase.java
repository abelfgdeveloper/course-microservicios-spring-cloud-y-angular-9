package com.abelfgdeveloper.courses.usecase;

import com.abelfgdeveloper.courses.domain.Course;

public interface CourseDeleteStudentUseCase {

  Course execute(String id, String studentId);
}
