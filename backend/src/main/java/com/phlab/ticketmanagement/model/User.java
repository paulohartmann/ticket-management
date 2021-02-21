package com.phlab.ticketmanagement.model;

import javax.persistence.*;
import java.util.List;

/*
 * Author: phlab
 * Date: 17/02/21
 */
@Entity
@Table(name = "users")
public class User {

    @Id
    @SequenceGenerator(
            name = "user_sequence",
            sequenceName = "user_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "user_sequence"
    )
    @Column(
            name = "user_id",
            updatable = false
    )
    private Long userId;

    @Column(
            name = "user_name",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String userName;

    @Column(
            name = "email",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String email;

    @Column(
            name = "password",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String password;

    @Column(
            name = "role",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private Role role;

    @Column(
            name = "jobTitle",
            columnDefinition = "TEXT"
    )
    private String jobTitle;

    @OneToMany(mappedBy = "createUser")
    private List<ProjectTicket> myProjectTickets;

    public User(String userName, String email, String password, Role role, String jobTitle, List<ProjectTicket> myProjectTickets) {
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.role = role;
        this.jobTitle = jobTitle;
        this.myProjectTickets = myProjectTickets;
    }

    public User() {
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public List<ProjectTicket> getMyProjectTickets() {
        return myProjectTickets;
    }

    public void setMyProjectTickets(List<ProjectTicket> myProjectTickets) {
        this.myProjectTickets = myProjectTickets;
    }
}
