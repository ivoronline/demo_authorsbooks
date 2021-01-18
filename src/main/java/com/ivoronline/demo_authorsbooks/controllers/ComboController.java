package com.ivoronline.demo_authorsbooks.controllers;

import com.ivoronline.demo_authorsbooks.entities.Author;
import com.ivoronline.demo_authorsbooks.services.ComboServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ComboController {

  //======================================================================
  // SERVICES
  //======================================================================
  @Autowired
  ComboServiceInterface comboService;

  //======================================================================
  // METHOD: GET BOOKS FORM
  //======================================================================
  @RequestMapping("/GetBooksForm")
  public String getBooksForm() {
    return "GetBooksForm";
  }

  //======================================================================
  // METHOD: GET BOOKS
  //======================================================================
  @ResponseBody
  @RequestMapping("/GetBooks")
  public String getBooks(@RequestParam Integer authorId) {

    //CREATE AUTHOR
    Author author = new Author();
    author.setId(authorId);

    //CALL SERVICE (BUSINESS LOGIC)
    String result = comboService.getBooks(author);

    //RETURN
    return result;

  }

}
