package com.phlab.ticketmanagement.model;

import javax.persistence.*;

/*
 * Author: phlab
 * Date: 17/02/21
 */
@Entity(name = "Project_Ticket_Status")
public class TicketStatus {

    @Id
    @SequenceGenerator(
            name = "status_sequence",
            sequenceName = "status_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "status_sequence"
    )
    @Column(
            name = "ticket_status_id",
            updatable = false
    )
    private Long statusId;

    @Column(
            name = "ticket_status_name",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String statusName;

    public TicketStatus() {
    }

    public TicketStatus(String statusName) {
        this.statusName = statusName;
    }

    public Long getStatusId() {
        return statusId;
    }

    public void setStatusId(Long statusId) {
        this.statusId = statusId;
    }

    public String getStatusName() {
        return statusName;
    }

    public void setStatusName(String statusName) {
        this.statusName = statusName;
    }
}
