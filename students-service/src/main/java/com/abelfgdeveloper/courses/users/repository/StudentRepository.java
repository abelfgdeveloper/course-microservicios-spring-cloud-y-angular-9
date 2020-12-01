package com.abelfgdeveloper.courses.users.repository;

import com.abelfgdeveloper.courses.users.model.entity.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<StudentEntity, String> {}
