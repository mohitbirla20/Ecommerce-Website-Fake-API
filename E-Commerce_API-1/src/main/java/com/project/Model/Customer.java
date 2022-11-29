package com.project.Model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.apache.tomcat.jni.Address;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer Id;
	private String firstName;
	private String LastName;
	private String email;
	private String phone;
	private String password;

	@Embedded
	private Address address;
	

//	Relationships Starts Here.
	
	// 1. Cart Relationship.
	@JsonIgnore
	@OneToOne(cascade = CascadeType.ALL,mappedBy = "customer")
	private Cart cart;

	// 2.Orders Relationship.
	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "customer")
	private List<Orders> list = new ArrayList<>();

	public Integer getId() {
		return Id;
	}

	public void setId(Integer id) {
		Id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return LastName;
	}

	public void setLastName(String lastName) {
		LastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

	public List<Orders> getList() {
		return list;
	}

	public void setList(List<Orders> list) {
		this.list = list;
	}
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Customer(Integer id, String firstName, String lastName, String email, String phone, String password,
			Address address, Cart cart, List<Orders> list) {
		super();
		Id = id;
		this.firstName = firstName;
		LastName = lastName;
		this.email = email;
		this.phone = phone;
		this.password = password;
		this.address = address;
		this.cart = cart;
		this.list = list;
	}
	

	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Customer [Id=" + Id + ", firstName=" + firstName + ", LastName=" + LastName + ", email=" + email
				+ ", phone=" + phone + ", address=" + address + ", cart=" + cart + "]";
	}
	
	
	
	
	
}
