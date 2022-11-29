package com.project.Model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Cart {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer Id;
	private Integer totalCartValue;

//	Relationships here
	// 1. Customer Relationship
	@OneToOne(cascade = CascadeType.ALL)
	private Customer customer;
	
	@OneToMany(mappedBy = "cart")
	private List<Product> products;
	
	// 2. Details Relationship.
	@OneToMany(mappedBy = "cart")
	private List<OrderDetails> cartList = new ArrayList<>();

	public Integer getId() {
		return Id;
	}

	public void setId(Integer id) {
		Id = id;
	}

	public Integer getTotalCartValue() {
		return totalCartValue;
	}

	public void setTotalCartValue(Integer totalCartValue) {
		this.totalCartValue = totalCartValue;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public List<OrderDetails> getCartList() {
		return cartList;
	}

	public void setCartList(List<OrderDetails> cartList) {
		this.cartList = cartList;
	}

	public Cart(Integer id, Integer totalCartValue, Customer customer, List<OrderDetails> cartList) {
		super();
		Id = id;
		this.totalCartValue = totalCartValue;
		this.customer = customer;
		this.cartList = cartList;
	}

	public Cart() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Cart [Id=" + Id + ", totalCartValue=" + totalCartValue + ", customer=" + customer + "]";
	}

	public List<Product> getProduct() {
		return products;
	}

	public void setProduct(List<Product> product) {
		this.products = product;
	}

	
	
	
}
