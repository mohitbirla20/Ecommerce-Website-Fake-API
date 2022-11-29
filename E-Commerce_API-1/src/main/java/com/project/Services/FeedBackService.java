package com.project.Services;

import java.util.List;

import com.project.Exceptions.CustomerNotFoundException;
import com.project.Exceptions.FeedBackException;
import com.project.Model.CheckFeedBack;

public interface FeedBackService {

	public CheckFeedBack submitFeedBack(String key,String message)throws CustomerNotFoundException;
	
	
	public List<CheckFeedBack> checkFeedBacks()throws FeedBackException;
	
}
