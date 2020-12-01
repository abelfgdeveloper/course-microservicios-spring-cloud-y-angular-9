package com.abelfgdeveloper.courses.users.usecase.impl;

import com.abelfgdeveloper.courses.users.domain.Student;
import com.abelfgdeveloper.courses.users.service.StudentService;
import com.abelfgdeveloper.courses.users.usecase.StudentFindByIdUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Component
public class DefaultStudentFindByIdUseCase implements StudentFindByIdUseCase {

  private final StudentService studentService;

  @Transactional(readOnly = true)
  @Override
  public Student execute(String id) {
    return studentService.findById(id);
  }
}
