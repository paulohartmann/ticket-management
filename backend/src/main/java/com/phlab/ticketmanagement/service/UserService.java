package com.phlab.ticketmanagement.service;

import com.phlab.ticketmanagement.dao.UserDao;
import com.phlab.ticketmanagement.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/*
 * Author: phlab
 * Date: 17/02/21
 */
@Service
public class UserService {

    private final UserDao userDao;

    @Autowired
    public UserService(UserDao userDao) {
        this.userDao = userDao;
    }

    public User addUser(User user){
        return userDao.save(user);
    }

    public List<User> findAllUsers(){
        return userDao.findAll();
    }
}
