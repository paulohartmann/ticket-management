package com.phlab.ticketmanagement.controller;

/*
 * Author: phlab
 * Date: 23/02/21
 */

import com.phlab.ticketmanagement.model.ProjectTicket;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/management/api/ticket")
public class TicketManagementController {


    //, @RequestBody ProjectTicket ticket
    @PutMapping(path = "{ticketId}")
    @PreAuthorize("hasAuthority('ticket:update')")
    public String editTicket(@PathVariable("ticketId") Long ticketId){
        return "management ticket edit";
    }


}
