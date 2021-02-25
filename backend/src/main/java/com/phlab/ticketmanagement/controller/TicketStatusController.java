package com.phlab.ticketmanagement.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/*
 * Author: phlab
 * Date: 24/02/21
 */
@RestController
@RequestMapping("/api/ticketstatus")
public class TicketStatusController {

    @GetMapping
    @PreAuthorize("hasAnyRole('DEFAULT, MANAGER, ADMIN')")
    public String getAllStatus(){
        return "all status";
    }
}
