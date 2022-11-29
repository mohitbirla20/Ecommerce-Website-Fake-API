package com.project.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class OrderDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer Id;
	private Integer quantity;
	private Integer totalValue;
	
//	Relationship here
	// 1. Orders Relationship
	@ManyToOne
	private Orders order;
	// 2.cart Relationship
	@ManyToOne
	private Cart cart;
	// 3.Product Relationship
	@OneToOne
	private Product product;
	
	
	public OrderDetails(Integer id, Integer quantity, Integer totalValue, Orders order, Cart cart, Product product) {
		super();
		Id = id;
		this.quantity = quantity;
		this.totalValue = totalValue;
		this.order = order;
		this.cart = cart;
		this.product = product;
	}


	public OrderDetails() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Integer getId() {
		return Id;
	}


	public void setId(Integer id) {
		Id = id;
	}


	public Integer getQuantity() {
		return quantity;
	}


	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}


	public Integer getTotalValue() {
		return totalValue;
	}


	public void setTotalValue(Integer totalValue) {
		this.totalValue = totalValue;
	}


	public Orders getOrder() {
		return order;
	}


	public void setOrder(Orders order) {
		this.order = order;
	}


	public Cart getCart() {
		return cart;
	}


	public void setCart(Cart cart) {
		this.cart = cart;
	}


	public Product getProduct() {
		return product;
	}


	public void setProduct(Product product) {
		this.product = product;
	}


	@Override
	public String toString() {
		return "OrderDetails [Id=" + Id + ", quantity=" + quantity + ", totalValue=" + totalValue + ", order=" + order
				+ ", cart=" + cart + "]";
	}
	
	
	
	
}
