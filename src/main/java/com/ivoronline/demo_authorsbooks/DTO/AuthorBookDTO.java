package com.ivoronline.demo_authorsbooks.DTO;

import lombok.Data;
import org.springframework.stereotype.Component;
import java.sql.Date;

@Data
@Component
public class AuthorBookDTO {

  //AUTHOR PROPERTIES
  private Integer authorId;
  private String  name;
  private Integer age;

  //BOOK PROPERTIES
  private Integer bookId;
  private String  title;

}
