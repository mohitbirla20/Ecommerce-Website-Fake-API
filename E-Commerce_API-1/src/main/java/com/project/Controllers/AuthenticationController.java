package com.project.Controllers;

import javax.security.auth.login.LoginException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.Exceptions.CustomerNotFoundException;
import com.project.Model.LoginDTO;
import com.project.Services.LoginLogoutService;

@RestController
public class AuthenticationController {

	@Autowired
	private LoginLogoutService customerLogin;
	

	@Autowired
	private LoginLogoutService loginLogoutService;
	
	@PostMapping("/login")
	public ResponseEntity<String> customerLogin(@RequestBody LoginDTO dto) throws LoginException, CustomerNotFoundException {
		String result = customerLogin.logIntoAccount(dto);
		return new ResponseEntity<String>(result,HttpStatus.OK );
	}
	
	@DeleteMapping("/logout")
	public String customerLogout(@RequestParam(required = false) String key) throws LoginException {
		return customerLogin.logOutFromAccount(key);
		
	}
	

	@PostMapping("/admin/login")
	public ResponseEntity<String> adminLogin(@RequestBody LoginDTO loginDTO) throws LoginException, CustomerNotFoundException{
	   String a = loginLogoutService.loginAdmin(loginDTO);	
	   return new ResponseEntity<>(a, HttpStatus.CREATED);
	}
	
	
	
	@DeleteMapping("/admin/logout")
	public ResponseEntity<String> adminLogout(@RequestParam String key) throws LoginException, CustomerNotFoundException{
	   String a = loginLogoutService.logOutAdmin(key);	
	   return new ResponseEntity<>(a, HttpStatus.CREATED);
	}
	
}
