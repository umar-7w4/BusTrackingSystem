package com.cg.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import ch.qos.logback.core.status.Status;

@Entity
public class Bug {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int bugId;
	
	private String bugStatus;
	private String bugDescription;
	
	@ManyToOne(fetch = FetchType.LAZY )
	@JoinColumn(name = "task_id", referencedColumnName = "taskId")
	private Task task;
	
	@ManyToOne(fetch = FetchType.LAZY )
	@JoinColumn(name = "complaint_id", referencedColumnName = "complaintId")
	private Complaint complaint;
	
	@ManyToOne(fetch = FetchType.LAZY )
	@JoinColumn(name = "staff_id", referencedColumnName = "staffId")
	private Staff staff;

	public Bug() {
		super();
	}

	public Bug(int bugId, String bugStatus, String bugDescription, Task task, Complaint complaint) {
		super();
		this.bugId = bugId;
		this.bugStatus = bugStatus;
		this.bugDescription = bugDescription;
		this.task = task;
		this.complaint = complaint;
	}

	public int getBugId() {
		return bugId;
	}

	public void setBugId(int bugId) {
		this.bugId = bugId;
	}

	public String getBugStatus() {
		return bugStatus;
	}

	public void setBugStatus(String bugStatus) {
		this.bugStatus = bugStatus;
	}

	public String getBugDescription() {
		return bugDescription;
	}

	public void setBugDescription(String bugDescription) {
		this.bugDescription = bugDescription;
	}

	public Task getTask() {
		return task;
	}

	public void setTask(Task task) {
		this.task = task;
	}

	public Complaint getComplaint() {
		return complaint;
	}

	public void setComplaint(Complaint complaint) {
		this.complaint = complaint;
	}

	public Staff getStaff() {
		return staff;
	}

	public void setStaff(Staff staff) {
		this.staff = staff;
	}


}
