package com.et.LibroAutor.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.sql.Types;
import java.time.LocalDate;
import java.util.UUID;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.JdbcTypeCode;

@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name = "authors")
public class Author {
  @Id
  @GeneratedValue
  @JdbcTypeCode(Types.VARCHAR)
  private UUID id;
  //@Column(name = "name")
  private String name;
  @Enumerated(value = EnumType.STRING)
  private GenderType gender = GenderType.M;
  private LocalDate yearOfDeath;
  private LocalDate yearOfBirth;
  private String country;

}
