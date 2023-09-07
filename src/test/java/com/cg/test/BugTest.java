package com.cg.test;


import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.cg.model.Admin;
import com.cg.model.Bug;
import com.cg.model.Complaint;
import com.cg.model.Task;


@SpringBootTest
class BugTest extends AbstractTest {

	@Override
	@BeforeEach
	public void setUp() {
		super.setUp();
	}


	
	@Test
	public void getBugTest() throws Exception {
		
		String url = "/bts-bug/addbug";
		Bug bug1 = new Bug(1, "Pending", "Java beans not working", new Task(), new Complaint());

		String inputJson = super.mapToJson(bug1);
		MvcResult mvcResult1 = mvc.perform(
				MockMvcRequestBuilders.post(url).contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson))
				.andReturn();
		
		int status1 = mvcResult1.getResponse().getStatus();
		assertEquals(200, status1);
		
		String uri = "/bts-bug/getbug/1";
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)).andReturn();
		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);

		String content = mvcResult.getResponse().getContentAsString();
		Bug bug = super.mapFromJson(content, Bug.class);
		assertEquals(1, bug.getBugId());

	}

	@Test
	public void postBugTest() throws Exception {
		String uri = "/bts-bug/addbug";
		Bug bug = new Bug(1, "Pending", "Java beans not working", new Task(), new Complaint());

		String inputJson = super.mapToJson(bug);
		MvcResult mvcResult = mvc.perform(
				MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson))
				.andReturn();
		
		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
		
		String content = mvcResult.getResponse().getContentAsString();

		Bug bugObj[] = super.mapFromJson(content, Bug[].class);
		assertEquals(1, bugObj[bugObj.length - 1].getBugId());
		assertEquals("Pending", bugObj[bugObj.length - 1].getBugStatus());
		assertEquals("Java beans not working", bugObj[bugObj.length - 1].getBugDescription());

	}
	
	@Test
	public void updateBugTest() throws Exception {
		
		String url = "/bts-bug/addbug";
		Bug bug1 = new Bug(1, "Pending", "Java beans not working", new Task(), new Complaint());

		String inputJson1 = super.mapToJson(bug1);
		MvcResult mvcResult1 = mvc.perform(
				MockMvcRequestBuilders.post(url).contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson1))
				.andReturn();
		
		int status1 = mvcResult1.getResponse().getStatus();
		assertEquals(200, status1);
		
		String uri = "/bts-bug/updatebug";
		Bug bug = new Bug(1, "Pending", "Admin page not working", new Task(), new Complaint());

		String inputJson = super.mapToJson(bug);
		MvcResult mvcResult = mvc.perform(
				MockMvcRequestBuilders.put(uri).contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson))
				.andReturn();
		
		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
		
		String content = mvcResult.getResponse().getContentAsString();

		Bug bugObj[] = super.mapFromJson(content, Bug[].class);
		assertEquals(1, bugObj[bugObj.length - 1].getBugId());
		assertEquals("Pending", bugObj[bugObj.length - 1].getBugStatus());
		assertEquals("Admin page not working", bugObj[bugObj.length - 1].getBugDescription());

	}
	
	@Test
	public void deleteBugTest() throws Exception {
		
		
		String url = "/bts-bug/addbug";
		Bug bug1 = new Bug(1, "Pending", "Java beans not working", new Task(), new Complaint());

		String inputJson = super.mapToJson(bug1);
		MvcResult mvcResult1 = mvc.perform(
				MockMvcRequestBuilders.post(url).contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson))
				.andReturn();
		
		int status1 = mvcResult1.getResponse().getStatus();
		assertEquals(200, status1);
		
		String uri = "/bts-bug/deletebug/1";
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.delete(uri)).andReturn();
		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);

		String content = mvcResult.getResponse().getContentAsString();
		Bug bug = super.mapFromJson(content, Bug.class);
		assertEquals(1, bug.getBugId());

	}


}