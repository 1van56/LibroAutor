package com.et.LibroAutor.service;

import com.et.LibroAutor.dto.AuthorDto;
import com.et.LibroAutor.entity.Author;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public interface AuthorService {

  Author getById(UUID id);
  List<Author> getAll();

  Author create(AuthorDto dto);

  Author update(UUID id, AuthorDto dto);

  String delete(UUID id);

  Author getByName(String name);

  Author getAuthorByBirth(LocalDate date);

}
