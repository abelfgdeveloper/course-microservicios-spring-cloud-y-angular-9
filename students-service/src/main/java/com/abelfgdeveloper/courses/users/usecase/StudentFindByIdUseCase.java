package com.abelfgdeveloper.courses.users.usecase;

import com.abelfgdeveloper.courses.users.domain.Student;

public interface StudentFindByIdUseCase {

  Student execute(String id);
}
