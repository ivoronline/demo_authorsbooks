package com.ivoronline.demo_authorsbooks.repositories.security;

import com.ivoronline.demo_authorsbooks.entities.security.Authority;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorityRepository extends JpaRepository<Authority, String> { }
