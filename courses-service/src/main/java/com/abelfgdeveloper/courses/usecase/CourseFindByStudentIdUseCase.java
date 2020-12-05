package com.abelfgdeveloper.courses.usecase;

import com.abelfgdeveloper.courses.domain.Course;
import java.util.List;

public interface CourseFindByStudentIdUseCase {

  List<Course> execute(String studentId);
}
