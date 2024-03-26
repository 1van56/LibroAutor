package com.et.LibroAutor.controller;

import com.et.LibroAutor.dto.AuthorDto;
import com.et.LibroAutor.entity.Author;
import com.et.LibroAutor.service.AuthorService;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/authors")
@AllArgsConstructor
public class AuthorController {

  private AuthorService authorService;
  @GetMapping("/{id}")
  public ResponseEntity<Author> getById(@PathVariable UUID id){
    Author authorFound = authorService.getById(id);
    return ResponseEntity.status(HttpStatus.OK).body(authorFound);
  }

  @GetMapping
  public ResponseEntity<List<Author>> getAll(){
    List<Author> authorAllFound = authorService.getAll();
    return ResponseEntity.status(HttpStatus.OK).body(authorAllFound);
  }

  @PostMapping
  public ResponseEntity<Author> create(@RequestBody AuthorDto dto){
    Author authorSaved = authorService.create(dto);
    return ResponseEntity.status(HttpStatus.CREATED).body(authorSaved);
  }

  @PutMapping("/{id}")
  public ResponseEntity<Author> update(@PathVariable UUID id, @RequestBody AuthorDto dto){
    Author authorupdate = authorService.update(id, dto);
    return ResponseEntity.status(HttpStatus.OK).body(authorupdate);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<String> delete(@PathVariable UUID id){
    String message = authorService.delete(id);
    return ResponseEntity.status(HttpStatus.OK).body(message);
  }

  @GetMapping("/name/{name}")
  public ResponseEntity<Author> getByName(@PathVariable String name){
    Author authorFound = authorService.getByName(name);
    return ResponseEntity.status(HttpStatus.OK).body(authorFound);
  }

  @GetMapping("/birth/{date}")
  public ResponseEntity<Author> getAuthorByBirth(@PathVariable LocalDate date){
    Author authorFound = authorService.getAuthorByBirth(date);
    return ResponseEntity.status(HttpStatus.OK).body(authorFound);
  }

}
