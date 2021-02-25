package com.phlab.ticketmanagement.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

/*
 * Author: phlab
 * Date: 17/02/21
 */
@Entity(name = "Project")
public class Project {

    @Id
    @SequenceGenerator(
            name = "project_sequence",
            sequenceName = "project_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "project_sequence"
    )
    @Column(
            name = "project_id",
            updatable = false
    )
    private Long projectId;

    @Column(
            name = "project_name",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String projectName;

    @Column(
            name = "creation_date",
            nullable = false,
            columnDefinition = "DATE"
    )
    private LocalDate creationDate;

    @OneToMany(mappedBy = "project")
    private List<ProjectTicket> projectTickets;

    public Project(String projectName, LocalDate creationDate, List<ProjectTicket> projectTickets) {
        this.projectName = projectName;
        this.creationDate = creationDate;
        this.projectTickets = projectTickets;
    }

    public Project() {
    }

    @Override
    public String toString() {
        return "Project{" +
                "projectId=" + projectId +
                ", projectName='" + projectName + '\'' +
                ", creationDate=" + creationDate +
                ", projectTickets=" + projectTickets +
                '}';
    }

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    public List<ProjectTicket> getProjectTickets() {
        return projectTickets;
    }

    public void setProjectTickets(List<ProjectTicket> projectTickets) {
        this.projectTickets = projectTickets;
    }
}
