package com.project.Services;

import org.springframework.stereotype.Service;

import com.project.Exceptions.CategoryException;
import com.project.Model.Category;


public interface CategoryService {

	public Category addCategory(Category category)throws CategoryException;

	
}
