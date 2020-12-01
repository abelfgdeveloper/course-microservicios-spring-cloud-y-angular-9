package com.abelfgdeveloper.courses.users.usecase.impl;

import com.abelfgdeveloper.courses.users.service.StudentService;
import com.abelfgdeveloper.courses.users.usecase.StudentDeleteByIdUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Component
public class DefaultStudentDeleteByIdUseCase implements StudentDeleteByIdUseCase {

  private final StudentService studentService;

  @Transactional
  @Override
  public void execute(String id) {
    studentService.deleteById(id);
  }
}
