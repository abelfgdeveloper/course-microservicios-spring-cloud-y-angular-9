package com.abelfgdeveloper.courses.mapper;

import com.abelfgdeveloper.courses.api.course.resource.request.CourseCreateRequestResource;
import com.abelfgdeveloper.courses.api.course.resource.request.CourseUpdateRequestResource;
import com.abelfgdeveloper.courses.api.course.resource.response.CourseListResponseResource;
import com.abelfgdeveloper.courses.api.course.resource.response.CourseResponseResource;
import com.abelfgdeveloper.courses.domain.Course;
import com.abelfgdeveloper.courses.model.entity.CourseEntity;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;

@Component
public class CourseMapper {

  public Course mapEntityToDomain(CourseEntity course) {
    return Course.builder()
        .id(course.getId())
        .name(course.getName())
        .students(course.getStudents())
        .build();
  }

  public CourseEntity mapDomainToEntity(Course course) {
    return CourseEntity.builder().name(course.getName()).build();
  }

  public CourseResponseResource mapDomainToResource(Course course) {
    return CourseResponseResource.builder()
        .id(course.getId())
        .name(course.getName())
        .students(course.getStudents())
        .build();
  }

  public CourseListResponseResource mapDomainToResource(List<Course> courses) {
    return CourseListResponseResource.builder()
        .courses(courses.stream().map(this::mapDomainToResource).collect(Collectors.toList()))
        .build();
  }

  public Course mapResourceToDomain(CourseCreateRequestResource course) {
    return Course.builder().name(course.getName()).build();
  }

  public Course mapResourceToDomain(CourseUpdateRequestResource course) {
    return Course.builder().name(course.getName()).build();
  }
}
