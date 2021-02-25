package com.phlab.ticketmanagement.controller;

import com.phlab.ticketmanagement.utils.ErrorHandler;
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

    @DeleteMapping("{projectId}")
    @PreAuthorize("hasAuthority('project:delete')")
    public String deleteProjectById(@PathVariable("projectId") Long id){
        return "project deleted";
    }
}
