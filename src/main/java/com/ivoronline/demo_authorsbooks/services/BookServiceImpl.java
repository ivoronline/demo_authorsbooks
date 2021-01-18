package com.ivoronline.demo_authorsbooks.services;

import com.ivoronline.demo_authorsbooks.entities.Book;
import com.ivoronline.demo_authorsbooks.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookServiceInterface {

  @Autowired
  BookRepository bookRepository;

  public String addBook(Book book) {

    //STORE AUTHOR (BUSINESS LOGIC)
    bookRepository.save(book);

    //RETURN
    return "Book added to DB";

  }

}
