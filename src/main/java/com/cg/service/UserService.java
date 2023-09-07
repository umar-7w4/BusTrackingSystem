package com.cg.service;

import java.util.List;


import com.cg.exception.UserNotFoundException;
import com.cg.model.User;

public interface UserService {
	
	public User add(User user) throws UserNotFoundException;
	public User update(User user) throws UserNotFoundException;
	public User delete(User user) throws UserNotFoundException;
	public List<User> findByUsername(String username) throws UserNotFoundException;
	public User findById(int userId) throws UserNotFoundException;
	public User search(User user) throws UserNotFoundException;
	public String authenticate(User user) throws UserNotFoundException;
	public boolean changePassword(int userId, String oldPassword, String newPassword) throws UserNotFoundException ;
    public User registerUser(User user) throws UserNotFoundException;
    public List<User> forgetPassword(String username) throws UserNotFoundException;

}
