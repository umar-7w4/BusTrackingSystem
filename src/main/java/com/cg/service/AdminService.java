package com.cg.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.cg.exception.AdminNotFoundException;
import com.cg.model.Admin;


public interface AdminService {
	
	public ResponseEntity addAdmin(Admin admin) throws AdminNotFoundException;
	public ResponseEntity updateAdmin(Admin admin)  throws AdminNotFoundException;
	public ResponseEntity deleteAdmin(int adminId)  throws AdminNotFoundException;
	public Admin getAdmin(int adminId)  throws AdminNotFoundException;
	public List<Admin> getAllAdmins()  throws AdminNotFoundException;
}
