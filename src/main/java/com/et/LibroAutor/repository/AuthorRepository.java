package com.et.LibroAutor.repository;

import com.et.LibroAutor.entity.Author;
import java.time.LocalDate;
import java.util.Optional;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends JpaRepository<Author, UUID> {
  Optional<Author> findByName(String name);

  @Query("SELECT a FROM Author a WHERE a.yearOfBirth = ?1")
  Optional<Author> getAuthorByBirth(LocalDate date);
}
