package com.ivoronline.demo_authorsbooks.controllers;

import com.ivoronline.demo_authorsbooks.entities.Book;
import com.ivoronline.demo_authorsbooks.services.BookServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
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

  //======================================================================
  // METHOD: ADD BOOK FORM
  //======================================================================
  @RequestMapping("/AddBookForm")
  public String addBookForm() {
    return "AddBookForm";
  }

  //======================================================================
  // METHOD: ADD BOOK
  //======================================================================
  @ResponseBody
  @RequestMapping("/AddBook")
  public String addBook(@RequestParam String title, @RequestParam Integer authorId) {

    //CREATE BOOK
    Book book = new Book();
    book.setTitle   (title);
    book.setAuthorId(authorId);

    //STORE BOOK
    bookService.addBook(book);

    //RETURN
    return "Book added to DB";

  }

}
