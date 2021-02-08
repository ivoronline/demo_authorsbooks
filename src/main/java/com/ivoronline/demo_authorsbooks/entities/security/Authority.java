package com.ivoronline.demo_authorsbooks.entities.security;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Authority {

  @Id
  public String name;

  //CONSTRUCTORS
  public Authority() { }                               //Forced by @Entity
  public Authority(String name) { this.name = name; }  //To simplify AuthorityLoader

}

