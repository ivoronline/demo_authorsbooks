package com.ivoronline.demo_authorsbooks.controllers;

import com.ivoronline.demo_authorsbooks.DTO.AuthorBookDTO;
import com.ivoronline.demo_authorsbooks.services.AuthorBookServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AuthorBookController {

  //======================================================================
  // SERVICES
  //======================================================================
  @Autowired AuthorBookServiceInterface authorBookServiceInterface;

  //======================================================================
  // METHOD: ADD AUTHOR BOOK
  //======================================================================
  @ResponseBody
  @RequestMapping("addAuthorBook")
  public AuthorBookDTO addAuthorBook(@RequestBody AuthorBookDTO authorBookDTO) {

    //CALL SERVICE
    AuthorBookDTO result = authorBookServiceInterface.addAuthorBook(authorBookDTO);

    //RETURN
    return result;

  }

}

