package com.phlab.ticketmanagement.service;

import com.phlab.ticketmanagement.dao.UserDao;
import com.phlab.ticketmanagement.model.User;
import com.phlab.ticketmanagement.config.security.UserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

/*
 * Author: phlab
 * Date: 17/02/21
 */
@Service
public class UserService {

    private final UserDao userDao;
    private final PasswordEncoder encoder;

    @Autowired
    public UserService(UserDao userDao, PasswordEncoder encoder) {
        this.encoder = encoder;
        this.userDao = userDao;
    }

    public User addUser(User user){
        user.setRole(UserRole.DEFAULT);

        user.setPassword(encoder.encode(user.getPassword()));

        return userDao.save(user);
    }

    public List<User> findAllUsers(){
        return userDao.findAll();
    }

    public User FindById(Long id){
        return userDao.findById(id).orElse(null); //TODO: Implement a custom throw exception at 'OrElse'
    }
}
