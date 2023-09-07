package com.cg.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.cg.exception.AdminNotFoundException;
import com.cg.model.Admin;
import com.cg.repository.*;

@Service("AdminService")
public class AdminServiceImpl implements AdminService{
	
	@Autowired
	AdminDao adminDao;

	@Override
	public ResponseEntity addAdmin(Admin admin) throws AdminNotFoundException {
		adminDao.saveAndFlush(admin);
		return  new ResponseEntity("Admin inserted successfully",HttpStatus.OK);
	}

	@Override
	public ResponseEntity updateAdmin(Admin admin)  throws AdminNotFoundException{
		Admin bean = null;
		try {
			bean = adminDao.findById(admin.getAdminId()).get();
		}
		catch(Exception e) {
			throw new AdminNotFoundException("Admin details not found!");
		}
		adminDao.saveAndFlush(admin);
		return new ResponseEntity("Admin updated successfully",HttpStatus.OK);
	}

	@Override
	public ResponseEntity deleteAdmin(int adminId) throws AdminNotFoundException {
		Admin bean = null;
		try {
			bean = adminDao.findById(adminId).get();
		}
		catch(Exception e) {
			throw new AdminNotFoundException("Admin details not found!");
		}
		adminDao.deleteById(adminId);
		return new ResponseEntity("Admin deleted successfully",HttpStatus.OK);
	}

	@Override
	public Admin getAdmin(int adminId)  throws AdminNotFoundException{
		Admin bean = null;
		try {
			bean = adminDao.findById(adminId).get();
		}
		catch(Exception e) {
			throw new AdminNotFoundException("Admin details not found!");
		}
		return bean;
	}

	@Override
	public List<Admin> getAllAdmins()  throws AdminNotFoundException{
		return adminDao.findAll();
	}

}
