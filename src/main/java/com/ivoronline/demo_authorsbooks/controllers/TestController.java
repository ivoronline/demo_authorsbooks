package com.ivoronline.demo_authorsbooks.controllers;

import com.ivoronline.demo_authorsbooks.entities.Author;
import com.ivoronline.demo_authorsbooks.services.AuthorServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.Date;

@Controller
public class TestController {

  //======================================================================
  // METHOD: TEST
  //======================================================================
  @ResponseBody
  @RequestMapping("/Test")
  public String test() {
    return "Hello from Application: Authors Books <br> Branch: Step1_Basic 1";
  }

}
