package com.abelfgdeveloper.courses.service.impl;

import com.abelfgdeveloper.courses.common.exception.client.BadRequestException;
import com.abelfgdeveloper.courses.common.exception.client.NotFoundException;
import com.abelfgdeveloper.courses.domain.Course;
import com.abelfgdeveloper.courses.mapper.CourseMapper;
import com.abelfgdeveloper.courses.model.entity.CourseEntity;
import com.abelfgdeveloper.courses.model.repository.CourseRepository;
import com.abelfgdeveloper.courses.service.CourseService;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class DefaultCourseService implements CourseService {

  private final CourseRepository courseRepository;
  private final CourseMapper courseMapper;

  @Override
  public Course create(Course course) {
    validateNameNotExist(course.getName());
    return saveCourse(courseMapper.mapDomainToEntity(course));
  }

  @Override
  public Course update(String id, Course course) {
    CourseEntity courseInDataBase = findCourseById(id);
    if (courseInDataBase.getName().equals(course.getName())) {
      return courseMapper.mapEntityToDomain(courseInDataBase);
    }

    validateNameNotExist(course.getName());
    courseInDataBase.setName(course.getName());

    return saveCourse(courseInDataBase);
  }

  @Override
  public void deleteById(String id) {
    courseRepository.delete(findCourseById(id));
  }

  @Override
  public Course findById(String id) {
    return courseMapper.mapEntityToDomain(findCourseById(id));
  }

  @Override
  public List<Course> findAll() {
    return courseRepository
        .findAll()
        .stream()
        .map(courseMapper::mapEntityToDomain)
        .collect(Collectors.toList());
  }

  private Course saveCourse(CourseEntity course) {
    return courseMapper.mapEntityToDomain(courseRepository.save(course));
  }

  private CourseEntity findCourseById(String id) {
    Optional<CourseEntity> course = courseRepository.findById(id);
    if (course.isPresent()) {
      return course.get();
    } else {
      throw new NotFoundException("Curso no encontrado");
    }
  }

  private void validateNameNotExist(String name) {
    Optional<CourseEntity> course = courseRepository.findByName(name);
    if (course.isPresent()) {
      throw new BadRequestException("El nombre del curso ya existe");
    }
  }

  @Override
  public Course addStudent(String id, String studentId) {
    CourseEntity course = findCourseById(id);
    if (course.getStudents().contains(studentId)) {
      throw new BadRequestException("El estudiante ya esta dado de alta en el curso");
    }
    course.getStudents().add(studentId);
    return saveCourse(course);
  }

  @Override
  public Course deleteStudent(String id, String studentId) {
    CourseEntity course = findCourseById(id);
    if (!course.getStudents().contains(studentId)) {
      throw new BadRequestException("El estudiante no esta dado de alta en el curso");
    }
    course.getStudents().remove(studentId);
    return saveCourse(course);
  }

  @Override
  public List<Course> findByStudentId(String studentId) {
    return courseRepository
        .findByStudentId(studentId)
        .stream()
        .map(courseMapper::mapEntityToDomain)
        .collect(Collectors.toList());
  }
}
