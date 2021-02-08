package com.ivoronline.demo_authorsbooks.repositories.security;

import com.ivoronline.demo_authorsbooks.entities.security.Profile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfileRepository extends JpaRepository<Profile, String> { }
