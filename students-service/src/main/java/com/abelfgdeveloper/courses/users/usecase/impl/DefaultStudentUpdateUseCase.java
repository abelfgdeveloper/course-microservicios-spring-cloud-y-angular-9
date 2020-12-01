package com.abelfgdeveloper.courses.users.usecase.impl;

import com.abelfgdeveloper.courses.users.domain.Student;
import com.abelfgdeveloper.courses.users.service.StudentService;
import com.abelfgdeveloper.courses.users.usecase.StudentUpdateUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Component
public class DefaultStudentUpdateUseCase implements StudentUpdateUseCase {

  private final StudentService studentService;

  @Transactional
  @Override
  public Student execute(String id, Student student) {
    return studentService.update(id, student);
  }
}
