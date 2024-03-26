package com.et.LibroAutor.mapper;


import com.et.LibroAutor.entity.Book;
import org.springframework.stereotype.Component;

@Component
public class BookMapper {
  public Book from (Book bookNew){
    Book book = new Book();
    book.setTitle(bookNew.getTitle());
    book.setYearOfPublication(bookNew.getYearOfPublication());


    return book;
  }
}
