package com.abelfgdeveloper.courses.users.service.impl;

import com.abelfgdeveloper.courses.users.domain.Student;
import com.abelfgdeveloper.courses.users.mapper.StudentMapper;
import com.abelfgdeveloper.courses.users.model.entity.StudentEntity;
import com.abelfgdeveloper.courses.users.repository.StudentRepository;
import com.abelfgdeveloper.courses.users.service.StudentService;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class DefaultStudentService implements StudentService {

  private final StudentRepository studentRepository;
  private final StudentMapper studentMapper;

  @Override
  public Student create(Student student) {
    return studentMapper.mapEntityToDomain(
        studentRepository.save(studentMapper.mapDomainToEntity(student)));
  }

  @Override
  public Student update(String id, Student student) {
    StudentEntity studentEntity = findStudentById(id);
    studentEntity.setFirstName(student.getFirstName());
    studentEntity.setLastName(student.getLastName());
    studentEntity.setEmail(student.getEmail());
    return studentMapper.mapEntityToDomain(studentRepository.save(studentEntity));
  }

  @Override
  public void deleteById(String id) {
    studentRepository.delete(findStudentById(id));
  }

  @Override
  public Student findById(String id) {
    return studentMapper.mapEntityToDomain(findStudentById(id));
  }

  @Override
  public List<Student> findAll() {
    return studentRepository
        .findAll()
        .stream()
        .map(studentMapper::mapEntityToDomain)
        .collect(Collectors.toList());
  }

  private StudentEntity findStudentById(String id) {
    Optional<StudentEntity> student = studentRepository.findById(id);
    if (student.isPresent()) {
      return student.get();
    } else {
      throw new RuntimeException("Studiante no encontrado");
    }
  }
}
