package com.phlab.ticketmanagement.dao;

import com.phlab.ticketmanagement.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

/*
 * Author: phlab
 * Date: 17/02/21
 */
public interface UserDao extends JpaRepository<User, Long> {
}
