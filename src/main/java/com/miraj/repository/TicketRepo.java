package com.miraj.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.miraj.entity.Ticket;

@Repository
public interface TicketRepo extends CrudRepository<Ticket, Integer>{

}
