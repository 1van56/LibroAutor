package com.et.LibroAutor.dto;

import com.et.LibroAutor.entity.GenderType;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import java.sql.Types;
import java.time.LocalDate;
import java.util.UUID;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.JdbcTypeCode;

@NoArgsConstructor
@Setter
@Getter
public class AuthorDto {

  //@Column(name = "name")
  private String name;
  private GenderType gender;
  private LocalDate yearOfDeath;
  private LocalDate yearOfBirth;
  private String country;
}
