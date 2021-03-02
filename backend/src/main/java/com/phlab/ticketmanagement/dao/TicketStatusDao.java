package com.phlab.ticketmanagement.dao;

import com.phlab.ticketmanagement.model.TicketStatus;
import org.springframework.data.jpa.repository.JpaRepository;

/*
 * Author: phlab
 * Date: 26/02/21
 */
public interface TicketStatusDao extends JpaRepository<TicketStatus, Long> {
}
