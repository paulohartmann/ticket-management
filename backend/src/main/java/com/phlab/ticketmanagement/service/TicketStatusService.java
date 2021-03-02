package com.phlab.ticketmanagement.service;

import com.phlab.ticketmanagement.dao.TicketStatusDao;
import com.phlab.ticketmanagement.model.TicketStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

/*
 * Author: phlab
 * Date: 26/02/21
 */
@Service
public class TicketStatusService {

    private final TicketStatusDao ticketStatusDao;

    @Autowired
    public TicketStatusService(TicketStatusDao ticketStatusDao) {
        this.ticketStatusDao = ticketStatusDao;
    }

    public TicketStatus addStatus(TicketStatus t){
        //TODO check notnull name
        return ticketStatusDao.save(t);
    }

    public List<TicketStatus> findAllStatus(){
        return ticketStatusDao.findAll();
    }

    public TicketStatus updateStatus(Long id, TicketStatus ts){
        //TODO check notnull nama
        TicketStatus toUpdate = ticketStatusDao.getOne(id);
        if(toUpdate.getStatusId() > 0){
            toUpdate.setStatusName(ts.getStatusName());
            return ticketStatusDao.save(toUpdate);
        }
        throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Ticket Status not found");
    }

    public void deleteStatus(Long id){
        ticketStatusDao.deleteById(id);
    }
}
