package com.phlab.ticketmanagement.dao;

import com.phlab.ticketmanagement.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/*
 * Author: phlab
 * Date: 17/02/21
 */
public interface UserDao extends JpaRepository<User, Long> {

    Optional<User> findByEmail(String email);

    Boolean existsByEmail(String email);
}
