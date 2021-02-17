package com.ivoronline.demo_authorsbooks.services;

import com.ivoronline.demo_authorsbooks.DTO.AuthorBookDTO;
import com.ivoronline.demo_authorsbooks.entities.Author;
import com.ivoronline.demo_authorsbooks.entities.Book;
import com.ivoronline.demo_authorsbooks.repositories.AuthorRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorBookServiceImpl implements AuthorBookServiceInterface {

  @Autowired
  AuthorRepository authorRepository;

  @Override
  public AuthorBookDTO addAuthorBook(AuthorBookDTO authorBookDTO) {

    //INSTANTIATE MODEL MAPPER
    ModelMapper modelMapper = new ModelMapper();
                modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

    //CONVERT DTOs TO ENTITIESs
    Book   book   = modelMapper.map(authorBookDTO, Book  .class);
    Author author = modelMapper.map(authorBookDTO, Author.class);
           author.getBooks().add(book);

    //SAVE AUTHOR & BOOK
    authorRepository.save(author);

    //UPDATE DTO
    authorBookDTO.setAuthorId(author.getId());
    authorBookDTO.setBookId(book.getId());

    //RETURN
    return authorBookDTO;

  }

}
