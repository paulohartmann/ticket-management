package com.phlab.ticketmanagement.service;

import com.phlab.ticketmanagement.config.security.UserRole;
import com.phlab.ticketmanagement.dao.UserDao;
import com.phlab.ticketmanagement.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

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

    public User addUser(User user) {
        user.setRole(UserRole.DEFAULT);
        if (user.getName().isEmpty() || user.getName().isBlank()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Name is obligatory");
        }
        if (user.getEmail().isEmpty() || user.getEmail().isBlank()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Email is obligatory");
        }
        if (user.getPassword().isEmpty() || user.getPassword().isBlank()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Password is obligatory");
        }
        user.setPassword(encoder.encode(user.getPassword()));
        return userDao.save(user);
    }

    public User updatePass(Long id, User user) {
        if (user.getPassword().isEmpty() || user.getPassword().isBlank()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Password is obligatory");
        }
        User toUpdate = userDao.getOne(id);
        if (toUpdate.getUserId() > 0) {
            toUpdate.setPassword(encoder.encode(user.getPassword()));
            return userDao.save(toUpdate);
        }else{
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "User not found");
        }
    }

    public User updateUser(Long id, User user) {
        if (user.getName().isEmpty() || user.getName().isBlank()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Name is obligatory");
        }
        if (user.getEmail().isEmpty() || user.getEmail().isBlank()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Email is obligatory");
        }
        User toUpdate = userDao.getOne(id);
        if (toUpdate.getUserId() > 0) {
            toUpdate.setName(user.getName());
            toUpdate.setJobTitle(user.getJobTitle());
            return userDao.save(toUpdate);
        } else {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "User not found");
        }
    }

    public List<User> findAllUsers() {
        return userDao.findAll();
    }

    public User FindById(Long id) {
        return userDao.findById(id)
                .orElseThrow(() ->
                        new ResponseStatusException(HttpStatus.BAD_REQUEST, "User not found")
                );
    }

    public void deleteUser(Long id) {
        userDao.deleteById(id);
    }
}
