package com.ivoronline.demo_authorsbooks.entities;

import com.ivoronline.demo_authorsbooks.entities.security.Account;
import lombok.Data;
import org.springframework.stereotype.Component;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Component
public class Author {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  private String  name;
  private Integer age;
  private Date    birthday;

  @OneToMany(cascade = CascadeType.ALL)
  @JoinColumn(name = "authorId")
  private Set<Book> books = new HashSet<Book>();

}
