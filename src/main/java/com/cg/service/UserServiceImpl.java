package com.cg.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.exception.UserNotFoundException;
import com.cg.model.User;
import com.cg.repository.UserDao;


@Service("UserService")
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserDao userDao;

	@Override
	public User add(User user) throws UserNotFoundException {
		userDao.saveAndFlush(user);
		return user;
	}

	@Override
	public User update(User user) throws UserNotFoundException {
		User bean = null;
		try {
			bean = userDao.findById(user.getUserId()).get();
		}
		catch(Exception e) {
			throw new UserNotFoundException("User details not found!");
		}
		userDao.saveAndFlush(user);
		return bean;
	}

	@Override
	public User delete(User user) throws UserNotFoundException {
		User bean = null;
		try {
			bean = userDao.findById(user.getUserId()).get();
		}
		catch(Exception e) {
			throw new UserNotFoundException("User details not found!");
		}
		userDao.deleteById(user.getUserId());
		return bean;
	}

	@Override
	public List<User> findByUsername(String username) throws UserNotFoundException {
		List<User> users = new ArrayList<>();
		try {
			for(User i :userDao.findAll()) {
				if(i.getUsername().equals(username)) {
					users.add(i);
				}
			}
		}
		catch(Exception e) {
			throw new UserNotFoundException("User details not Found");
		}
		return users;
	}

	@Override
	public User findById(int userId) throws UserNotFoundException {
		User bean = null;
		try {
			bean = userDao.findById(userId).get();
		}
		catch(Exception e) {
			throw new UserNotFoundException("User details not found!");
		}
		return bean;
	}

	@Override
	public User search(User user) throws UserNotFoundException {
		User bean = null;
		try {
			bean = userDao.findById(user.getUserId()).get();
		}
		catch(Exception e) {
			throw new UserNotFoundException("User details not found!");
		}
		return bean;
	}

	@Override
	public String authenticate(User user) throws UserNotFoundException {
		User bean = null;
		try {
			bean = userDao.findById(user.getUserId()).get();
			for(User i : userDao.findAll()) {
				if(bean.getUsername().equals(i.getUsername())) {
					if(bean.getPassword().equals(i.getPassword())) {
						if(bean.getRole().equals(i.getRole())) {
							return "Authentication Successfull";
						}
					}
					return "User details not found! Invalid details";
				}
			}
		}
		catch(Exception e) {
			throw new UserNotFoundException("User details not found! Invalid details");
		}
		return null;
	}

	@Override
	public boolean changePassword(int userId, String oldPassword, String newPassword) throws UserNotFoundException {
		User user = null;
		try {
			user = userDao.findById(userId).get();
		}
		catch(Exception e) {
			throw new UserNotFoundException("User details not found");
		}
		user.setPassword(newPassword);
		return true;
	}

	@Override
	public User registerUser(User user) throws UserNotFoundException {
		userDao.saveAndFlush(user);
		return user;
	}

	@Override
	public List<User> forgetPassword(String username) throws UserNotFoundException {
		return findByUsername(username);
	}

}

