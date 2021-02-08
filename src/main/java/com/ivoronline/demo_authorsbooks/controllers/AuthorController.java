package com.ivoronline.demo_authorsbooks.controllers;

import com.ivoronline.demo_authorsbooks.entities.Author;
import com.ivoronline.demo_authorsbooks.entities.security.Account;
import com.ivoronline.demo_authorsbooks.repositories.security.AccountRepository;
import com.ivoronline.demo_authorsbooks.services.AuthorServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.sql.Date;

@Controller
public class AuthorController {

  //======================================================================
  // SERVICES
  //======================================================================
  @Autowired AuthorServiceInterface authorService;
  @Autowired AccountRepository      accountRepository;

  //======================================================================
  // METHOD: ADD AUTHOR FORM
  //======================================================================
  @RequestMapping("/AddAuthorForm")
  @PreAuthorize("hasAuthority('author.create')")
  public String addAuthorForm() {
    return "AddAuthorForm";
  }

  //======================================================================
  // METHOD: ADD AUTHOR
  //======================================================================
  @ResponseBody
  @RequestMapping("/AddAuthor")
  @PreAuthorize("hasAuthority('author.create')")
  public String addAuthor(
    @RequestParam String  name,
    @RequestParam Integer age,
    @RequestParam Date    birthday,
    @RequestParam String  username,
    @RequestParam String  password,
    @RequestParam String  profile
  ) {

    //CREATE AUTHOR
    Author  author = new Author();
            author.setName    (name);
            author.setAge     (age);
            author.setBirthday(birthday);

    //CREATE ACCOUNT
    Account account = new Account();
            account.username = username;
            account.password = password;
            account.profile  = profile;
            account.author   = author;

    //STORE ACCOUNT
    accountRepository.save(account);

    //RETURN
    return "Author added";

  }

}
