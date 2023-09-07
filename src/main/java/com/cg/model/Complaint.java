package com.cg.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;

@Entity
public class Complaint {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int complaintId;
	
	private String complaintStatus;
	private String complaintDesciption;
	
	@JsonDeserialize(using = LocalDateDeserializer.class)
	@JsonSerialize(using = LocalDateSerializer.class)
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private LocalDate complaintDate;
	
	@ManyToOne(fetch = FetchType.LAZY )
	@JoinColumn(name = "staff_id", referencedColumnName = "staffId")
	private Staff staff;
	
	@OneToMany(mappedBy = "complaint" , fetch = FetchType.EAGER)
	@Fetch(value = FetchMode.SUBSELECT)
    private List<Bug> bugs;
	
	
	@ManyToOne(fetch = FetchType.LAZY )
	@JoinColumn(name = "task_id", referencedColumnName = "taskId")
	private Task task;


	public Complaint() {
		super();
	}


	public Complaint(int complaintId, String complaintStatus, String complaintDesciption, LocalDate complaintDate,
			Staff staff, Task task) {
		super();
		this.complaintId = complaintId;
		this.complaintStatus = complaintStatus;
		this.complaintDesciption = complaintDesciption;
		this.complaintDate = complaintDate;
		this.staff = staff;
		this.task = task;
	}

	public int getComplaintId() {
		return complaintId;
	}

	public void setComplaintId(int complaintId) {
		this.complaintId = complaintId;
	}

	public String getComplaintStatus() {
		return complaintStatus;
	}
	
	public void setComplaintStatus(String complaintStatus) {
		this.complaintStatus = complaintStatus;
	}

	public String getComplaintDesciption() {
		return complaintDesciption;
	}

	public void setComplaintDesciption(String complaintDesciption) {
		this.complaintDesciption = complaintDesciption;
	}

	public LocalDate getComplaintDate() {
		return complaintDate;
	}

	public void setComplaintDate(LocalDate complaintDate) {
		this.complaintDate = complaintDate;
	}

	public Staff getStaff() {
		return staff;
	}

	public void setStaff(Staff staff) {
		this.staff = staff;
	}

	public List<Bug> getBugs() {
		return bugs;
	}

	public void setBugs(List<Bug> bugs) {
		this.bugs = bugs;
	}

	public Task getTask() {
		return task;
	}

	public void setTask(Task task) {
		this.task = task;
	}
	
	

}
