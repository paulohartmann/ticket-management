package com.phlab.ticketmanagement.controller;

import com.phlab.ticketmanagement.model.Project;
import com.phlab.ticketmanagement.model.Tag;
import com.phlab.ticketmanagement.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/*
 * Author: phlab
 * Date: 16/03/21
 */
@RestController
@RequestMapping("/api/tag")
public class TagController {

    private final TagService tagService;

    @Autowired
    public TagController(TagService tagService) {
        this.tagService = tagService;
    }

    public ResponseEntity<Tag> addTag(Tag tag){
        Tag t = tagService.addTag(tag);
        return new ResponseEntity<>(t, HttpStatus.CREATED);
    }

    public ResponseEntity<List<Tag>> findAll(){
        List<Tag> tags = tagService.findAll();
        return new ResponseEntity<>(tags, HttpStatus.OK);
    }
}
