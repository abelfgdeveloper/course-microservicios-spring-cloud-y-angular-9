package com.abelfgdeveloper.courses.api.course.controller;

import com.abelfgdeveloper.courses.api.course.CourseApi;
import com.abelfgdeveloper.courses.api.course.resource.request.CourseCreateRequestResource;
import com.abelfgdeveloper.courses.api.course.resource.response.CourseListResponseResource;
import com.abelfgdeveloper.courses.api.course.resource.response.CourseResponseResource;
import com.abelfgdeveloper.courses.mapper.CourseMapper;
import com.abelfgdeveloper.courses.usecase.CourseAddStudentUseCase;
import com.abelfgdeveloper.courses.usecase.CourseCreateUseCase;
import com.abelfgdeveloper.courses.usecase.CourseDeleteByIdUseCase;
import com.abelfgdeveloper.courses.usecase.CourseDeleteStudentUseCase;
import com.abelfgdeveloper.courses.usecase.CourseFindAllUseCase;
import com.abelfgdeveloper.courses.usecase.CourseFindByIdUseCase;
import com.abelfgdeveloper.courses.usecase.CourseFindByStudentIdUseCase;
import com.abelfgdeveloper.courses.usecase.CourseUpdateUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class CourseController implements CourseApi {

  private final CourseCreateUseCase courseCreateUseCase;
  private final CourseUpdateUseCase courseUpdateUseCase;
  private final CourseDeleteByIdUseCase courseDeleteByIdUseCase;
  private final CourseFindByIdUseCase courseFindByIdUseCase;
  private final CourseFindAllUseCase courseFindAllUseCase;
  private final CourseAddStudentUseCase courseAddStudentUseCase;
  private final CourseDeleteStudentUseCase courseDeleteStudentUseCase;
  private final CourseFindByStudentIdUseCase courseFindByStudentIdUseCase;

  private final CourseMapper courseMapper;

  @Override
  public CourseResponseResource create(CourseCreateRequestResource request) {
    return courseMapper.mapDomainToResource(
        courseCreateUseCase.execute(courseMapper.mapResourceToDomain(request)));
  }

  @Override
  public CourseResponseResource update(String id, CourseCreateRequestResource request) {
    return courseMapper.mapDomainToResource(
        courseUpdateUseCase.execute(id, courseMapper.mapResourceToDomain(request)));
  }

  @Override
  public void deleteById(String id) {
    courseDeleteByIdUseCase.execute(id);
  }

  @Override
  public CourseResponseResource findById(String id) {
    return courseMapper.mapDomainToResource(courseFindByIdUseCase.execute(id));
  }

  @Override
  public CourseListResponseResource findAll() {
    return courseMapper.mapDomainToResource(courseFindAllUseCase.execute());
  }

  @Override
  public CourseResponseResource addStudent(String id, String studentId) {
    return courseMapper.mapDomainToResource(courseAddStudentUseCase.execute(id, studentId));
  }

  @Override
  public CourseResponseResource deleteStudent(String id, String studentId) {
    return courseMapper.mapDomainToResource(courseDeleteStudentUseCase.execute(id, studentId));
  }

  @Override
  public CourseListResponseResource findByStudentId(String studentId) {
    return courseMapper.mapDomainToResource(courseFindByStudentIdUseCase.execute(studentId));
  }
}
