package com.cg.test;


import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.cg.model.Admin;


@SpringBootTest
class AdminTest extends AbstractTest {

	@Override
	@BeforeEach
	public void setUp() {
		super.setUp();
	}

	@Test
	public void getAdminTest() throws Exception {
		
		String url = "/bts-admin/addadmin";
		Admin admin1 = new Admin(1, "nikhil_12", "Nikhil&*xyz");

		String inputJson = super.mapToJson(admin1);
		MvcResult mvcResult1 = mvc.perform(
				MockMvcRequestBuilders.post(url).contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson))
				.andReturn();
		
		int status1 = mvcResult1.getResponse().getStatus();
		assertEquals(200, status1);
		
		String uri = "/bts-admin/getadmin/1";
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)).andReturn();
		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);

		String content = mvcResult.getResponse().getContentAsString();
		Admin admin = super.mapFromJson(content, Admin.class);
		assertEquals(1, admin.getAdminId());

	}

	@Test
	public void postAdminTest() throws Exception {
		String uri = "/bts-admin/addadmin";
		Admin admin = new Admin(1, "nikhil_12", "Nikhil@#$123");

		String inputJson = super.mapToJson(admin);
		MvcResult mvcResult = mvc.perform(
				MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson))
				.andReturn();

		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
		String content = mvcResult.getResponse().getContentAsString();

		Admin adminObj[] = super.mapFromJson(content, Admin[].class);
		assertEquals(1, adminObj[adminObj.length - 1].getAdminId());
		assertEquals("nikhil_12", adminObj[adminObj.length - 1].getUsername());
		assertEquals("Nikhil@#$123", adminObj[adminObj.length - 1].getPassword());

	}
	
	@Test
	public void updateAdminTest() throws Exception {
		
		String url = "/bts-admin/addadmin";
		Admin admin1 = new Admin(1, "nikhil_12", "Nikhil@#$123");

		String inputJson1 = super.mapToJson(admin1);
		MvcResult mvcResult1 = mvc.perform(
				MockMvcRequestBuilders.post(url).contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson1))
				.andReturn();

		int status1 = mvcResult1.getResponse().getStatus();
		assertEquals(200, status1);
		
		String uri = "/bts-admin/updateadmin";
		Admin admin = new Admin(1, "nikhil_12", "Nikhil&*xyz");

		String inputJson = super.mapToJson(admin);
		MvcResult mvcResult = mvc.perform(
				MockMvcRequestBuilders.put(uri).contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson))
				.andReturn();

		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
		String content = mvcResult.getResponse().getContentAsString();

		Admin adminObj[] = super.mapFromJson(content, Admin[].class);
		assertEquals(1, adminObj[adminObj.length - 1].getAdminId());
		assertEquals("nikhil_12", adminObj[adminObj.length - 1].getUsername());
		assertEquals("Nikhil&*xyz", adminObj[adminObj.length - 1].getPassword());

	}
	
	@Test
	public void deleteAdminTest() throws Exception {
		
		String uri = "/bts-admin/updateadmin";
		Admin admin = new Admin(1, "nikhil_12", "Nikhil&*xyz");

		String inputJson = super.mapToJson(admin);
		MvcResult mvcResult = mvc.perform(
				MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson))
				.andReturn();
		
		int status1 = mvcResult.getResponse().getStatus();
		assertEquals(200, status1);
		
		String url = "/bts-admin/deletebug/1";
		MvcResult mvcResult2 = mvc.perform(MockMvcRequestBuilders.delete(url)).andReturn();
		int status = mvcResult2.getResponse().getStatus();
		assertEquals(200, status);

		String content = mvcResult.getResponse().getContentAsString();
		Admin admin1 = super.mapFromJson(content, Admin.class);
		assertEquals(1, admin1.getAdminId());

	}


}