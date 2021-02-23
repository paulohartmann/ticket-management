package com.phlab.ticketmanagement.controller;

/*
 * Author: phlab
 * Date: 23/02/21
 */

import com.phlab.ticketmanagement.model.ProjectTicket;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/ticket")
public class TicketController {

    @PostMapping
    public String addTicket(@RequestBody ProjectTicket ticket){
        return "added";
    }

    @GetMapping(path = "{userId}")
    @PreAuthorize("hasAnyRole('DEFAULT, MANAGER, ADMIN')")
    public String FindTicketsByUserId(@PathVariable Long userId){
        return "List of user tickets";
    }
}
