package com.project.Services;

import com.project.Exceptions.CartException;
import com.project.Exceptions.InvalidCredentialsException;
import com.project.Model.Cart;
import com.project.Model.Product;

public interface CartService {

	public String addProductToCart(Product p,String key)throws CartException, InvalidCredentialsException;
	
}
