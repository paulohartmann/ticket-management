package com.phlab.ticketmanagement.controller;

import com.phlab.ticketmanagement.model.Project;
import com.phlab.ticketmanagement.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

/*
 * Author: phlab
 * Date: 23/02/21
 */
@RestController
@RequestMapping("/management/api/project")
public class ProjectManagemenController {

    private final ProjectService projectService;

    @Autowired
    public ProjectManagemenController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @PostMapping
    @PreAuthorize("hasAuthority('project:create')")
    public ResponseEntity<?> addProject(@RequestBody Project project){
        Project p = projectService.addProject(project);
        return new ResponseEntity<>(p, HttpStatus.CREATED);
    }

    @PutMapping(path = "{projectId}")
    @PreAuthorize("hasAuthority('project:update')")
    public String editProject(@PathVariable("projectId") Long id, @RequestBody Project project){
        return "edit project id: " + id +  ":"+ project.toString();
    }
}
