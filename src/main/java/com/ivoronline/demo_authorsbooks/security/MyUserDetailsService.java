package com.ivoronline.demo_authorsbooks.security;

import com.ivoronline.demo_authorsbooks.entities.security.Account;
import com.ivoronline.demo_authorsbooks.entities.security.Authority;
import com.ivoronline.demo_authorsbooks.entities.security.Profile;
import com.ivoronline.demo_authorsbooks.repositories.security.AccountRepository;
import com.ivoronline.demo_authorsbooks.repositories.security.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class MyUserDetailsService implements UserDetailsService {

  @Autowired
  AccountRepository accountRepository;

  @Autowired
  private ProfileRepository profileRepository;

  @Override
  @Transactional
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

    //GET ACCOUNT
    Account account = accountRepository.findByUsername(username);

    //GET PROFILE (WITH AUTHORITIES)
    Profile profile = profileRepository.findById(account.profile).get();

    //CREATE AUTHORITIES (TO CREATE USER)
    List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
    for(Authority authority : profile.authorities) {
      authorities.add(new SimpleGrantedAuthority(authority.name));
    }

    //CREATE USER
    User user = new User(account.username, account.password, true, true, true, true, authorities);

    //RETURN USER
    return user;

  }

}
