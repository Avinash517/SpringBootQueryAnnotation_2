package com.cloudsolv.dao;

import java.sql.Date;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.cloudsolv.entities.Person;

public interface PeopleManangementDao extends CrudRepository<Person, Integer>{
	@Query(value="SELECT * FROM person_table WHERE last_name=?1",nativeQuery=true)
	List<Person> getPeronInfoByLastName(String lastName);
	
	@Query(value="SELECT *FROM person_table WHERE first_name=?1 AND email=?2",nativeQuery=true)
	List<Person> findByFirstNameAndEmail(String firstName,String email);
	
	@Query(value="SELECT *FROM person_table WHERE first_name=?1 AND p_date=?2",nativeQuery=true)
	List<Person> findByFirstNameAndPDate(String firstName,Date pDate);
}