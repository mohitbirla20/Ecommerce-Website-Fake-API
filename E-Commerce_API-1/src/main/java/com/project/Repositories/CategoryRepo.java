package com.project.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.Model.Category;

@Repository
public interface CategoryRepo extends JpaRepository<Category, Integer>{

	
}
