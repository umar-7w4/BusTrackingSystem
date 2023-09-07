package com.cg.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/*
 
 {
 	    "username": "Charan_89",
        "password": "Cherry007@xyz",
        "role" : "customer"
 }
  
 */

@Entity
@Table(name = "user_details")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userId;
	
	
	private String username;
	private String password;
	private String role;
	
	public User() {
		super();
	}

	public User(int userId, String username, String password, String role) {
		super();
		this.userId = userId;
		this.username = username;
		this.password = password;
		this.role = role;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	

}
