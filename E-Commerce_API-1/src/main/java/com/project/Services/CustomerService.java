package com.project.Services;

import com.project.Exceptions.CustomerNotFoundException;
import com.project.Model.Customer;

public interface CustomerService {

	public Customer regesterCustomer(Customer c) throws CustomerNotFoundException;
		
	
}
