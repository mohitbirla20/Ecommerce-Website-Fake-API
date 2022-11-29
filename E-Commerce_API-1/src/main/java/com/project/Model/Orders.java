package com.project.Model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Orders {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer Id;
	private LocalDateTime orderDate;
	private String orderStatus;
	private Integer totalOrderValue;

//	Relationships here

	// 1. Customer Relationship
	@ManyToOne(cascade = CascadeType.ALL)
	private Customer customer;

	// 2. Details Relationship
	@OneToMany(mappedBy = "order")
	List<OrderDetails> orderDetails = new ArrayList<>();
	// 3.payment Relationship.
	@OneToOne
	private Payment payment;

	
	public Orders(Integer id, LocalDateTime orderDate, String orderStatus, Integer totalOrderValue, Customer customer,
			List<OrderDetails> orderDetails, Payment payment) {
		super();
		Id = id;
		this.orderDate = orderDate;
		this.orderStatus = orderStatus;
		this.totalOrderValue = totalOrderValue;
		this.customer = customer;
		this.orderDetails = orderDetails;
		this.payment = payment;
	}


	public Orders() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Integer getId() {
		return Id;
	}


	public void setId(Integer id) {
		Id = id;
	}


	public LocalDateTime getOrderDate() {
		return orderDate;
	}


	public void setOrderDate(LocalDateTime orderDate) {
		this.orderDate = orderDate;
	}


	public String getOrderStatus() {
		return orderStatus;
	}


	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}


	public Integer getTotalOrderValue() {
		return totalOrderValue;
	}


	public void setTotalOrderValue(Integer totalOrderValue) {
		this.totalOrderValue = totalOrderValue;
	}


	public Customer getCustomer() {
		return customer;
	}


	public void setCustomer(Customer customer) {
		this.customer = customer;
	}


	public List<OrderDetails> getOrderDetails() {
		return orderDetails;
	}


	public void setOrderDetails(List<OrderDetails> orderDetails) {
		this.orderDetails = orderDetails;
	}


	public Payment getPayment() {
		return payment;
	}


	public void setPayment(Payment payment) {
		this.payment = payment;
	}


	@Override
	public String toString() {
		return "Orders [Id=" + Id + ", orderDate=" + orderDate + ", orderStatus=" + orderStatus + ", totalOrderValue="
				+ totalOrderValue + ", customer=" + customer + ", orderDetails=" + orderDetails + ", payment=" + payment
				+ "]";
	}


   
	
	
}
