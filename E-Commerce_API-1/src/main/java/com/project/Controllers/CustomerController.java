package com.project.Controllers;

import java.util.List;

import javax.security.auth.login.LoginException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.DTO.FeedBackDTO;
import com.project.Exceptions.CartException;
import com.project.Exceptions.CustomerNotFoundException;
import com.project.Exceptions.InvalidCredentialsException;
import com.project.Exceptions.ProductNotFoundException;
import com.project.Model.CheckFeedBack;
import com.project.Model.Customer;
import com.project.Model.Orders;
import com.project.Model.Product;
import com.project.Services.CartService;
import com.project.Services.CustomerService;
import com.project.Services.FeedBackService;
import com.project.Services.OrderService;
import com.project.Services.ProductService;

@RestController
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	@Autowired
	private ProductService productService;
	
	@Autowired
	private CartService cartService;
	
	@Autowired
	private OrderService orderService;
	
	@Autowired
	private FeedBackService feedBackService;
	
	@PostMapping("/customer")
	public ResponseEntity<Customer> customerRegistration(@RequestBody Customer customer) throws CustomerNotFoundException{
	       	Customer c = customerService.regesterCustomer(customer);
	       	return new ResponseEntity<>(c,HttpStatus.CREATED);
	}
	
	
	@GetMapping("/customer")
	public ResponseEntity<List<Product>> searchProductByCategory(@RequestParam String name) throws ProductNotFoundException{
		List<Product> productList = productService.searchProduct(name);
		return new ResponseEntity<List<Product>>(productList, HttpStatus.ACCEPTED);
	}
	
	
	@GetMapping("/customer/viewAllProduct")
	public ResponseEntity<List<Product>> viewAll() throws ProductNotFoundException{
		List<Product> productList = productService.viewAllProduct();
		return new ResponseEntity<List<Product>>(productList, HttpStatus.ACCEPTED);
	}
	
	
	@PostMapping("/customer/addProductToCart")
	public ResponseEntity<String> addProductToCart(@RequestBody Product product,@RequestParam String key) throws ProductNotFoundException, CartException, InvalidCredentialsException{
		String message =  cartService.addProductToCart(product,key);
		return new ResponseEntity<>(message, HttpStatus.ACCEPTED);
	}
	
	
	@PostMapping("/customer/order")
	public ResponseEntity<Orders> orderProduct(@RequestParam Integer id ,@RequestParam String key) throws ProductNotFoundException, CartException, InvalidCredentialsException, CustomerNotFoundException{
		Orders order =  orderService.orderProduct(id, key);
		return new ResponseEntity<>(order, HttpStatus.ACCEPTED);
	}
	
	
	@PostMapping("/customer/feedBack")
	public ResponseEntity<CheckFeedBack> submitFeedBack(@RequestParam String key,@RequestBody FeedBackDTO message) throws CustomerNotFoundException{
		CheckFeedBack feedBack = feedBackService.submitFeedBack(key, message.getMessage());
		return new ResponseEntity<CheckFeedBack>(feedBack, HttpStatus.ACCEPTED);
	}
	
}
