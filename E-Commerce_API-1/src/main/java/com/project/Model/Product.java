package com.project.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer Id;
	private String productName;
	private String productDescription;
	private String productBrand;
	private String productCategory;
	private Double rating;
	private Double productMarketPrice;
	private Integer productSellingPrice;
	private Integer quantity;

//	Relationships here.

	// 1.Details Relationship
	@JsonIgnore //adding new product and add at time int orderdetails not right.
	@OneToOne(mappedBy = "product")
	private OrderDetails details;
	
	@OneToOne
	private Cart cart;

//	@OneToOne
//	private Category category;
	
	
	
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Product(Integer id, String productName, String productDescription, String productBrand, String productCategory,
		Double rating, Double productMarketPrice, Integer productSellingPrice, Integer quantity, OrderDetails details,
		Cart cart) {
	super();
	Id = id;
	this.productName = productName;
	this.productDescription = productDescription;
	this.productBrand = productBrand;
	this.productCategory = productCategory;
	this.rating = rating;
	this.productMarketPrice = productMarketPrice;
	this.productSellingPrice = productSellingPrice;
	this.quantity = quantity;
	this.details = details;
	this.cart = cart;
   }

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

	public Integer getId() {
		return Id;
	}

	public void setId(Integer id) {
		Id = id;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductDescription() {
		return productDescription;
	}

	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

	public String getProductBrand() {
		return productBrand;
	}

	public void setProductBrand(String productBrand) {
		this.productBrand = productBrand;
	}

	public String getProductCategory() {
		return productCategory;
	}

	public void setProductCategory(String productCategory) {
		this.productCategory = productCategory;
	}

	public Double getRating() {
		return rating;
	}

	public void setRating(Double rating) {
		this.rating = rating;
	}

	public Double getProductMarketPrice() {
		return productMarketPrice;
	}

	public void setProductMarketPrice(Double productMarketPrice) {
		this.productMarketPrice = productMarketPrice;
	}

	public Integer getProductSellingPrice() {
		return productSellingPrice;
	}

	public void setProductSellingPrice(Integer productSellingPrice) {
		this.productSellingPrice = productSellingPrice;
	}

	public OrderDetails getDetails() {
		return details;
	}

	public void setDetails(OrderDetails details) {
		this.details = details;
	}

	
	
	
//	public Category getCategory() {
//		return category;
//	}
//
//	public void setCategory(Category category) {
//		this.category = category;
//	}
//
//	@Override
//	public String toString() {
//		return "Product [Id=" + Id + ", productName=" + productName + ", productDescription=" + productDescription
//				+ ", productBrand=" + productBrand + ", productCategory=" + productCategory + ", rating=" + rating
//				+ ", productMarketPrice=" + productMarketPrice + ", productSellingPrice=" + productSellingPrice
//				+ ", details=" + details + "]";
//	}
//	
//	
	
	
	
}
