package com.et.LibroAutor.mapper;

import com.et.LibroAutor.dto.AuthorDto;
import com.et.LibroAutor.entity.Author;
import org.springframework.stereotype.Component;

@Component
public class AuthorMapper {

  public Author fromDto (AuthorDto dto){
    Author author = new Author();

    author.setName(dto.getName());
    author.setGender(dto.getGender());
    author.setYearOfDeath(dto.getYearOfDeath());
    author.setYearOfBirth(dto.getYearOfBirth());
    author.setCountry(dto.getCountry());

    return author;
  }
}
