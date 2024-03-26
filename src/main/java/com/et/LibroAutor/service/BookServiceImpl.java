package com.et.LibroAutor.service;

import com.et.LibroAutor.entity.Author;
import com.et.LibroAutor.entity.Book;
import com.et.LibroAutor.mapper.BookMapper;
import com.et.LibroAutor.repository.BookRepository;
import jakarta.persistence.EntityNotFoundException;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class BookServiceImpl implements BookService{

  private BookRepository bookRepository;
  private BookMapper bookMapper;

  @Override
  public Book getById(UUID id) {
    Book book = bookRepository.findById(id).orElseThrow(()->new EntityNotFoundException("Not Found"));
    return book;
  }

  @Override
  public List<Book> getAll() {
    List<Book> book = bookRepository.findAll();
    return book;
  }

  @Override
  public Book create(Book bookNew) {
    Book book = bookMapper.from(bookNew);
    return bookRepository.save(book);
  }

  @Override
  public Book update(UUID id, Book book) {
    Book bookFound = bookRepository.findById(id).get();
    bookFound.setTitle(book.getTitle());
    bookFound.setYearOfPublication(book.getYearOfPublication());

    return bookRepository.save(bookFound);
  }

  @Override
  public String delete(UUID id) {
    bookRepository.deleteById(id);
    return "Book Delete Successfully";
  }

  @Override
  public Book getBookByPublication(LocalDate date) {
    Book book = bookRepository.getBookByPublication(date).orElseThrow(()->new EntityNotFoundException("Not Found"));
    return book;
  }
}
