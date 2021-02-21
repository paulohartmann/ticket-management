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
}
