package com.abelfgdeveloper.courses.users.service.impl;

import com.abelfgdeveloper.courses.common.exception.client.NotFoundException;
import com.abelfgdeveloper.courses.users.domain.Student;
import com.abelfgdeveloper.courses.users.mapper.StudentMapper;
import com.abelfgdeveloper.courses.users.model.entity.StudentEntity;
import com.abelfgdeveloper.courses.users.model.repository.StudentRepository;
import com.abelfgdeveloper.courses.users.service.StudentService;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@RequiredArgsConstructor
@Service
public class DefaultStudentService implements StudentService {

  private final StudentRepository studentRepository;
  private final StudentMapper studentMapper;

  @Override
  public Student create(Student student) {
    return saveStudent(studentMapper.mapDomainToEntity(student));
  }

  @Override
  public Student update(String id, Student student) {
    StudentEntity studentInDataBase = findStudentById(id);
    studentInDataBase.setFirstName(student.getFirstName());
    studentInDataBase.setLastName(student.getLastName());
    studentInDataBase.setEmail(student.getEmail());
    return saveStudent(studentInDataBase);
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
  public List<Student> findAll(String name) {
    List<StudentEntity> students = null;
    if (StringUtils.hasLength(name)) {
      students = studentRepository.findByFirstNameOrLastName(name);
    } else {
      students = studentRepository.findAll();
    }
    return students.stream().map(studentMapper::mapEntityToDomain).collect(Collectors.toList());
  }

  private Student saveStudent(StudentEntity student) {
    return studentMapper.mapEntityToDomain(studentRepository.save(student));
  }

  private StudentEntity findStudentById(String id) {
    Optional<StudentEntity> student = studentRepository.findById(id);
    if (student.isPresent()) {
      return student.get();
    } else {
      throw new NotFoundException("Estudiante no encontrado");
    }
  }
}
