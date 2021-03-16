package com.phlab.ticketmanagement.dao;

import com.phlab.ticketmanagement.model.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

/*
 * Author: phlab
 * Date: 02/03/21
 */
public interface TagDao extends JpaRepository<Tag, Long> {
}
