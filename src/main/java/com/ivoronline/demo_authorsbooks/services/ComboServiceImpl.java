package com.ivoronline.demo_authorsbooks.services;

import com.ivoronline.demo_authorsbooks.entities.Author;
import com.ivoronline.demo_authorsbooks.entities.Book;
import com.ivoronline.demo_authorsbooks.repositories.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;

@Service
public class ComboServiceImpl implements ComboServiceInterface {

  @Autowired
  AuthorRepository authorRepository;

  public String getBooks(Author author) {

    //GET AUTHOR & BOOKS
    Optional<Author> authorOptional = authorRepository.findById(author.getId());
    author         = authorOptional.get();
    Set<Book>        books          = author.getBooks();

    //DISPLAY BOOKS
    String result = "<h2> Books by " + author.getName() + "</h2>";
    for(Book book : books) {
      result += book.getTitle() + "<br>";
    }

    //RETURN
    return result;

  }

}
