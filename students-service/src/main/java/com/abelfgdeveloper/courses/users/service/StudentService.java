package com.abelfgdeveloper.courses.users.service;

import com.abelfgdeveloper.courses.users.domain.Student;
import java.util.List;

public interface StudentService {

  Student create(Student student);

  Student update(String id, Student student);

  void deleteById(String id);

  Student findById(String id);

  List<Student> findAll(String name);
}
