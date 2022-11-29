package com.project.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.Exceptions.ProductNotFoundException;
import com.project.Model.Product;
import com.project.Repositories.CategoryRepo;
import com.project.Repositories.ProductRepo;

@Service
public class ProductServiceImpl implements ProductService{

	@Autowired
	private ProductRepo productRepo;
	
	@Autowired
	private CategoryRepo categoryRepo;

	@Override
	public List<Product> searchProduct(String name) throws ProductNotFoundException {
		
		List<Product> productList = productRepo.findByProductCategory(name);
		
		if(productList.size()==0) 
			throw new ProductNotFoundException("Sorry now this product is not available you can see other product");
		else 
			return productList;
		
	}

	
	
	@Override
	public List<Product> viewAllProduct() throws ProductNotFoundException {
         
		List<Product> allProductList = productRepo.findAll();
         
         if(allProductList.size() == 0) 
        	 throw new ProductNotFoundException("Product list is empty");
         else 
        	 return allProductList;
	
	}
	
	/* Method for Admin */
	public Product addNewProduct(Product product)throws ProductNotFoundException{
	
		Product productAdded = productRepo.save(product);
		
		if(productAdded.getId()>0) 
			return productAdded;
		else
			throw new ProductNotFoundException();
		
	}
	
	
	
}
