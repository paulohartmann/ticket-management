package com.phlab.ticketmanagement.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/*
 * Author: phlab
 * Date: 24/02/21
 */
@RestController
@RequestMapping("/admin/api/ticket")
public class TicketAdminController {

    @DeleteMapping("{ticketId}")
    @PreAuthorize("hasAuthority('ticket:delete')")
    public String deleteTicketById(@PathVariable("ticketId") Long id){
        return "ticket deleted";
    }
}
