package com.project.Services;

import java.time.LocalDateTime;
import java.util.Optional;

import javax.security.auth.login.LoginException;

import org.springframework.aop.ThrowsAdvice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.Exceptions.CustomerNotFoundException;
import com.project.Model.Admin;
import com.project.Model.CurrentUserSession;
import com.project.Model.Customer;
import com.project.Model.LoginDTO;
import com.project.Repositories.AdminRepo;
//import com.project.Repositories.AdminRepo;
import com.project.Repositories.CustomerRepo;
import com.project.Repositories.SessionDao;

import net.bytebuddy.utility.RandomString;

@Service
public class LoginLogoutServiceImpl implements LoginLogoutService{


	@Autowired
	private CustomerRepo cDao;
	
	@Autowired
	private AdminRepo adminDao;
	
	@Autowired
	private SessionDao sDao;
	
	@Override
	public String logIntoAccount(LoginDTO dto) throws LoginException, CustomerNotFoundException {

		Optional<Customer> existingCustomer2 = cDao.findById(dto.getId());
		Customer existingCustomer = null;
		
		if(!existingCustomer2.isPresent()) {
		    throw new CustomerNotFoundException("customer not found");
		}else {
			existingCustomer = existingCustomer2.get();
		}
		
		if(existingCustomer == null) {	
         	throw new LoginException("Please Enter a valid mobile number");	 
		}
		
		Optional<CurrentUserSession> validCustomerSessionOpt =  sDao.findById(existingCustomer.getId());
	
         if(validCustomerSessionOpt.isPresent()) {
			throw new LoginException("User already Logged In with this number");
		}
         
         if(existingCustomer.getPassword().equals(dto.getPassword())) {
        	 String key = RandomString.make(6);
 			CurrentUserSession currentUserSession = new CurrentUserSession(existingCustomer.getId(),key,LocalDateTime.now());
 			sDao.save(currentUserSession);
			return currentUserSession.toString();
			
         }else
 			throw new LoginException("Please Enter a valid password");
		
	}

	
	
	@Override
	public String logOutFromAccount(String key) throws LoginException {

		CurrentUserSession validCustomerSession = sDao.findByUuid(key);
		
		
		if(validCustomerSession == null) {
			throw new LoginException("User Not Logged In with this number");
			
		}
		
		
		sDao.delete(validCustomerSession);
		
		
		return "Logged Out !";
	}

	
	
	
	
	/* Admin */
	
	@Override
	public String loginAdmin(LoginDTO dto) throws LoginException, CustomerNotFoundException {
		
		Optional<Admin> existingAdmin2 = adminDao.findById(dto.getId());
		Admin existingAdmin = null;
		
		if(!existingAdmin2.isPresent()) {
		    throw new CustomerNotFoundException("admin not found");
		}else {
			existingAdmin = existingAdmin2.get();
		}
		
		if(existingAdmin == null) {	
         	throw new LoginException("Please Enter a valid mobile number");	 
		}
		
		Optional<CurrentUserSession> validAdminSessionOpt =  sDao.findById(existingAdmin.getId());
	
         if(validAdminSessionOpt.isPresent()) {
			throw new LoginException("User already Logged In with this number");
		}
         
         if(existingAdmin.getPassword().equals(dto.getPassword())) {
        	 String key = RandomString.make(6);
 			CurrentUserSession currentUserSession = new CurrentUserSession(existingAdmin.getId(),key,LocalDateTime.now());
 			sDao.save(currentUserSession);
			return currentUserSession.toString();
			
         }else
 			throw new LoginException("Please Enter a valid password");
		
	}

	@Override
	public String logOutAdmin(String key) throws LoginException {
        
		CurrentUserSession validCustomerSession = sDao.findByUuid(key);
		
		if(validCustomerSession == null) {
			throw new LoginException("User Not Logged In with this number");
			
		}
			
		sDao.delete(validCustomerSession);
		
		
		return "Logged Out !";
	}

  
	
}
