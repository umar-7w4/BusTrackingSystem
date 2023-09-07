package com.cg.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.cg.exception.AdminNotFoundException;
import com.cg.exception.BugNotFoundException;
import com.cg.model.Admin;
import com.cg.model.Bug;
import com.cg.model.Staff;

public interface BugService {
	
	public ResponseEntity addBug(Bug bug) throws BugNotFoundException;
	public ResponseEntity updateBug(Bug bug)  throws BugNotFoundException;
	public ResponseEntity deleteBug(int bugId)  throws BugNotFoundException;
	public Bug getBug(int bugId)  throws BugNotFoundException;
	public List<Bug> getAllBugs()  throws BugNotFoundException;
	public List<Bug> getBugsByStatus(String status) throws BugNotFoundException; 
	public ResponseEntity transferBug(Bug bug,Staff staff) throws BugNotFoundException; 
	public ResponseEntity resolveBug(Bug bug, Staff staff) throws BugNotFoundException;
}
