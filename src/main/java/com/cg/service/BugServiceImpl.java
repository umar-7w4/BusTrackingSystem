package com.cg.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.cg.exception.AdminNotFoundException;
import com.cg.exception.BugNotFoundException;
import com.cg.model.Admin;
import com.cg.model.Bug;
import com.cg.model.Staff;
import com.cg.repository.BugDao;

@Service("BugService")
public class BugServiceImpl implements BugService {
	
	@Autowired
	BugDao bugDao;

	@Override
	public ResponseEntity addBug(Bug bug) throws BugNotFoundException {
		bugDao.saveAndFlush(bug);
		return new ResponseEntity("Bug inserted successfully",HttpStatus.OK);
	}

	@Override
	public ResponseEntity updateBug(Bug bug) throws BugNotFoundException {
		Bug bean = null;
		try {
			bean = bugDao.findById(bug.getBugId()).get();
		}
		catch(Exception e) {
			throw new BugNotFoundException("Bug details not found!");
		}
		bugDao.saveAndFlush(bug);
		return new ResponseEntity("Bug updated successfully",HttpStatus.OK);
	}

	@Override
	public ResponseEntity deleteBug(int bugId) throws BugNotFoundException {
		Bug bean = null;
		try {
			bean = bugDao.findById(bugId).get();
		}
		catch(Exception e) {
			throw new BugNotFoundException("Bug details not found!");
		}
		bugDao.deleteById(bugId);
		return new ResponseEntity("Bug deleted successfully",HttpStatus.OK);
	}

	@Override
	public Bug getBug(int bugId) throws BugNotFoundException {
		Bug bean = null;
		try {
			bean = bugDao.findById(bugId).get();
		}
		catch(Exception e) {
			throw new BugNotFoundException("Bug details not found!");
		}
		return bean;
	}

	@Override
	public List<Bug> getAllBugs() throws BugNotFoundException {
		return bugDao.findAll();
	}

	@Override
	public List<Bug> getBugsByStatus(String status) throws BugNotFoundException {
		List<Bug> bugs = new ArrayList<Bug>();
		try {
			for(Bug i : bugDao.findAll()) {
				if(i.getBugStatus().equals(status)) {
					bugs.add(i);
				}
			}
		}
		catch(Exception e) {
			throw new BugNotFoundException("Bug details not found!");
		}
		return bugs;
	}

	@Override
	public ResponseEntity transferBug(Bug bug, Staff staff) throws BugNotFoundException {
		Bug bean = null;
		try {
			bean = bugDao.findById(bug.getBugId()).get();
		}
		catch(Exception e) {
			throw new BugNotFoundException("Bug details not found!");
		}
		bug.setStaff(staff);
		return new ResponseEntity("Bug transfered successfully",HttpStatus.OK);
	}

	@Override
	public ResponseEntity resolveBug(Bug bug, Staff staff) throws BugNotFoundException {
		Bug bean = null;
		try {
			bean = bugDao.findById(bug.getBugId()).get();
		}
		catch(Exception e) {
			throw new BugNotFoundException("Bug details not found!");
		}
		bug.setBugStatus("Completed");
		return new ResponseEntity("Bug solved and email sent successfully",HttpStatus.OK);
	}

}
