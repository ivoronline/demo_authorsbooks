package com.ivoronline.demo_authorsbooks.security;

import com.ivoronline.demo_authorsbooks.entities.security.Authority;
import com.ivoronline.demo_authorsbooks.repositories.security.AuthorityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Order(1)
public class AuthorityLoader implements CommandLineRunner {

  @Autowired
  private AuthorityRepository authorityRepository;

  @Override
  @Transactional
  public void run(String... args) throws Exception {
    authorityRepository.save(new Authority("book.create"));
    authorityRepository.save(new Authority("book.read"));
    authorityRepository.save(new Authority("book.update"));
    authorityRepository.save(new Authority("book.delete"));
    authorityRepository.save(new Authority("author.create"));
    authorityRepository.save(new Authority("author.read"));
    authorityRepository.save(new Authority("author.update"));
    authorityRepository.save(new Authority("author.delete"));
  }

}

