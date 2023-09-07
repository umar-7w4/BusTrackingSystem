package com.cg.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cg.exception.BugNotFoundException;
import com.cg.exception.ComplaintNotFoundException;
import com.cg.model.Bug;
import com.cg.model.Complaint;
import com.cg.model.Staff;
import com.cg.service.ComplaintService;

@RestController
@RequestMapping("/bts-complaint")
public class ComplaintController {
	
	@Autowired
	ComplaintService complaintService;
	
	@PostMapping("/addcomplaint")
	public ResponseEntity addComplaint(@RequestBody Complaint complaint) throws ComplaintNotFoundException{
		return complaintService.addComplaint(complaint);
	}
	
	@PutMapping("/updatecomplaint")
	public ResponseEntity updateComplaint(@RequestBody Complaint complaint)  throws ComplaintNotFoundException{
		return complaintService.updateComplaint(complaint);
	}
	
	@DeleteMapping("/deletecomplaint/{complaintId}")
	public ResponseEntity deleteComplaint(@PathVariable int complaintId)  throws ComplaintNotFoundException{
		return complaintService.deleteComplaint(complaintId);
	}
	
	@GetMapping("/getcomplaint/{complaintId}")
	public Complaint getComplaint(@PathVariable int complaintId)  throws ComplaintNotFoundException{
		return complaintService.getComplaint(complaintId);
	}
	
	@GetMapping("/getallcomplaint")
	public List<Complaint> getAllComplaints()  throws ComplaintNotFoundException{
		return complaintService.getAllComplaints();
	}
	
	@GetMapping("/getcomplaintbydate/{date}")
	public List<Complaint> getComplaintByDate(@RequestParam("localDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date)  throws ComplaintNotFoundException{
		return complaintService.getComplaintByDate(date);
	}
	
	@GetMapping("/getcomplaintbystaff")
	public List<Complaint> getComplaintByStaff(@RequestBody Staff staff)  throws ComplaintNotFoundException{
		return complaintService.getComplaintByStaff(staff);
	}
	
	@GetMapping("/getbugsbycomplaint")
	public List<Bug> getAllBugs(@RequestBody Complaint complaint) throws BugNotFoundException{
		return complaintService.getAllBugs(complaint);
	}

}
