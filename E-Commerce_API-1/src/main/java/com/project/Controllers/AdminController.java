package com.project.Controllers;

import java.util.List;

import javax.security.auth.login.LoginException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.Exceptions.CategoryException;
import com.project.Exceptions.CustomerNotFoundException;
import com.project.Exceptions.FeedBackException;
import com.project.Exceptions.OrderNotFoundException;
import com.project.Exceptions.ProductNotFoundException;
import com.project.Model.Admin;
import com.project.Model.Category;
import com.project.Model.CheckFeedBack;
import com.project.Model.LoginDTO;
import com.project.Model.Orders;
import com.project.Model.Product;
import com.project.Repositories.FeedBackRepo;
import com.project.Services.AdminService;
import com.project.Services.CategoryService;
import com.project.Services.FeedBackService;
import com.project.Services.LoginLogoutService;
import com.project.Services.OrderService;
import com.project.Services.OrdersServiceImpl;
import com.project.Services.ProductService;

@RestController
public class AdminController {

	@Autowired
	private CategoryService categoryService;
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private FeedBackService feedBackService;
	
	@Autowired
	private OrderService orderService;
	
	@Autowired
	private AdminService adminSerivce;
	

	
	@PostMapping("/admin/regester")
	public ResponseEntity<Admin> regesterAdmin(@RequestBody Admin admin){
	   Admin a = adminSerivce.regesterAdmin(admin);	
	   return new ResponseEntity<Admin>(a, HttpStatus.CREATED);
	}
	
	
	@PostMapping("/admin/addCategory")
	public ResponseEntity<Category> addNewCategory(@RequestBody Category category) throws CategoryException{
		Category cat = categoryService.addCategory(category);
		return new ResponseEntity<>(cat,HttpStatus.OK);
	}
	
	
	@PostMapping("/admin/addProduct")
	public ResponseEntity<Product> addNewProduct(@RequestBody Product product) throws ProductNotFoundException{
		Product p = productService.addNewProduct(product);
		return new ResponseEntity<Product>(p, HttpStatus.OK);
	}
	
	
	@GetMapping("/admin/checkFeedBack")
	public  ResponseEntity<List<CheckFeedBack>> checkFeedBacks() throws FeedBackException{
		List<CheckFeedBack> feedBackList = feedBackService.checkFeedBacks();
		return new ResponseEntity<List<CheckFeedBack>>(feedBackList, HttpStatus.OK);
	}
	
	
	@GetMapping("/admin/checkOrders")
	public ResponseEntity<List<Orders>> checkOrders()throws OrderNotFoundException{
		List<Orders> orderList =  orderService.checkOrders();
		return new ResponseEntity<List<Orders>>(orderList, HttpStatus.OK);
	}
	
	
	
}
