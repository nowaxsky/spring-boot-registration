package org.cpm.zwl.service.impl;

import java.util.HashSet;
import java.util.Set;
import org.cpm.zwl.dao.entity.Role;
import org.cpm.zwl.dao.entity.User;
import org.cpm.zwl.dao.persistence.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

  @Autowired
  private UserRepository userRepository;

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    User user = userRepository.findByUsername(username);

    Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
    for (Role role : user.getRoles()) {
      grantedAuthorities.add(new SimpleGrantedAuthority(role.getRoleId()));
    }

    return new org.springframework.security.core.userdetails.User(user.getUsername(),
        user.getPassword(), grantedAuthorities);
  }
}
