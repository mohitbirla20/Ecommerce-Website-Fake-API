package com.project.Services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.Exceptions.CategoryException;
import com.project.Model.Category;
import com.project.Repositories.CategoryRepo;
import com.project.Repositories.ProductRepo;

@Service
public class CategoryServiceImpl implements CategoryService{

	@Autowired
	private CategoryRepo categoryRepo;
	
	@Autowired
	private ProductRepo productRepo;
	
	@Override
	public Category addCategory(Category category) throws CategoryException {
        
		Optional<Category> c  = categoryRepo.findById(category.getCategoryID()); 
        
		if(c.isPresent()) 
			throw new CategoryException("Category already exsit");
		
		Category cat = categoryRepo.save(category);
		
		return cat;
		
	}

	
	
}
