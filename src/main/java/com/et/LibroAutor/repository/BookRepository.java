package com.et.LibroAutor.repository;

import com.et.LibroAutor.entity.Author;
import com.et.LibroAutor.entity.Book;
import java.time.LocalDate;
import java.util.Optional;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, UUID> {

  @Query("SELECT a FROM Book a WHERE a.yearOfPublication = ?1")
  Optional<Book> getBookByPublication(LocalDate date);
}
