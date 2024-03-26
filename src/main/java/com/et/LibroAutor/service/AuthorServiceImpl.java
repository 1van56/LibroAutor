package com.et.LibroAutor.service;

import com.et.LibroAutor.dto.AuthorDto;
import com.et.LibroAutor.entity.Author;
import com.et.LibroAutor.mapper.AuthorMapper;
import com.et.LibroAutor.repository.AuthorRepository;
import jakarta.persistence.EntityNotFoundException;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AuthorServiceImpl implements AuthorService{

  private AuthorRepository authorRepository;
  private AuthorMapper authorMapper;
  @Override
  public Author getById(UUID id) {
    Author author = authorRepository.findById(id).orElseThrow(()->new EntityNotFoundException("Not Found"));
    return author;
  }

  @Override
  public List<Author> getAll() {
    List<Author> author = authorRepository.findAll();
    return author;
  }

  @Override
  public Author create(AuthorDto dto) {
    Author author = authorMapper.fromDto(dto);
    return authorRepository.save(author);
  }

  @Override
  public Author update(UUID id, AuthorDto dto) {
    Author authorfound = authorRepository.findById(id).get();
    authorfound.setName(dto.getName());
    authorfound.setGender(dto.getGender());
    authorfound.setYearOfDeath(dto.getYearOfDeath());
    authorfound.setYearOfBirth(dto.getYearOfBirth());
    authorfound.setCountry(dto.getCountry());

    return authorRepository.save(authorfound);
  }

  @Override
  public String delete(UUID id) {
    authorRepository.deleteById(id);
    return "Author Delete Successfully";
  }

  @Override
  public Author getByName(String name) {
    Author author = authorRepository.findByName(name).orElseThrow(()->new EntityNotFoundException("Not Found"));
    return author;
  }

  @Override
  public Author getAuthorByBirth(LocalDate date) {
    Author author = authorRepository.getAuthorByBirth(date).orElseThrow(()->new EntityNotFoundException("Not Found"));
    return author;
  }

}
