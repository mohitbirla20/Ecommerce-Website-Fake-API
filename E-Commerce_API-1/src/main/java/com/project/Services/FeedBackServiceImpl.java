package com.project.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.Exceptions.CustomerNotFoundException;
import com.project.Model.CheckFeedBack;
import com.project.Model.CurrentUserSession;
import com.project.Model.Customer;
import com.project.Repositories.CustomerRepo;
import com.project.Repositories.FeedBackRepo;
import com.project.Repositories.SessionDao;


@Service
public class FeedBackServiceImpl implements FeedBackService{

	@Autowired
	private CustomerRepo customerRepo;
	
	@Autowired
	private SessionDao sessionDao;
	
	@Autowired
	private FeedBackRepo feedBackRepo;
	
	@Override
	public CheckFeedBack submitFeedBack(String key,String message) throws CustomerNotFoundException {
		
		  CurrentUserSession currentUser = sessionDao.findByUuid(key);
		  
		  Optional<Customer> customer = customerRepo.findById(currentUser.getUserId());
	        
		  if(!customer.isPresent())
	         	 throw new CustomerNotFoundException("invalid key");
	         
	      CheckFeedBack feedBack = new CheckFeedBack();
	      feedBack.setCustomerID(customer.get().getId());
	      feedBack.setName(customer.get().getFirstName()+" "+customer.get().getLastName());
	      feedBack.setFeedBack(message);
	      
		  return feedBackRepo.save(feedBack);	
	}

	@Override
	public List<CheckFeedBack> checkFeedBacks() throws com.project.Exceptions.FeedBackException {
		
		List<CheckFeedBack> list = feedBackRepo.findAll();
		
		if(list.size() == 0)
			  throw new com.project.Exceptions.FeedBackException("no one give feedback");
		 
		return list;
	}
	

}
