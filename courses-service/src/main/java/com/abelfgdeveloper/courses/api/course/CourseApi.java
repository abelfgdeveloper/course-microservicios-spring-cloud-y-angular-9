package com.abelfgdeveloper.courses.api.course;

import com.abelfgdeveloper.courses.api.course.resource.request.CourseCreateRequestResource;
import com.abelfgdeveloper.courses.api.course.resource.response.CourseListResponseResource;
import com.abelfgdeveloper.courses.api.course.resource.response.CourseResponseResource;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;

public interface CourseApi {

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public CourseResponseResource create(@RequestBody CourseCreateRequestResource request);

  @PutMapping("/{id}")
  @ResponseStatus(HttpStatus.OK)
  CourseResponseResource update(
      @PathVariable String id, @RequestBody CourseCreateRequestResource request);

  @DeleteMapping("/{id}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  void deleteById(@PathVariable String id);

  @GetMapping("/{id}")
  @ResponseStatus(HttpStatus.OK)
  CourseResponseResource findById(@PathVariable String id);

  @GetMapping
  @ResponseStatus(HttpStatus.OK)
  CourseListResponseResource findAll();

  @PutMapping("/{id}/students/{studentId}")
  @ResponseStatus(HttpStatus.OK)
  public CourseResponseResource addStudent(@PathVariable String id, @PathVariable String studentId);

  @DeleteMapping("/{id}/students/{studentId}")
  @ResponseStatus(HttpStatus.OK)
  public CourseResponseResource deleteStudent(
      @PathVariable String id, @PathVariable String studentId);

  @GetMapping("/students/{studentId}")
  @ResponseStatus(HttpStatus.OK)
  CourseListResponseResource findByStudentId(@PathVariable String studentId);
}
