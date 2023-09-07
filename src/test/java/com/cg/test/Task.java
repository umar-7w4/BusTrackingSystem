package com.cg.test;


import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.cg.model.Admin;
import com.cg.model.Bug;
import com.cg.model.Complaint;
import com.cg.model.Staff;
import com.cg.model.Task;


@SpringBootTest
class TaskTest extends AbstractTest {

	@Override
	@BeforeEach
	public void setUp() {
		super.setUp();
	}

	
	@Test
	public void getTaskTest() throws Exception {
		
		String url = "/bts-task/addtask";
		Task task1 = new Task(1, LocalDate.now(), LocalDate.now(), new Staff());

		String inputJson = super.mapToJson(task1);
		MvcResult mvcResult1 = mvc.perform(
				MockMvcRequestBuilders.post(url).contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson))
				.andReturn();
		
		int status1 = mvcResult1.getResponse().getStatus();
		assertEquals(200, status1);
		
		String uri = "/bts-task/gettask/1";
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)).andReturn();
		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);

		String content = mvcResult.getResponse().getContentAsString();
		Task task = super.mapFromJson(content, Task.class);
		assertEquals(1, task.getTaskId());

	}

	@Test
	public void postTaskTest() throws Exception {
		String url = "/bts-task/addtask";
		Task task1 = new Task(1, LocalDate.now(), LocalDate.now(), new Staff());

		String inputJson = super.mapToJson(task1);
		MvcResult mvcResult1 = mvc.perform(
				MockMvcRequestBuilders.post(url).contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson))
				.andReturn();
		
		int status1 = mvcResult1.getResponse().getStatus();
		assertEquals(200, status1);
		
		String content = mvcResult1.getResponse().getContentAsString();

		Task taskObj[] = super.mapFromJson(content, Task[].class);
		assertEquals(1, taskObj[taskObj.length - 1].getTaskId());
		assertEquals(LocalDate.now(), taskObj[taskObj.length - 1].getStartDate());
		assertEquals(LocalDate.now(), taskObj[taskObj.length - 1].getLastDate());

	}
	
	@Test
	public void updateTaskTest() throws Exception {
		
		String url = "/bts-task/addtask";
		Task task1 = new Task(1, LocalDate.now(), LocalDate.now(), new Staff());

		String inputJson = super.mapToJson(task1);
		MvcResult mvcResult1 = mvc.perform(
				MockMvcRequestBuilders.post(url).contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson))
				.andReturn();
		
		int status1 = mvcResult1.getResponse().getStatus();
		assertEquals(200, status1);
		
		String uri = "/bts-task/updatetask";
		Task task = new Task(1, LocalDate.now(), LocalDate.now(), new Staff());

		String inputJson1 = super.mapToJson(task);
		MvcResult mvcResult = mvc.perform(
				MockMvcRequestBuilders.put(uri).contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson1))
				.andReturn();
		
		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
		
		String content = mvcResult.getResponse().getContentAsString();

		Task taskObj[] = super.mapFromJson(content, Task[].class);
		assertEquals(1, taskObj[taskObj.length - 1].getTaskId());
		assertEquals(LocalDate.now(), taskObj[taskObj.length - 1].getStartDate());
		assertEquals(LocalDate.now(), taskObj[taskObj.length - 1].getLastDate());

	}
	
	@Test
	public void deleteTaskTest() throws Exception {
		
		String url = "/bts-task/addtask";
		Task task1 = new Task(1, LocalDate.now(), LocalDate.now(), new Staff());

		String inputJson = super.mapToJson(task1);
		MvcResult mvcResult1 = mvc.perform(
				MockMvcRequestBuilders.post(url).contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson))
				.andReturn();
		
		int status1 = mvcResult1.getResponse().getStatus();
		assertEquals(200, status1);
		
		String uri = "/bts-task/task/1";
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.delete(uri)).andReturn();
		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);

		String content = mvcResult.getResponse().getContentAsString();
		Task task = super.mapFromJson(content, Task.class);
		assertEquals(1, task.getTaskId());


	}


}
