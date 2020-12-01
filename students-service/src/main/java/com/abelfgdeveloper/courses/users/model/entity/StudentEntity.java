package com.abelfgdeveloper.courses.users.model.entity;

import java.time.LocalDateTime;
import java.util.UUID;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
@Entity
@Table(name = "students")
public class StudentEntity {

  @Id @EqualsAndHashCode.Include private String id;
  private String firstName;
  private String lastName;
  private String email;
  private LocalDateTime createAt;

  @PrePersist
  private void prePersist() {
    this.id = UUID.randomUUID().toString();
    this.createAt = LocalDateTime.now();
  }
}
