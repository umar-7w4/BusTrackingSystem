package com.cg.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.exception.AdminNotFoundException;
import com.cg.model.Admin;
import com.cg.service.AdminService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/bts-admin")
public class AdminController {
	
	@Autowired
	AdminService adminService;
	
	@PostMapping("/addadmin")
	public ResponseEntity addAdmin(@RequestBody Admin admin) throws AdminNotFoundException{
		return adminService.addAdmin(admin);
	}
	
	@PutMapping("/updateadmin")
	public ResponseEntity updateAdmin(@RequestBody Admin admin)  throws AdminNotFoundException{
		return adminService.updateAdmin(admin);
	}
	
	@DeleteMapping("/deleteadmin/{adminId}")
	public ResponseEntity deleteAdmin(@PathVariable int adminId)  throws AdminNotFoundException{
		return adminService.deleteAdmin(adminId);
	}
	
	@GetMapping("/getadmin/{adminId}")
	public Admin getAdmin(@PathVariable int adminId)  throws AdminNotFoundException{
		return adminService.getAdmin(adminId);
	}
	
	@GetMapping("/getalladmin")
	public List<Admin> getAllAdmins()  throws AdminNotFoundException{
		return adminService.getAllAdmins();
	}

}

// https://localhost:8080/bts-admin/deleteadmin/1001