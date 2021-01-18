package com.ivoronline.demo_authorsbooks.services;

import com.ivoronline.demo_authorsbooks.entities.Author;
import com.ivoronline.demo_authorsbooks.repositories.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorServiceImpl implements AuthorServiceInterface {

  @Autowired
  AuthorRepository authorRepository;

  @Override
  public String addAuthor(Author author) {

    //STORE AUTHOR (BUSINESS LOGIC)
    authorRepository.save(author);

    //RETURN
    return "Author added to DB";

  }

}
