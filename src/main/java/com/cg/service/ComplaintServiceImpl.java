package com.cg.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.cg.exception.BugNotFoundException;
import com.cg.exception.ComplaintNotFoundException;
import com.cg.model.Admin;
import com.cg.model.Bug;
import com.cg.model.Complaint;
import com.cg.model.Staff;
import com.cg.repository.ComplaintDao;

@Service("ComplaintService")
public class ComplaintServiceImpl implements ComplaintService {
	
	@Autowired
	ComplaintDao complaintDao;

	@Override
	public ResponseEntity addComplaint(Complaint complaint) throws ComplaintNotFoundException {
		complaintDao.saveAndFlush(complaint);
		return new ResponseEntity("Complaint inserted successfully",HttpStatus.OK);
	}

	@Override
	public ResponseEntity updateComplaint(Complaint complaint) throws ComplaintNotFoundException {
		Complaint bean = null;
		try {
			bean = complaintDao.findById(complaint.getComplaintId()).get();
		}
		catch(Exception e) {
			throw new ComplaintNotFoundException("Complaint details not found!");
		}
		complaintDao.saveAndFlush(complaint);
		return new ResponseEntity("Complaint updated successfully",HttpStatus.OK);
	}

	@Override
	public ResponseEntity deleteComplaint(int complaintId) throws ComplaintNotFoundException {
		Complaint bean = null;
		try {
			bean = complaintDao.findById(complaintId).get();
		}
		catch(Exception e) {
			throw new ComplaintNotFoundException("Complaint details not found!");
		}
		complaintDao.deleteById(complaintId);
		return new ResponseEntity("Complaint deleted successfully",HttpStatus.OK);
	}

	@Override
	public Complaint getComplaint(int complaintId) throws ComplaintNotFoundException {
		Complaint bean = null;
		try {
			bean = complaintDao.findById(complaintId).get();
		}
		catch(Exception e) {
			throw new ComplaintNotFoundException("Complaint details not found!");
		}
		return bean;
	}

	@Override
	public List<Complaint> getAllComplaints() throws ComplaintNotFoundException {
		return complaintDao.findAll();
	}

	@Override
	public List<Complaint> getComplaintByDate(LocalDate date) throws ComplaintNotFoundException {
		List<Complaint> complaints = new ArrayList<Complaint>();
		try {
			for(Complaint i : complaintDao.findAll()) {
				if(i.getComplaintDate().equals(date)) {
					complaints.add(i);
				}
			}
		}
		catch(Exception e) {
			throw new ComplaintNotFoundException("Complaint details not found!");
		}
		return complaints;
	}

	@Override
	public List<Complaint> getComplaintByStaff(Staff staff) throws ComplaintNotFoundException {
		List<Complaint> complaints = new ArrayList<Complaint>();
		try {
			for(Complaint i : complaintDao.findAll()) {
				if(i.getStaff().equals(staff)) {
					complaints.add(i);
				}
			}
		}
		catch(Exception e) {
			throw new ComplaintNotFoundException("Complaint details not found!");
		}
		return complaints;
	}

	@Override
	public List<Bug> getAllBugs(Complaint complaint) throws BugNotFoundException {
		return complaint.getBugs();
	}

}
