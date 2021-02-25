package com.phlab.ticketmanagement.controller;

import com.phlab.ticketmanagement.model.ProjectTicket;
import com.phlab.ticketmanagement.model.User;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

/*
 * Author: phlab
 * Date: 24/02/21
 */
@RestController
@RequestMapping("/api/user")
public class UserController {

    @PutMapping(path = "{userId}")
    @PreAuthorize("hasAnyRole('DEFAULT, MANAGER, ADMIN')")
    public String editTicket(@PathVariable("userId") Long userId, @RequestBody User user){
        return "edit user";
    }
}
