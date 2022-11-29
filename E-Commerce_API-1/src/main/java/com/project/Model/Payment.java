package com.project.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Payment {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer Id;
	private String paymentType;

//	Relationship here
	// 1. Orders Relationship.
	@OneToOne(mappedBy = "payment")
	private Orders order;

	public Payment() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Payment(Integer id, String paymentType, Orders order) {
		super();
		Id = id;
		this.paymentType = paymentType;
		this.order = order;
	}

	public Integer getId() {
		return Id;
	}

	public void setId(Integer id) {
		Id = id;
	}

	public String getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}

	public Orders getOrder() {
		return order;
	}

	public void setOrder(Orders order) {
		this.order = order;
	}

	@Override
	public String toString() {
		return "Payment [Id=" + Id + ", paymentType=" + paymentType + ", order=" + order + "]";
	}
	
	
	
	
	
}
