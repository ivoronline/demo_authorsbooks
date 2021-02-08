package com.ivoronline.demo_authorsbooks.repositories.security;

import com.ivoronline.demo_authorsbooks.entities.security.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Integer> {
  Account findByUsername(String Username);
}
