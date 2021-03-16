package com.phlab.ticketmanagement.service;

import com.phlab.ticketmanagement.dao.TagDao;
import com.phlab.ticketmanagement.model.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

/*
 * Author: phlab
 * Date: 02/03/21
 */
@Service
public class TagService {

    private final TagDao tagDao;

    @Autowired
    public TagService(TagDao tagDao) {
        this.tagDao = tagDao;
    }

    public void deleteTag(Long id) {
        tagDao.deleteById(id);
    }

    public Tag addTag(Tag tag) {
        //TODO: check if name already exist
        return tagDao.save(tag);
    }

    public List<Tag> findAll() {
        return tagDao.findAll();
    }

    public Tag findById(Long id) {
        return tagDao.findById(id)
                .orElseThrow(() ->
                        new ResponseStatusException(HttpStatus.BAD_REQUEST, "Tag not found "));
    }

    public Tag editTag(Long id, Tag tag) {
        Tag toUpdate = tagDao.getOne(id);
        if (toUpdate.getTagId() > 0) {
            toUpdate.setTagName(tag.getTagName());
            toUpdate.setColor(tag.getColor());
            tagDao.save(toUpdate);
        }else {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Tag not found");
        }
        return toUpdate;

    }
}
