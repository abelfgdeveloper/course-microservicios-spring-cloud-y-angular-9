package com.abelfgdeveloper.courses.users.usecase.impl;

import com.abelfgdeveloper.courses.users.domain.Student;
import com.abelfgdeveloper.courses.users.service.StudentService;
import com.abelfgdeveloper.courses.users.usecase.StudentFindAllUseCase;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Component
public class DefaultStudentFindAllUseCase implements StudentFindAllUseCase {

  private final StudentService studentService;

  @Transactional(readOnly = true)
  @Override
  public List<Student> execute(String name) {
    return studentService.findAll(name);
  }
}
