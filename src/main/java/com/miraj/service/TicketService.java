package com.miraj.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.miraj.entity.Ticket;
import com.miraj.serviceImpl.TicketServiceImpl;

@RestController
@RequestMapping("/api/user")
public class TicketService {
	
	@Autowired
	TicketServiceImpl ticketServiceImpl;

	@RequestMapping(value="/tickets",method=RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Iterable<Ticket> getTicketList(){
		return ticketServiceImpl.getAllTicket();
	}
	
	@RequestMapping(value="/tickets/{ticketId}",method=RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Ticket getSingleTicket(@PathVariable("ticketId") String ticketId) {
		if (ticketId != null) {
			return ticketServiceImpl.getSingleTicketData(Integer.valueOf(ticketId));
		}
		return null;
	}
	
	@RequestMapping(value="/tickets",method=RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Ticket addOrUpdateTicket(@RequestBody Ticket ticket){
		return ticketServiceImpl.saveOrUpdateTicketData(ticket);
	}
}
