package com.phlab.ticketmanagement.controller;

import com.phlab.ticketmanagement.model.TicketStatus;
import com.phlab.ticketmanagement.service.TicketStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/*
 * Author: phlab
 * Date: 24/02/21
 */
@RestController
@RequestMapping("/api/ticketstatus")
public class TicketStatusController {

    private final TicketStatusService ticketStatusService;

    @Autowired
    public TicketStatusController(TicketStatusService ticketStatusService) {
        this.ticketStatusService = ticketStatusService;
    }

    @GetMapping
    @PreAuthorize("hasAnyRole('DEFAULT, MANAGER, ADMIN')")
    public ResponseEntity<List<TicketStatus>> getAllStatus(){
        List<TicketStatus> list = ticketStatusService.findAllStatus();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }
}
