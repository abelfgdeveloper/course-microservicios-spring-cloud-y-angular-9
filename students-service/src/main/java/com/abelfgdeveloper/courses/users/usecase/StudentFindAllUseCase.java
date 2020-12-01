package com.abelfgdeveloper.courses.users.usecase;

import com.abelfgdeveloper.courses.users.domain.Student;
import java.util.List;

public interface StudentFindAllUseCase {

  List<Student> execute();
}
