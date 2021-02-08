package com.ivoronline.demo_authorsbooks.entities.security;

import com.ivoronline.demo_authorsbooks.entities.Author;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Account {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  public Integer id;
  public String  username;
  public String  password;

  //FOREIGN KEY
  public String profile;

  @OneToOne(cascade = CascadeType.ALL)
  public Author author;

}
