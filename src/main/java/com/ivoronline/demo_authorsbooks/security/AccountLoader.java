package com.ivoronline.demo_authorsbooks.security;

import com.ivoronline.demo_authorsbooks.entities.security.Account;
import com.ivoronline.demo_authorsbooks.repositories.security.AccountRepository;
import com.ivoronline.demo_authorsbooks.repositories.security.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Order(3)
public class AccountLoader implements CommandLineRunner {

  @Autowired
  private AccountRepository accountRepository;

  @Autowired
  private ProfileRepository profileRepository;

  @Override
  @Transactional
  public void run(String... args) throws Exception {

    //ADMIN: ANDREW
    Account admin          = new Account();
            admin.username = "adminuser";
            admin.password = "adminpassword";
            admin.profile  = "ADMIN";

    //STORE ACCOUNT INTO DB
    accountRepository.save(admin);

  }

}
