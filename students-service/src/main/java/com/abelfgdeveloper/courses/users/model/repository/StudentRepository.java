package com.abelfgdeveloper.courses.users.model.repository;

import com.abelfgdeveloper.courses.users.model.entity.StudentEntity;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface StudentRepository extends JpaRepository<StudentEntity, String> {

  @Query(
      "SELECT s FROM StudentEntity s WHERE s.firstName LIKE %:param% OR s.lastName LIKE %:param%")
  List<StudentEntity> findByFirstNameOrLastName(String param);
}
