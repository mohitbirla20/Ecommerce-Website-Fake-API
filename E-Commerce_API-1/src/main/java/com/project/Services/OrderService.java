package com.project.Services;

import java.util.List;

import com.project.Exceptions.CustomerNotFoundException;
import com.project.Exceptions.OrderNotFoundException;
import com.project.Exceptions.ProductNotFoundException;
import com.project.Model.Orders;

public interface OrderService {

	public Orders orderProduct(Integer productID,String key) throws ProductNotFoundException,CustomerNotFoundException;

	
	public List<Orders> checkOrders() throws OrderNotFoundException;
	
}
