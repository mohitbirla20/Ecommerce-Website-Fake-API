package com.project.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.Exceptions.CartException;
import com.project.Exceptions.InvalidCredentialsException;
import com.project.Model.Cart;
import com.project.Model.CurrentUserSession;
import com.project.Model.Customer;
import com.project.Model.Product;
import com.project.Repositories.CartRepo;
import com.project.Repositories.CustomerRepo;
import com.project.Repositories.SessionDao;

@Service
public class CartServiceImpl implements CartService{

	@Autowired
	private CartRepo cartRepo;
	
	@Autowired
	private SessionDao session;
	
	@Autowired
	private CustomerRepo customerRepo;
	
	@Override
	public String addProductToCart(Product p,String key) throws CartException, InvalidCredentialsException {
	
		CurrentUserSession currSession = session.findByUuid(key);
		
		if (currSession == null)
			throw new InvalidCredentialsException("Invalid Session key");

		Optional<Customer> customer = customerRepo.findById(currSession.getUserId());
		Optional<Cart> cart = cartRepo.findById(customer.get().getCart().getId());

		List<Product> productList = cart.get().getProduct();
		boolean flag  = false;
		
		for(Product product : productList) {
			if(p.getId()==product.getId()) {
				flag = true;
				break;
			}
		}
		
		if(flag)
			throw new CartException("Product already added in the cart");
		
		 productList.add(p);
		 cartRepo.save(cart.get());
		 
		 return "Product added success..!";
	}
	
	
	

}
