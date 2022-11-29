package com.project.Services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.Exceptions.CustomerNotFoundException;
import com.project.Exceptions.OrderNotFoundException;
import com.project.Exceptions.ProductNotFoundException;
import com.project.Model.CurrentUserSession;
import com.project.Model.Customer;
import com.project.Model.Orders;
import com.project.Model.Product;
import com.project.Repositories.CustomerRepo;
import com.project.Repositories.OrdersRepo;
import com.project.Repositories.ProductRepo;
import com.project.Repositories.SessionDao;

@Service
public class OrdersServiceImpl implements OrderService{

	@Autowired
	private OrdersRepo orderRepo;

	@Autowired
	private ProductRepo productRepo;	
	
	@Autowired
	private SessionDao sessionDao;
	
	@Autowired
	private CustomerRepo customerRepo;
	
	
	@Override
	public Orders orderProduct(Integer productId,String key) throws ProductNotFoundException, CustomerNotFoundException {
		
		CurrentUserSession currentUser = sessionDao.findByUuid(key);
        Optional<Customer> customer = customerRepo.findById(currentUser.getUserId());
        
        if(!customer.isPresent())
        	throw new CustomerNotFoundException("invalid key");
		
		Optional<Product> product =  productRepo.findById(productId);
				 
		 if(!product.isPresent())
			  throw new ProductNotFoundException("product not found");
		 
		 Orders orders = new Orders();
		 orders.setOrderDate(LocalDateTime.now());
		 orders.setCustomer(customer.get());
		 orders.setTotalOrderValue(product.get().getProductSellingPrice());
		 orders.setOrderStatus("order confirmed");
	
		 return orderRepo.save(orders);
		 		 
	}


	
	
	@Override
	public List<Orders> checkOrders() throws OrderNotFoundException {
		
		List<Orders> orderList = orderRepo.findAll();
		if(orderList.size()==0)
			throw new OrderNotFoundException("order List is Empty");
		
		return orderList;
		
	}
	
	
	
	


}
