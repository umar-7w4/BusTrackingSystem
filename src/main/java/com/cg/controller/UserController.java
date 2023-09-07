package com.cg.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

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

import com.cg.exception.TaskNotFoundException;
import com.cg.exception.UserNotFoundException;
import com.cg.model.Bug;
import com.cg.model.Staff;
import com.cg.model.Task;
import com.cg.model.User;
import com.cg.service.TaskService;
import com.cg.service.UserService;

@RestController
@RequestMapping("/bts-user")
public class UserController {
	
	@Autowired
	UserService userService;
	
	@PostMapping("/adduser")
	public User add(User user) throws UserNotFoundException{
		return userService.add(user);
	}
	
	@PutMapping("/updateuser")
	public User update(User user) throws UserNotFoundException{
		return userService.update(user);
	}
	
	@DeleteMapping("/deleteuser")
	public User delete(User user) throws UserNotFoundException{
		return userService.delete(user);
	}
	
	@GetMapping("/getuserbyusername/{username}")
	public List<User> findByUsername(String username) throws UserNotFoundException{
		return userService.findByUsername(username);
	}
	
	@GetMapping("/getuserbyid/{userId}")
	public User findById(int userId) throws UserNotFoundException{
		return userService.findById(userId);
	}
	
	@GetMapping("/getuserbyid")
	public User search(User user) throws UserNotFoundException{
		return userService.search(user);
	}
	
	@GetMapping("/authenticate")
	public String authenticate(User user) throws UserNotFoundException{
		return userService.authenticate(user);
	}
	
	@GetMapping("/changepassword/{userId}/{oldPassword}/{newPassword}")
	public boolean changePassword(int userId, String oldPassword, String newPassword) throws UserNotFoundException {
		return userService.changePassword(userId, oldPassword, newPassword);
	}
	
	@GetMapping("/registeruser")
    public User registerUser(User user) throws UserNotFoundException{
    	return userService.registerUser(user);
    }
	
	@GetMapping("/forgetpassword/{username}")
    public List<User> forgetPassword(String username) throws UserNotFoundException{
    	return userService.forgetPassword(username);
    }


}
