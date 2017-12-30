package com.miraj.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.miraj.entity.Person;

@Repository
public interface PersonRepo extends CrudRepository<Person, Integer>{

	
}
