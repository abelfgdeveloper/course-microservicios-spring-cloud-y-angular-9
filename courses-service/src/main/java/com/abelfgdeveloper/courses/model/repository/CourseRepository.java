package com.abelfgdeveloper.courses.model.repository;

import com.abelfgdeveloper.courses.model.entity.CourseEntity;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CourseRepository extends JpaRepository<CourseEntity, String> {

  Optional<CourseEntity> findByName(String name);

  @Query("SELECT c FROM CourseEntity c WHERE :studentId MEMBER OF c.students")
  Optional<CourseEntity> findByStudentId(String studentId);
}
