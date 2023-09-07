package com.cg.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.cg.exception.AdminNotFoundException;
import com.cg.exception.StaffNotFoundException;
import com.cg.model.Admin;
import com.cg.model.Bug;
import com.cg.model.Complaint;
import com.cg.model.Staff;
import com.cg.model.Task;

public interface StaffService {
	
	public ResponseEntity addStaff(Staff staff) throws StaffNotFoundException;
	public ResponseEntity updateStaff(Staff staff)  throws StaffNotFoundException;
	public ResponseEntity deleteStaff(int staffId)  throws StaffNotFoundException;
	public Staff getStaff(int staffId)  throws StaffNotFoundException;
	public List<Staff> getAllStaffs()  throws StaffNotFoundException;
	public List<Bug> getBugsByStaff(Staff staff)  throws StaffNotFoundException;
	public List<Task> getTasksByStaff(Staff staff)  throws StaffNotFoundException;
	public List<Complaint> getComplaintsByStaff(Staff staff)  throws StaffNotFoundException;

}
