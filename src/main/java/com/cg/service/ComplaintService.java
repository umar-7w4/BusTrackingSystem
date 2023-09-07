package com.cg.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.http.ResponseEntity;

import com.cg.exception.AdminNotFoundException;
import com.cg.exception.BugNotFoundException;
import com.cg.exception.ComplaintNotFoundException;
import com.cg.model.Admin;
import com.cg.model.Bug;
import com.cg.model.Complaint;
import com.cg.model.Staff;

public interface ComplaintService {
	
	public ResponseEntity addComplaint(Complaint complaint) throws ComplaintNotFoundException;
	public ResponseEntity updateComplaint(Complaint complaint)  throws ComplaintNotFoundException;
	public ResponseEntity deleteComplaint(int complaintId)  throws ComplaintNotFoundException;
	public Complaint getComplaint(int complaintId)  throws ComplaintNotFoundException;
	public List<Complaint> getAllComplaints()  throws ComplaintNotFoundException;
	public List<Complaint> getComplaintByDate(LocalDate date)  throws ComplaintNotFoundException;
	public List<Complaint> getComplaintByStaff(Staff staff)  throws ComplaintNotFoundException;
	public List<Bug> getAllBugs(Complaint complaint) throws BugNotFoundException;
}
