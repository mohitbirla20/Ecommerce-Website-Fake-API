package com.project.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.Model.Admin;

@Repository
public interface AdminRepo extends JpaRepository<Admin, Integer>{

	
}
