package com.project.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.Model.Admin;
import com.project.Repositories.AdminRepo;

@Service
public class AdminServiceImpl implements AdminService{

	@Autowired
	private AdminRepo adminRepo;
	
	@Override
	public Admin regesterAdmin(Admin admin) {
		return adminRepo.save(admin);
	}
	
	
	

}
