package com.abelfgdeveloper.courses.users.mapper;

import com.abelfgdeveloper.courses.users.api.student.resource.request.StudentCreateRequestResource;
import com.abelfgdeveloper.courses.users.api.student.resource.request.StudentUpdateRequestResource;
import com.abelfgdeveloper.courses.users.api.student.resource.response.StudentListResponseResource;
import com.abelfgdeveloper.courses.users.api.student.resource.response.StudentResponseResource;
import com.abelfgdeveloper.courses.users.domain.Student;
import com.abelfgdeveloper.courses.users.model.entity.StudentEntity;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;

@Component
public class StudentMapper {

  public Student mapEntityToDomain(StudentEntity student) {
    return Student.builder()
        .id(student.getId())
        .firstName(student.getFirstName())
        .lastName(student.getLastName())
        .email(student.getEmail())
        .createAt(student.getCreateAt())
        .build();
  }

  public StudentEntity mapDomainToEntity(Student student) {
    return StudentEntity.builder()
        .firstName(student.getFirstName())
        .lastName(student.getLastName())
        .email(student.getEmail())
        .build();
  }

  public Student mapResourceToDomain(StudentCreateRequestResource student) {
    return Student.builder()
        .firstName(student.getFirstName())
        .lastName(student.getLastName())
        .email(student.getEmail())
        .build();
  }

  public Student mapToDomain(StudentUpdateRequestResource student) {
    return Student.builder()
        .firstName(student.getFirstName())
        .lastName(student.getLastName())
        .email(student.getEmail())
        .build();
  }

  public StudentResponseResource mapDomainToResource(Student student) {
    return StudentResponseResource.builder()
        .id(student.getId())
        .firstName(student.getFirstName())
        .lastName(student.getLastName())
        .email(student.getEmail())
        .createAt(student.getCreateAt())
        .build();
  }

  public StudentListResponseResource mapDomainToResource(List<Student> students) {
    return StudentListResponseResource.builder()
        .students(students.stream().map(this::mapDomainToResource).collect(Collectors.toList()))
        .build();
  }
}
