package com.abelfgdeveloper.courses.users.api.student.controller;

import com.abelfgdeveloper.courses.users.api.student.StudentApi;
import com.abelfgdeveloper.courses.users.api.student.resource.request.StudentCreateRequestResource;
import com.abelfgdeveloper.courses.users.api.student.resource.response.StudentListResponseResource;
import com.abelfgdeveloper.courses.users.api.student.resource.response.StudentResponseResource;
import com.abelfgdeveloper.courses.users.mapper.StudentMapper;
import com.abelfgdeveloper.courses.users.usecase.StudentCreateUseCase;
import com.abelfgdeveloper.courses.users.usecase.StudentDeleteByIdUseCase;
import com.abelfgdeveloper.courses.users.usecase.StudentFindAllUseCase;
import com.abelfgdeveloper.courses.users.usecase.StudentFindByIdUseCase;
import com.abelfgdeveloper.courses.users.usecase.StudentUpdateUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class StudentController implements StudentApi {

  private final StudentCreateUseCase studentCreateUseCase;
  private final StudentUpdateUseCase studentUpdateUseCase;
  private final StudentDeleteByIdUseCase studentDeleteByIdUseCase;
  private final StudentFindByIdUseCase studentFindByIdUseCase;
  private final StudentFindAllUseCase studentFindAllUseCase;

  private final StudentMapper studentMapper;

  @Override
  public StudentResponseResource create(StudentCreateRequestResource request) {
    return studentMapper.mapDomainToResource(
        studentCreateUseCase.execute(studentMapper.mapResourceToDomain(request)));
  }

  @Override
  public StudentResponseResource update(String id, StudentCreateRequestResource request) {
    return studentMapper.mapDomainToResource(
        studentUpdateUseCase.execute(id, studentMapper.mapResourceToDomain(request)));
  }

  @Override
  public void deleteById(String id) {
    studentDeleteByIdUseCase.execute(id);
  }

  @Override
  public StudentResponseResource findById(String id) {
    return studentMapper.mapDomainToResource(studentFindByIdUseCase.execute(id));
  }

  @Override
  public StudentListResponseResource findAll(String name) {
    return studentMapper.mapDomainToResource(studentFindAllUseCase.execute(name));
  }
}
