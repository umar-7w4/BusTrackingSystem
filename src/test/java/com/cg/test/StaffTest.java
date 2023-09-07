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
import com.cg.model.Staff;
import com.cg.model.Task;
import com.cg.model.User;


@SpringBootTest
class StaffTest extends AbstractTest {

	@Override
	@BeforeEach
	public void setUp() {
		super.setUp();
	}


	
	@Test
	public void getStaffTest() throws Exception {
		
		String url = "/bts-staff/addstaff";
		Staff staff1 = new Staff(1, "Nikhil_89", "Nikhil009", new User());

		String inputJson = super.mapToJson(staff1);
		MvcResult mvcResult1 = mvc.perform(
				MockMvcRequestBuilders.post(url).contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson))
				.andReturn();
		
		int status1 = mvcResult1.getResponse().getStatus();
		assertEquals(200, status1);
		
		String uri = "/bts-staff/getstaff/1";
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)).andReturn();
		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);

		String content = mvcResult.getResponse().getContentAsString();
		Staff staff = super.mapFromJson(content, Staff.class);
		assertEquals(1, staff.getStaffId());

	}

	@Test
	public void postStaffTest() throws Exception {
		
		String url = "/bts-staff/addstaff";
		Staff staff1 = new Staff(1, "Nikhil_89", "Nikhil009", new User());

		String inputJson = super.mapToJson(staff1);
		MvcResult mvcResult = mvc.perform(
				MockMvcRequestBuilders.post(url).contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson))
				.andReturn();
		
		int status1 = mvcResult.getResponse().getStatus();
		assertEquals(200, status1);
		
		String content = mvcResult.getResponse().getContentAsString();

		Staff staffObj[] = super.mapFromJson(content, Staff[].class);
		assertEquals(1, staffObj[staffObj.length - 1].getStaffId());
		assertEquals("Nikhil_89", staffObj[staffObj.length - 1].getUsername());
		assertEquals("Nikhil009", staffObj[staffObj.length - 1].getPassword());

	}
	
	@Test
	public void updateStaffTest() throws Exception {
		
		String uri = "/bts-staff/addstaff";
		Staff staff = new Staff(1, "Nikhil_89", "Nikhil009", new User());

		String inputJson1 = super.mapToJson(staff);
		MvcResult mvcResult1 = mvc.perform(
				MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson1))
				.andReturn();
		
		int status = mvcResult1.getResponse().getStatus();
		assertEquals(200, status);
		
		String url = "/bts-staff/updatestaff";
		Staff staff1 = new Staff(1, "Nikhil_89", "Nikhil009", new User());

		String inputJson = super.mapToJson(staff1);
		MvcResult mvcResult = mvc.perform(
				MockMvcRequestBuilders.put(url).contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson))
				.andReturn();
		
		int status1 = mvcResult.getResponse().getStatus();
		assertEquals(200, status1);
		
		String content = mvcResult.getResponse().getContentAsString();

		Staff staffObj[] = super.mapFromJson(content, Staff[].class);
		assertEquals(1, staffObj[staffObj.length - 1].getStaffId());
		assertEquals("Nikhil_89", staffObj[staffObj.length - 1].getUsername());
		assertEquals("Nikhil009", staffObj[staffObj.length - 1].getPassword());


	}
	
	@Test
	public void deleteStaffTest() throws Exception {
		
		
		
		String url = "/bts-staff/addstaff";
		Staff staff1 = new Staff(1, "Nikhil_89", "Nikhil009", new User());

		String inputJson = super.mapToJson(staff1);
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