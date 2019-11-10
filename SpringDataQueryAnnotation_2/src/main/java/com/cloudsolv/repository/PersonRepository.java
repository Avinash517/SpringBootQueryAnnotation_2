package com.cloudsolv.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cloudsolv.entities.Person;
@Repository
public interface PersonRepository extends JpaRepository<Person, Long>{

}
