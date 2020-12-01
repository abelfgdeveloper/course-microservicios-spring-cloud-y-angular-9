package com.abelfgdeveloper.courses.users.usecase;

import com.abelfgdeveloper.courses.users.domain.Student;

public interface StudentUpdateUseCase {

  Student execute(String id, Student student);
}
