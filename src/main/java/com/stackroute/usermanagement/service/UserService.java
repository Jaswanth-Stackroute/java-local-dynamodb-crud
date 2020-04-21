package com.stackroute.usermanagement.service;

import com.stackroute.usermanagement.domain.User;

import java.util.List;

public interface UserService {
   List<User> addUsers(List<User> useList);
   User addUser (User user);
   List<User> getUsers ();
}
