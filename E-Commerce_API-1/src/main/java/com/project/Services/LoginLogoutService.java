package com.project.Services;

import javax.security.auth.login.LoginException;

import com.project.Exceptions.CustomerNotFoundException;
import com.project.Model.LoginDTO;

public interface LoginLogoutService {

	public String logIntoAccount(LoginDTO dto)throws LoginException,CustomerNotFoundException;

	public String logOutFromAccount(String key)throws LoginException;
	
	public String loginAdmin(LoginDTO dto)throws LoginException,CustomerNotFoundException;

	public String logOutAdmin(String key)throws LoginException;
	

}
