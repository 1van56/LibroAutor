package com.et.LibroAutor.controller;

import com.et.LibroAutor.dto.AuthorDto;
import com.et.LibroAutor.entity.Author;
import com.et.LibroAutor.entity.Book;
import com.et.LibroAutor.service.AuthorService;
import com.et.LibroAutor.service.BookService;
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
@RequestMapping("/books")
@AllArgsConstructor
public class BookController {
  private BookService bookService;
  @GetMapping("/{id}")
  public ResponseEntity<Book> getById(@PathVariable UUID id){
    Book bookFound = bookService.getById(id);
    return ResponseEntity.status(HttpStatus.OK).body(bookFound);
  }

  @GetMapping
  public ResponseEntity<List<Book>> getAll(){
    List<Book> bookAllFound = bookService.getAll();
    return ResponseEntity.status(HttpStatus.OK).body(bookAllFound);
  }

  @PostMapping
  public ResponseEntity<Book> create(@RequestBody Book book){
    Book bookSaved = bookService.create(book);
    return ResponseEntity.status(HttpStatus.CREATED).body(bookSaved);
  }

  @PutMapping("/{id}")
  public ResponseEntity<Book> update(@PathVariable UUID id, @RequestBody Book book){
    Book bookupdate = bookService.update(id, book);
    return ResponseEntity.status(HttpStatus.OK).body(bookupdate);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<String> delete(@PathVariable UUID id){
    String message = bookService.delete(id);
    return ResponseEntity.status(HttpStatus.OK).body(message);
  }

  @GetMapping("/publication/{date}")
  public ResponseEntity<Book> getAuthorByBirth(@PathVariable LocalDate date){
    Book bookFound = bookService.getBookByPublication(date);
    return ResponseEntity.status(HttpStatus.OK).body(bookFound);
  }
}
