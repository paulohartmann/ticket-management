package com.phlab.ticketmanagement.controller;

import com.phlab.ticketmanagement.model.Project;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

/*
 * Author: phlab
 * Date: 23/02/21
 */
@RestController
@RequestMapping("/management/api/project")
@PreAuthorize("hasAnyRole('ROLE_MANAGER', 'ROLE_ADMIN')")
public class ProjectManagemenController {

    @PostMapping
    public String addProject(@RequestBody Project project){
        return "new project: " + project.toString();
    }

    @PutMapping(path = "{projectId}")
    public String editProject(@PathVariable("projectId") Long id, @RequestBody Project project){
        return "edit project id: " + id +  ":"+ project.toString();
    }
}
