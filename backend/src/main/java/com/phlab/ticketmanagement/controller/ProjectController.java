package com.phlab.ticketmanagement.controller;

/*
 * Author: phlab
 * Date: 23/02/21
 */

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/project")
@PreAuthorize("hasAnyRole('ROLE_DEFAULT', 'ROLE_MANAGER', 'ROLE_ADMIN')")
public class ProjectController {

    //@PreAuthorize("hasAnyRole('ROLE_DEFAULT, ROLE_MANAGER, ROLE_ADMIN')")
    @GetMapping
    public String findAllProjects(){
        return "all projects";
    }

    @GetMapping(path = "{projectId}")
    public String findProjectById(@PathVariable("projectId") Long id){
        return "find project by ID";
    }
}
