package com.project.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.Exceptions.CustomerNotFoundException;
import com.project.Model.Customer;

@Repository
public interface CustomerRepo extends JpaRepository<Customer, Integer> {

	
}
