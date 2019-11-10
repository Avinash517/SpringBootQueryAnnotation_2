package com.cloudsolv;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.cloudsolv.entities.*;
import com.cloudsolv.service.*;
@SpringBootApplication
public class SpringBootDataJpaQueryMethodsDemoApplication implements CommandLineRunner {

	@Autowired
	private PeopleManagementService peopleManagementService;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringBootDataJpaQueryMethodsDemoApplication.class, args);
	}
	
	public void run(String... args) throws Exception {
		//getPersonsInfoByLastName();
		getPersonsInfoByFirstNameAndEmail();
	}

	private void getPersonsInfoByFirstNameAndEmail() {
		List<Person> personList = peopleManagementService.getPersonsInfoByFirstNameAndEmail("Avinash","avinash@gmail.com");
		personList.forEach(System.out::println);

	}

	private void getPersonsInfoByLastName() {
		List<Person> personList = peopleManagementService.getPersonsInfoByLastName("Jadhav");
		personList.forEach(System.out::println);
	}

}
