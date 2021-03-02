package com.phlab.ticketmanagement.controller;

import com.phlab.ticketmanagement.model.TicketStatus;
import com.phlab.ticketmanagement.service.TicketStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

/*
 * Author: phlab
 * Date: 24/02/21
 */
@RestController
@RequestMapping("/admin/api/ticketstatus")
public class TicketStatusAdminController {

    private final TicketStatusService ticketStatusService;

    @Autowired
    public TicketStatusAdminController(TicketStatusService ticketStatusService) {
        this.ticketStatusService = ticketStatusService;
    }

    @DeleteMapping("{statusId}")
    @PreAuthorize("hasRole('ADMIN')")
    public void deleteTicketById(@PathVariable("statusId") Long id) {
        ticketStatusService.deleteStatus(id);
    }

    @PutMapping(path = "{statusId}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<TicketStatus> editTicket(@PathVariable("statusId") Long statusId, @RequestBody TicketStatus ticketStatus) {
        TicketStatus ts = ticketStatusService.updateStatus(statusId, ticketStatus);
        return new ResponseEntity<>(ts, HttpStatus.OK);
    }

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<TicketStatus> addStatus(@RequestBody TicketStatus ticketStatus) {
        TicketStatus ts = ticketStatusService.addStatus(ticketStatus);
        return new ResponseEntity<>(ts, HttpStatus.CREATED);

    }

}
