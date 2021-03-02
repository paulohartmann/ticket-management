package com.phlab.ticketmanagement.service;

import com.phlab.ticketmanagement.dao.ProjectDao;
import com.phlab.ticketmanagement.model.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.util.List;

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

    public List<Project> findAll(){
        return projectDao.findAll();
    }

    public Project findById(Long id) {
        return projectDao.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.BAD_REQUEST, "Project not found")
                );
    }

    public Project addProject(Project p){
        p.setCreationDate(LocalDate.now());
        if(p.getProjectName().isEmpty() || p.getProjectName().isBlank()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Project Name is obligatory");
        }
        return projectDao.save(p);
    }

    public Project updateProject(Long id, Project p){

        if(p.getProjectName().isEmpty() || p.getProjectName().isBlank()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Project Name is obligatory");
        }

        Project toUpdate = projectDao.getOne(id);
        if(toUpdate.getProjectId() > 0) {
            toUpdate.setProjectName(p.getProjectName());
            return projectDao.save(toUpdate);
        }else{
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Project not found");
        }
    }

    public void deleteProject(Long id){
        projectDao.deleteById(id);
    }
}
