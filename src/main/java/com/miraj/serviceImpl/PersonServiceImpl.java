package com.miraj.serviceImpl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.miraj.entity.Person;
import com.miraj.repository.PersonRepo;

@Component
public class PersonServiceImpl {

	@Autowired(required=true)
	PersonRepo personRepo;
	
	public Iterable<Person> retreiveAllPerosnList(){
		return personRepo.findAll();
	}
	
	public Person getIndividualPerson(int personId){
		return personRepo.findOne(personId);
	}
	
	public Person addOrUpdateIndividualPerson(Person person){
		return personRepo.save(person);
	}
	
	public void deletePersonData (int personId){
		personRepo.delete(personId);
	}
}
