package com.cg.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.cg.exception.BugNotFoundException;
import com.cg.exception.StaffNotFoundException;
import com.cg.model.Admin;
import com.cg.model.Bug;
import com.cg.model.Complaint;
import com.cg.model.Staff;
import com.cg.model.Task;
import com.cg.repository.StaffDao;

@Service("StaffService")
public class StaffServiceImpl implements StaffService{
	
	@Autowired
	StaffDao staffDao;

	@Override
	public ResponseEntity addStaff(Staff staff) throws StaffNotFoundException {
		staffDao.saveAndFlush(staff);
		return new ResponseEntity("Staff inserted successfully",HttpStatus.OK);
	}

	@Override
	public ResponseEntity updateStaff(Staff staff) throws StaffNotFoundException {
		Staff bean = null;
		try {
			bean = staffDao.findById(staff.getStaffId()).get();
		}
		catch(Exception e) {
			throw new StaffNotFoundException("Staff details not found!");
		}
		staffDao.saveAndFlush(staff);
		return new ResponseEntity("Staff updated successfully",HttpStatus.OK);
	}

	@Override
	public ResponseEntity deleteStaff(int staffId) throws StaffNotFoundException {
		Staff bean = null;
		try {
			bean = staffDao.findById(staffId).get();
		}
		catch(Exception e) {
			throw new StaffNotFoundException("Staff details not found!");
		}
		staffDao.deleteById(staffId);
		return new ResponseEntity("Staff deleted successfully",HttpStatus.OK);
	}

	@Override
	public Staff getStaff(int staffId) throws StaffNotFoundException {
		Staff bean = null;
		try {
			bean = staffDao.findById(staffId).get();
		}
		catch(Exception e) {
			throw new StaffNotFoundException("Staff details not found!");
		}
		return bean;
	}

	@Override
	public List<Staff> getAllStaffs() throws StaffNotFoundException {
		return staffDao.findAll();
	}

	@Override
	public List<Bug> getBugsByStaff(Staff staff) throws StaffNotFoundException {
		return staff.getBugs();
	}

	@Override
	public List<Task> getTasksByStaff(Staff staff) throws StaffNotFoundException {
		return staff.getTasks();
	}

	@Override
	public List<Complaint> getComplaintsByStaff(Staff staff) throws StaffNotFoundException {
		return staff.getComplaints();
	}

}
