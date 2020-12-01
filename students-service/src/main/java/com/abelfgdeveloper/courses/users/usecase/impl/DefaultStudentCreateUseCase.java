package com.abelfgdeveloper.courses.users.usecase.impl;

import com.abelfgdeveloper.courses.users.domain.Student;
import com.abelfgdeveloper.courses.users.service.StudentService;
import com.abelfgdeveloper.courses.users.usecase.StudentCreateUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Component
public class DefaultStudentCreateUseCase implements StudentCreateUseCase {

  private final StudentService studentService;

  @Transactional
  @Override
  public Student execute(Student student) {
    return studentService.create(student);
  }
}
