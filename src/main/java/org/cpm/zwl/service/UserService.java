package org.cpm.zwl.service;

import org.cpm.zwl.dao.entity.User;

public interface UserService {

  void save(User user);

  User findByUsername(String username);
}
