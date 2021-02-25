package com.phlab.ticketmanagement.controller;

import com.phlab.ticketmanagement.model.ProjectTicket;
import com.phlab.ticketmanagement.model.TicketStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

/*
 * Author: phlab
 * Date: 24/02/21
 */
@RestController
@RequestMapping("/admin/api/ticketstatus")
public class TicketStatusAdminController {

    @DeleteMapping("{statusId}")
    @PreAuthorize("hasRole('ADMIN')")
    public String deleteTicketById(@PathVariable("statusId") Long id){
        return "ticket status deleted";
    }

    @PutMapping(path = "{statusId}")
    @PreAuthorize("hasRole('ADMIN')")
    public String editTicket(@PathVariable("statusId") Long statusId, @RequestBody TicketStatus ticketStatus){
        return "ticketStatus edit";
    }

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public String addStatus(@RequestBody TicketStatus ticketStatus){
        return "new ticketStatus";
    }

    @GetMapping
    @PreAuthorize("hasRole('ADMIN')")
    public String getAllStatus(){
        return "all status";
    }
}
