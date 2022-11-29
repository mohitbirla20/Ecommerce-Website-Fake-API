package com.project.Model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Category {

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer categoryID;
	private String categoryName;
	private String active;
	
	
	@OneToMany(cascade = CascadeType.ALL)
	@ElementCollection
	private List<Product> productList;
	
	
	public Category() {
		super();
	}




	public Category(Integer categoryID, String categoryName, String active) {
	super();
	this.categoryID = categoryID;
	this.categoryName = categoryName;
	this.active = active;
}




	public Integer getCategoryID() {
		return categoryID;
	}

	public void setCategoryID(Integer categoryID) {
		this.categoryID = categoryID;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getActive() {
		return active;
	}

	public void setActive(String active) {
		this.active = active;
	}




	public List<Product> getProductList() {
		return productList;
	}




	public void setProductList(List<Product> productList) {
		this.productList = productList;
	}
	
	
	
	
	
}
