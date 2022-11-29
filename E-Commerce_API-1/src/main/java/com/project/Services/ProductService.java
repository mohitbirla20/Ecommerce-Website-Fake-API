package com.project.Services;

import java.util.List;

import com.project.Exceptions.ProductNotFoundException;
import com.project.Model.Product;

public interface ProductService {

	public List<Product> searchProduct(String name) throws ProductNotFoundException;
	
	public List<Product> viewAllProduct() throws ProductNotFoundException;
	
	public Product addNewProduct(Product product) throws ProductNotFoundException;
	
}
