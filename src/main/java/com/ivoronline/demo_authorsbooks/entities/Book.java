package com.ivoronline.demo_authorsbooks.entities;

import lombok.Data;
import org.springframework.stereotype.Component;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
@Component
public class Book {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;           //PRIMARY KEY

  private Integer authorId;     //FOREIGN KEY

  private String  title;

}
