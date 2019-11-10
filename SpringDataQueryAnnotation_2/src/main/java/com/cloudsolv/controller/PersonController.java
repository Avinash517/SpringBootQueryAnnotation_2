package com.cloudsolv.controller;

import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.cloudsolv.entities.*;
import com.cloudsolv.repository.*;
import com.cloudsolv.service.PeopleManagementService;

@RestController
@RequestMapping("/person")
public class PersonController {
	
	@Autowired
    private PersonRepository personRepository;
	@Autowired
	private PeopleManagementService peopleService;
	@GetMapping("/get/all")
    public List<Person> getAllusers() {
        return personRepository.findAll();
    }
	@GetMapping("/get/{id}")
    public ResponseEntity<Optional<Person>> getUserById(@PathVariable(value = "id") Long personId){
        Optional<Person> person = personRepository.findById(personId);
        return ResponseEntity.ok().body(person);
    }
	
	 @PostMapping("/add")
	    public Person createuser(@Valid @RequestBody Person user) {
	        return personRepository.save(user);
	    }
	 @GetMapping("/get/lastname/{lastname}")
	 private List<Person> getPersonsInfoByLastName(@PathVariable(value = "lastname") String lastName)
	 {
			List<Person> personList = peopleService.getPersonsInfoByLastName(lastName);
			return personList;
	}
	@GetMapping("/get/firstandemail/{firstname}/{email}")
	private List<Person> getPersonsInfoByFirstNameAndEmail(@PathVariable(value = "firstname") String firstName,@PathVariable(value = "email") String email) {
			List<Person> personList = peopleService.getPersonsInfoByFirstNameAndEmail(firstName,email);
			return personList;
		}
	
	@GetMapping("/get/firstandpdate/{firstname}/{date}")
	private List<Person> getPersonsInfoByFirstNameAndPDate(@PathVariable(value = "firstname") String firstName,@PathVariable(value = "date") Date pdate) {
			List<Person> personList = peopleService.getPersonsInfoByFirstNameAndPDate(firstName,pdate);
			return personList;
		}
	 
}
