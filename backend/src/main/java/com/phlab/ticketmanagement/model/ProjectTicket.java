package com.phlab.ticketmanagement.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

/*
 * Author: phlab
 * Date: 17/02/21
 */
@Entity
@Table(name = "project_ticket")
public class ProjectTicket {

    @Id
    @SequenceGenerator(
            name = "project_ticket_sequence",
            sequenceName = "project_ticket_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "project_ticket_sequence"
    )
    @Column(
            name = "project_ticket_id",
            updatable = false
    )
    private Long projectTicketId;

    @Column(
            name = "problem_description",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String problemDesc;

    @Column(
            name = "solutionDesc",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String solutionDesc;

    @Column(
            name = "open_date",
            nullable = false,
            columnDefinition = "DATE"
    )
    private LocalDate openDate;

    @Column(
            name = "close_date",
            nullable = false,
            columnDefinition = "DATE"
    )
    private LocalDate closeDate;

    @ManyToOne
    @JoinColumn(name = "project_id")
    private Project project;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User createUser;

    @ManyToOne
    @JoinColumn(name = "ticket_status_id")
    private TicketStatus ticketStatus;

    @OneToMany(
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Tag> tags;

    public ProjectTicket(TicketStatus ticketStatus, String problemDesc, String solutionDesc, LocalDate openDate, LocalDate closeDate, Project project, User createUser, List<Tag> tags) {
        this.ticketStatus = ticketStatus;
        this.problemDesc = problemDesc;
        this.solutionDesc = solutionDesc;
        this.openDate = openDate;
        this.closeDate = closeDate;
        this.project = project;
        this.createUser = createUser;
        this.tags = tags;
    }

    public ProjectTicket() {
    }

    public Long getProjectTicketId() {
        return projectTicketId;
    }

    public void setProjectTicketId(Long projectTicketId) {
        this.projectTicketId = projectTicketId;
    }

    public TicketStatus getTicketStatus() {
        return ticketStatus;
    }

    public void setTicketStatus(TicketStatus ticketStatus) {
        this.ticketStatus = ticketStatus;
    }

    public String getProblemDesc() {
        return problemDesc;
    }

    public void setProblemDesc(String problemDesc) {
        this.problemDesc = problemDesc;
    }

    public String getSolutionDesc() {
        return solutionDesc;
    }

    public void setSolutionDesc(String solutionDesc) {
        this.solutionDesc = solutionDesc;
    }

    public LocalDate getOpenDate() {
        return openDate;
    }

    public void setOpenDate(LocalDate openDate) {
        this.openDate = openDate;
    }

    public LocalDate getCloseDate() {
        return closeDate;
    }

    public void setCloseDate(LocalDate closeDate) {
        this.closeDate = closeDate;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public User getCreateUser() {
        return createUser;
    }

    public void setCreateUser(User createUser) {
        this.createUser = createUser;
    }

    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }
}
