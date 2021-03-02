package com.phlab.ticketmanagement.controller;

/*
 * Author: phlab
 * Date: 23/02/21
 */

import com.phlab.ticketmanagement.model.Project;
import com.phlab.ticketmanagement.service.ProjectService;
import com.phlab.ticketmanagement.utils.ErrorHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/project")
public class ProjectController extends ErrorHandler {

    private final ProjectService projectService;

    @Autowired
    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @GetMapping
    @PreAuthorize("hasAnyRole('ROLE_DEFAULT', 'ROLE_MANAGER', 'ROLE_ADMIN')")
    public ResponseEntity<List<Project>> findAllProjects(){
        List<Project> projects = projectService.findAll();
        return new ResponseEntity<>(projects, HttpStatus.OK);
    }

    @GetMapping(path = "{projectId}")
    @PreAuthorize("hasAnyRole('ROLE_DEFAULT', 'ROLE_MANAGER', 'ROLE_ADMIN')")
    public ResponseEntity<Project> findProjectById(@PathVariable("projectId") Long id){
        Project p = projectService.findById(id);
        return new ResponseEntity<>(p, HttpStatus.OK);
    }
}
