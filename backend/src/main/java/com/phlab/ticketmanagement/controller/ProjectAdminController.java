package com.phlab.ticketmanagement.controller;

import com.phlab.ticketmanagement.service.ProjectService;
import com.phlab.ticketmanagement.utils.ErrorHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
@RequestMapping("/admin/api/project")
public class ProjectAdminController extends ErrorHandler {

    private final ProjectService projectService;

    @Autowired
    public ProjectAdminController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @DeleteMapping("{projectId}")
    @PreAuthorize("hasAuthority('project:delete')")
    public ResponseEntity<?> deleteProjectById(@PathVariable("projectId") Long id) {
        projectService.deleteProject(id);
        return new ResponseEntity<>(HttpStatus.OK);

    }
}
