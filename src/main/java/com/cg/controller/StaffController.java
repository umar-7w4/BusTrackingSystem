package com.cg.controller;

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
import com.cg.exception.StaffNotFoundException;
import com.cg.model.Bug;
import com.cg.model.Complaint;
import com.cg.model.Staff;
import com.cg.model.Task;
import com.cg.repository.StaffDao;
import com.cg.service.ComplaintService;
import com.cg.service.StaffService;

@RestController
@RequestMapping("/bts-staff")
public class StaffController {
	
	@Autowired
	StaffService staffService;
	
	@PostMapping("/addstaff")
	public ResponseEntity addStaff(@RequestBody Staff staff) throws StaffNotFoundException{
		return staffService.addStaff(staff);
	}
	
	@PutMapping("/updatestaff")
	public ResponseEntity updateStaff(@RequestBody Staff staff)  throws StaffNotFoundException{
		return staffService.updateStaff(staff);
	}
	
	@DeleteMapping("/deletestaff/{staffId}")
	public ResponseEntity deleteStaff(@PathVariable int staffId)  throws StaffNotFoundException{
		return staffService.deleteStaff(staffId);
	}
	
	@GetMapping("/getstaff/{staffId}")
	public Staff getStaff(@PathVariable int staffId)  throws StaffNotFoundException{
		return staffService.getStaff(staffId);
	}
	
	@GetMapping("/getallstaff")
	public List<Staff> getAllStaffs()  throws StaffNotFoundException{
		return staffService.getAllStaffs();
	}
	
	@GetMapping("/getbugsbystaff")
	public List<Bug> getBugsByStaff(@RequestBody Staff staff)  throws StaffNotFoundException{
		return staffService.getBugsByStaff(staff);
	}
	
	@GetMapping("/gettasksbystaff")
	public List<Task> getTasksByStaff(@RequestBody Staff staff)  throws StaffNotFoundException{
		return staffService.getTasksByStaff(staff);
	}
	
	@GetMapping("/getcomplaintsbystaff")
	public List<Complaint> getComplaintsByStaff(@RequestBody Staff staff)  throws StaffNotFoundException{
		return staffService.getComplaintsByStaff(staff);
	}

	
}
