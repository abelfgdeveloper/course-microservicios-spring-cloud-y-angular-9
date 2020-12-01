package com.abelfgdeveloper.courses.users.api.student;

import com.abelfgdeveloper.courses.users.api.student.resource.request.StudentCreateRequestResource;
import com.abelfgdeveloper.courses.users.api.student.resource.response.StudentListResponseResource;
import com.abelfgdeveloper.courses.users.api.student.resource.response.StudentResponseResource;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;

public interface StudentApi {

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public StudentResponseResource create(@RequestBody StudentCreateRequestResource request);

  @PutMapping("/{id}")
  @ResponseStatus(HttpStatus.OK)
  StudentResponseResource update(
      @PathVariable String id, @RequestBody StudentCreateRequestResource request);

  @DeleteMapping("/{id}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  void deleteById(@PathVariable String id);

  @GetMapping("/{id}")
  @ResponseStatus(HttpStatus.OK)
  StudentResponseResource findById(@PathVariable String id);

  @GetMapping
  @ResponseStatus(HttpStatus.OK)
  StudentListResponseResource findAll();
}
