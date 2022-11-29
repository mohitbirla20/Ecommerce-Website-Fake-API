package com.project.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.Model.Product;

@Repository
public interface ProductRepo extends JpaRepository<Product, Integer> {

	public List<Product> findByProductCategory(String productCategory);
	
}
