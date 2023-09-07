package com.cg.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.cg.exception.ComplaintNotFoundException;
import com.cg.exception.StaffNotFoundException;
import com.cg.exception.TaskNotFoundException;
import com.cg.model.Bug;
import com.cg.model.Complaint;
import com.cg.model.Staff;
import com.cg.model.Task;
import com.cg.repository.TaskDao;

@Service("TaskService")
public class TaskServiceImpl implements TaskService{
	
	@Autowired
	TaskDao taskDao;

	@Override
	public ResponseEntity addTask(Task task) throws TaskNotFoundException {
		taskDao.saveAndFlush(task);
		return new ResponseEntity("Task inserted successfully",HttpStatus.OK);
	}

	@Override
	public ResponseEntity updateTask(Task task) throws TaskNotFoundException {
		Task bean = null;
		try {
			bean = taskDao.findById(task.getTaskId()).get();
		}
		catch(Exception e) {
			throw new TaskNotFoundException("Task details not found!");
		}
		taskDao.saveAndFlush(task);
		return new ResponseEntity("Task updated successfully",HttpStatus.OK);
	}

	@Override
	public ResponseEntity deleteTask(int taskId) throws TaskNotFoundException {
		Task bean = null;
		try {
			bean = taskDao.findById(taskId).get();
		}
		catch(Exception e) {
			throw new TaskNotFoundException("Task details not found!");
		}
		taskDao.deleteById(taskId);
		return new ResponseEntity("Task deleted successfully",HttpStatus.OK);
	}

	@Override
	public Task getTask(int taskId) throws TaskNotFoundException {
		Task bean = null;
		try {
			bean = taskDao.findById(taskId).get();
		}
		catch(Exception e) {
			throw new TaskNotFoundException("Task details not found!");
		}
		return bean;
	}

	@Override
	public List<Task> getAllTasks() throws TaskNotFoundException {
		return taskDao.findAll();
	}

	@Override
	public List<Task> getTasksBetweenDate(LocalDate startDate) throws TaskNotFoundException {
		List<Task> tasks = new ArrayList<Task>();
		try {
			for(Task i : taskDao.findAll()) {
				if(i.getStartDate().equals(startDate)) {
					tasks.add(i);
				}
			}
		}
		catch(Exception e) {
			throw new TaskNotFoundException("Task details not found!");
		}
		return tasks;
	}

	@Override
	public List<Task> getTasksByStaff(Staff staff) throws TaskNotFoundException {
		List<Task> tasks = new ArrayList<Task>();
		try {
			for(Task i : taskDao.findAll()) {
				if(i.getStaff().equals(staff)) {
					tasks.add(i);
				}
			}
		}
		catch(Exception e) {
			throw new TaskNotFoundException("Task details not found!");
		}
		return tasks;
	}

	@Override
	public List<Bug> getBugsByTask(Task task) throws TaskNotFoundException {
		return task.getBugs();
	}

}
