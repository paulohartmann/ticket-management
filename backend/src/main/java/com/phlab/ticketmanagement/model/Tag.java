package com.phlab.ticketmanagement.model;

import javax.persistence.*;

/*
 * Author: phlab
 * Date: 17/02/21
 */
@Entity(name = "Tag")
public class Tag {

    @Id
    @SequenceGenerator(
            name = "tag_sequence",
            sequenceName = "tag_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "tag_sequence"
    )
    @Column(
            name = "tag_id",
            updatable = false
    )
    private Long tagId;

    @Column(
            name = "tag_name",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String tagName;

    @Column(
            name = "color",
            columnDefinition = "TEXT"
    )
    private String color;

    public Tag(String tagName, String color) {
        this.tagName = tagName;
        this.color = color;
    }

    public Tag() {
    }

    public Long getTagId() {
        return tagId;
    }

    public void setTagId(Long tagId) {
        this.tagId = tagId;
    }

    public String getTagName() {
        return tagName;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}

