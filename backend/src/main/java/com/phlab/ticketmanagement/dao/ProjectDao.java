package com.phlab.ticketmanagement.dao;

import com.phlab.ticketmanagement.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;

/*
 * Author: phlab
 * Date: 24/02/21
 */

public interface ProjectDao extends JpaRepository<Project, Long> {
}
