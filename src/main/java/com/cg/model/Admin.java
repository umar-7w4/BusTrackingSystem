package com.cg.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

/*
 
    {
        "adminId": 2,
        "username": "Charan_89",
        "password": "Cherry007@xyz",
        "user": {
            "userId": 2,
            "username": "Charan_89",
            "password": "Cherry007@xyz",
            "role": "admin"
        }
    }
 */

@Entity
public class Admin {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int adminId;

	private String username;
	private String password;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "user_id", referencedColumnName = "userId")
	private User user;

	public Admin() {
		super();
	}

	public Admin(int adminId, String username, String password) {
		super();
		this.adminId = adminId;
		this.username = username;
		this.password = password;
	}

	public int getAdminId() {
		return adminId;
	}

	public void setAdminId(int adminId) {
		this.adminId = adminId;
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

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	

}
