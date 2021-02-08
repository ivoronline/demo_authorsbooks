package com.ivoronline.demo_authorsbooks.controllers;

import com.ivoronline.demo_authorsbooks.entities.Book;
import com.ivoronline.demo_authorsbooks.entities.security.Account;
import com.ivoronline.demo_authorsbooks.repositories.security.AccountRepository;
import com.ivoronline.demo_authorsbooks.security.MyUserDetailsService;
import com.ivoronline.demo_authorsbooks.services.BookServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class BookController {

  //======================================================================
  // SERVICES
  //======================================================================
  @Autowired BookServiceInterface bookService;
  @Autowired MyUserDetailsService myUserDetailsService;
  @Autowired AccountRepository    accountRepository;

  //======================================================================
  // METHOD: ADD BOOK FORM
  //======================================================================
  @RequestMapping("/AddBookForm")
  @PreAuthorize("hasAuthority('book.create')")
  public String addBookForm() {
    return "AddBookForm";
  }

  //======================================================================
  // METHOD: ADD BOOK
  //======================================================================
  @ResponseBody
  @RequestMapping("/AddBook")
  @PreAuthorize("hasAuthority('book.create')")
  public String addBook(@RequestParam String title) {

    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    String         username       = authentication.getName();
    Account        account        = accountRepository.findByUsername(username);
    Integer        authorId       = account.author.getId();

    //CREATE BOOK
    Book  book = new Book();
          book.setTitle   (title);
          book.setAuthorId(authorId);

    //STORE BOOK
    bookService.addBook(book);

    //RETURN
    return "Book added to DB";

  }

}
