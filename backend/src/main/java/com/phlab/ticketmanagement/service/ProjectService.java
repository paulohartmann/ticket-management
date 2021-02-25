package com.phlab.ticketmanagement.service;

import com.phlab.ticketmanagement.dao.ProjectDao;
import com.phlab.ticketmanagement.model.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;

/*
 * Author: phlab
 * Date: 24/02/21
 */
@Service
public class ProjectService {

    private final ProjectDao projectDao;

    @Autowired
    public ProjectService(ProjectDao projectDao) {
        this.projectDao = projectDao;
    }

    public Project addProject(Project project){
        project.setCreationDate(LocalDate.now());
        if(project.getProjectName().isEmpty() || project.getProjectName().isBlank()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Project Name is obligatory");
        }
        return projectDao.save(project);
    }
}
