package com.miraj.service;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.miraj.entity.Person;
import com.miraj.serviceImpl.PersonServiceImpl;

@RestController
@RequestMapping("/api/admin")
public class PersonService {
	
	PersonServiceImpl personserviceImpl;

	@RequestMapping(value="/persons",method=RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Iterable<Person> getPersonList(){
		return personserviceImpl.retreiveAllPerosnList();
	}
	
	@RequestMapping(value="/persons/{personId}",method=RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Person getPersonDetail(@PathVariable("personId") String personId) {
		if (personId != null) {
			return personserviceImpl.getIndividualPerson(Integer.valueOf(personId));
		}
		return null;
	}
	
	@RequestMapping(value="/persons",method=RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Person addOrUpdatePerson(@RequestBody Person person){
		return personserviceImpl.addOrUpdateIndividualPerson(person);
	}
}
