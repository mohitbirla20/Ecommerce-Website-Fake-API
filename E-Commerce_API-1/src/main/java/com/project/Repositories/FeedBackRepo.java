package com.project.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.Model.CheckFeedBack;

@Repository
public interface FeedBackRepo extends JpaRepository<CheckFeedBack, Integer>{

	
	
}
