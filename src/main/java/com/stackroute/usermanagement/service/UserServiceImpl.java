package com.stackroute.usermanagement.service;

import com.stackroute.usermanagement.dao.UserDao;
import com.stackroute.usermanagement.domain.User;

import java.util.List;

public class UserServiceImpl implements UserService {
    private UserDao userDao;

    public UserServiceImpl() {
        this.userDao = new UserDao();
    }
    @Override
    public List<User> addUsers(List<User> userList) {
        System.out.println("**********Inside UserServiceImpl*************"+userList);
        return userDao.batchSaveUser(userList);
    }

    @Override
    public User addUser(User user) {
        System.out.println("UserServiceImpl:addUser"+ userDao);
        return userDao.saveUser(user);
    }

    @Override
    public List<User> getUsers() {
        return userDao.getAllUsers();
    }
}
