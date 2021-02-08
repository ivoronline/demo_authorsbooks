package com.ivoronline.demo_authorsbooks.security;

import com.ivoronline.demo_authorsbooks.entities.security.Authority;
import com.ivoronline.demo_authorsbooks.entities.security.Profile;
import com.ivoronline.demo_authorsbooks.repositories.security.AuthorityRepository;
import com.ivoronline.demo_authorsbooks.repositories.security.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Order(2)
public class ProfileLoader implements CommandLineRunner {

  @Autowired
  private ProfileRepository profileRepository;

  @Autowired
  private AuthorityRepository authorityRepository;

  @Override
  @Transactional
  public void run(String... args) throws Exception {

    //GET BOOK AUTHORITIES.
    Authority bookCreate = authorityRepository.findById("book.create").get();
    Authority bookRead   = authorityRepository.findById("book.read"  ).get();
    Authority bookUpdate = authorityRepository.findById("book.update").get();
    Authority bookDelete = authorityRepository.findById("book.delete").get();

    //GET AUTHOR AUTHORITIES.
    Authority authorCreate = authorityRepository.findById("author.create").get();
    Authority authorRead   = authorityRepository.findById("author.read"  ).get();
    Authority authorUpdate = authorityRepository.findById("author.update").get();
    Authority authorDelete = authorityRepository.findById("author.delete").get();

    //USER
    Profile user      = new Profile();
            user.name = "USER";
            user.authorities.add(bookCreate);
            user.authorities.add(bookRead);
            user.authorities.add(bookUpdate);
            user.authorities.add(bookDelete);

    //ADMIN
    Profile admin      = new Profile();
            admin.name = "ADMIN";
            admin.authorities.add(bookCreate);
            admin.authorities.add(bookRead);
            admin.authorities.add(bookUpdate);
            admin.authorities.add(bookDelete);
            admin.authorities.add(authorCreate);
            admin.authorities.add(authorRead);
            admin.authorities.add(authorUpdate);
            admin.authorities.add(authorDelete);

    //STORE PROFILES INTO DB
    profileRepository.save(user);
    profileRepository.save(admin);

  }

}
