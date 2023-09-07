package com.cg.controller;

import java.time.LocalDate;
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
import com.cg.model.Bug;
import com.cg.model.Staff;
import com.cg.model.Task;
import com.cg.service.TaskService;

@RestController
@RequestMapping("/bts-task")
public class TaskController {
	
	@Autowired
	TaskService taskService;
	
	@PostMapping("/addtask")
	public ResponseEntity addTask(@RequestBody Task task) throws TaskNotFoundException{
		return taskService.addTask(task);
	}
	
	@PutMapping("/updatetask")
	public ResponseEntity updateTask(@RequestBody Task task)  throws TaskNotFoundException{
		return taskService.updateTask(task);
	}
	
	@DeleteMapping("/deletetask/{taskId}")
	public ResponseEntity deleteTask(@PathVariable int taskId)  throws TaskNotFoundException{
		return taskService.deleteTask(taskId);
	}
	
	@GetMapping("/gettask/{taskId}")
	public Task getTask(@PathVariable int taskId)  throws TaskNotFoundException{
		return taskService.getTask(taskId);
	}
	
	@GetMapping("/getalltasks")
	public List<Task> getAllTasks()  throws TaskNotFoundException{
		return taskService.getAllTasks();
	}
	
	@GetMapping("/gettaskbydate/{startDate}")
	public List<Task> getTasksBetweenDate(@PathVariable LocalDate startDate) throws TaskNotFoundException{
		return taskService.getTasksBetweenDate(startDate);
	}
	
	@GetMapping("/gettasksbystaff")
	public List<Task> getTasksByStaff(@RequestBody Staff staff) throws TaskNotFoundException{
		return taskService.getTasksByStaff(staff);
	}
	
	@GetMapping("/getbugsbytask")
	public List<Bug> getBugsByTask(@RequestBody Task task) throws TaskNotFoundException{
		return taskService.getBugsByTask(task);
	}

}
