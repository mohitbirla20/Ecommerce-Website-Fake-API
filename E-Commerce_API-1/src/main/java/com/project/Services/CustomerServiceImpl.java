package com.project.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.Exceptions.CustomerNotFoundException;
import com.project.Model.Customer;
import com.project.Repositories.CustomerRepo;

@Service
public class CustomerServiceImpl implements CustomerService{

	@Autowired
	private CustomerRepo customerRepo;
	
	@Override
	public Customer regesterCustomer(Customer c) throws CustomerNotFoundException {
		Customer customer = customerRepo.save(c);
		if(customer.getId() > 0)
			  return c;
		else
			throw new CustomerNotFoundException("please enter valid details");
	}

	
	
	
	
}
