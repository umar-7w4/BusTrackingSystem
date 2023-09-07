package com.cg.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.http.ResponseEntity;

import com.cg.exception.AdminNotFoundException;
import com.cg.exception.TaskNotFoundException;
import com.cg.model.Admin;
import com.cg.model.Bug;
import com.cg.model.Staff;
import com.cg.model.Task;

public interface TaskService {
	
	public ResponseEntity addTask(Task task) throws TaskNotFoundException;
	public ResponseEntity updateTask(Task task)  throws TaskNotFoundException;
	public ResponseEntity deleteTask(int taskId)  throws TaskNotFoundException;
	public Task getTask(int taskId)  throws TaskNotFoundException;
	public List<Task> getAllTasks()  throws TaskNotFoundException;
	public List<Task> getTasksBetweenDate(LocalDate startDate) throws TaskNotFoundException;
	public List<Task> getTasksByStaff(Staff staff) throws TaskNotFoundException;
	public List<Bug> getBugsByTask(Task task) throws TaskNotFoundException;

}
