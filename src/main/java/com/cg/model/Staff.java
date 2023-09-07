package com.cg.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;


@Entity
public class Staff {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int staffId;

	private String username;
	private String password;
	
	@OneToMany(mappedBy = "staff" , fetch = FetchType.EAGER)
	@Fetch(value = FetchMode.SUBSELECT)
    private List<Task> tasks;
	
	@OneToMany(mappedBy = "staff" , fetch = FetchType.EAGER)
	@Fetch(value = FetchMode.SUBSELECT)
    private List<Complaint> complaints;
	
	@OneToMany(mappedBy = "staff" , fetch = FetchType.EAGER)
	@Fetch(value = FetchMode.SUBSELECT)
    private List<Bug> bugs;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "user_id", referencedColumnName = "userId")
	private User user;

	public Staff() {
		super();
	}

	public Staff(int staffId, String username, String password, User user) {
		super();
		this.staffId = staffId;
		this.username = username;
		this.password = password;
		this.user = user;
	}

	public int getStaffId() {
		return staffId;
	}

	public void setStaffId(int staffId) {
		this.staffId = staffId;
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

	public List<Task> getTasks() {
		return tasks;
	}

	public void setTasks(List<Task> tasks) {
		this.tasks = tasks;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<Complaint> getComplaints() {
		return complaints;
	}

	public void setComplaints(List<Complaint> complaints) {
		this.complaints = complaints;
	}

	public List<Bug> getBugs() {
		return bugs;
	}

	public void setBugs(List<Bug> bugs) {
		this.bugs = bugs;
	}
	
	

}
