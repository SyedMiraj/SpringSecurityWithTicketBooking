package com.miraj.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.miraj.entity.Ticket;
import com.miraj.repository.TicketRepo;

@Component
public class TicketServiceImpl {

	@Autowired
	TicketRepo ticketRepo;
	
	public Iterable<Ticket> getAllTicket(){
		return ticketRepo.findAll();
	}
	
	public Ticket getSingleTicketData(int ticketId){
		return ticketRepo.findOne(ticketId);
	}
	
	public Ticket saveOrUpdateTicketData(Ticket ticket){
		return ticketRepo.save(ticket);
	}
	
	public void deleteTicketInformation(int ticketId){
		ticketRepo.delete(ticketId);
	}
}
