package com.project.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class CheckFeedBack {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private Integer customerID;
	private String orderId;
	private String name;
	private String feedBack;
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getFeedBack() {
		return feedBack;
	}
	public void setFeedBack(String feedBack) {
		this.feedBack = feedBack;
	}
	
	
	public Integer getCustomerID() {
		return customerID;
	}
	public void setCustomerID(Integer customerID) {
		this.customerID = customerID;
	}
	
	
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	public CheckFeedBack() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public CheckFeedBack(Integer id, Integer customerID, String orderId, String name, String feedBack) {
		super();
		this.id = id;
		this.customerID = customerID;
		this.orderId = orderId;
		this.name = name;
		this.feedBack = feedBack;
	}
	
	
	
	
	
	
}
