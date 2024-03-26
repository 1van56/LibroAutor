package com.et.LibroAutor.service;

import com.et.LibroAutor.dto.AuthorDto;
import com.et.LibroAutor.entity.Author;
import com.et.LibroAutor.entity.Book;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public interface BookService {
  Book getById(UUID id);
  List<Book> getAll();

  Book create(Book book);

  Book update(UUID id, Book book);

  String delete(UUID id);

  Book getBookByPublication(LocalDate date);
}
