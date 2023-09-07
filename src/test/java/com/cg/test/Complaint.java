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
class ComplaintTest extends AbstractTest {

	@Override
	@BeforeEach
	public void setUp() {
		super.setUp();
	}


	
	@Test
	public void getBugTest() throws Exception {
		
		String url = "/bts-complaint/addcomplaint";
		Complaint complaint1 = new Complaint(1, "Pending", "Java beans not working", LocalDate.now(), new Staff(), new Task());

		String inputJson = super.mapToJson(complaint1);
		MvcResult mvcResult1 = mvc.perform(
				MockMvcRequestBuilders.post(url).contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson))
				.andReturn();
		
		int status1 = mvcResult1.getResponse().getStatus();
		assertEquals(200, status1);
		
		String uri = "/bts-complaint/getcomplaint/1";
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)).andReturn();
		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);

		String content = mvcResult.getResponse().getContentAsString();
		Complaint complaint = super.mapFromJson(content, Complaint.class);
		assertEquals(1, complaint.getComplaintId());

	}

	@Test
	public void postComplaintTest() throws Exception {
		String url = "/bts-complaint/addcomplaint";
		Complaint complaint1 = new Complaint(1, "Pending", "Java beans not working", LocalDate.now(), new Staff(), new Task());

		String inputJson = super.mapToJson(complaint1);
		MvcResult mvcResult1 = mvc.perform(
				MockMvcRequestBuilders.post(url).contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson))
				.andReturn();
		
		int status1 = mvcResult1.getResponse().getStatus();
		assertEquals(200, status1);
		
		String content = mvcResult1.getResponse().getContentAsString();

		Complaint complaintObj[] = super.mapFromJson(content, Complaint[].class);
		assertEquals(1, complaintObj[complaintObj.length - 1].getComplaintId());
		assertEquals("Pending", complaintObj[complaintObj.length - 1].getComplaintStatus());
		assertEquals("Java beans not working", complaintObj[complaintObj.length - 1].getComplaintDesciption());

	}
	
	@Test
	public void updateComplaintTest() throws Exception {
		
		String url = "/bts-complaint/addcomplaint";
		Complaint complaint1 = new Complaint(1, "Pending", "Page beans not working", LocalDate.now(), new Staff(), new Task());

		String inputJson = super.mapToJson(complaint1);
		MvcResult mvcResult1 = mvc.perform(
				MockMvcRequestBuilders.post(url).contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson))
				.andReturn();
		
		int status1 = mvcResult1.getResponse().getStatus();
		assertEquals(200, status1);
		
		String uri = "/bts-complaint/updatecomplaint";
		Complaint complaint = new Complaint(1, "Pending", "Java beans not working", LocalDate.now(), new Staff(), new Task());

		String inputJson1 = super.mapToJson(complaint);
		MvcResult mvcResult = mvc.perform(
				MockMvcRequestBuilders.put(uri).contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson1))
				.andReturn();
		
		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
		
		String content = mvcResult.getResponse().getContentAsString();

		Complaint complaintObj[] = super.mapFromJson(content, Complaint[].class);
		assertEquals(1, complaintObj[complaintObj.length - 1].getComplaintId());
		assertEquals("Pending", complaintObj[complaintObj.length - 1].getComplaintStatus());
		assertEquals("Java beans not working", complaintObj[complaintObj.length - 1].getComplaintDesciption());

	}
	
	@Test
	public void deleteComplaintTest() throws Exception {
		
		
		String url = "/bts-complaint/addcomplaint";
		Complaint complaint1 = new Complaint(1, "Pending", "Java beans not working", LocalDate.now(), new Staff(), new Task());

		String inputJson = super.mapToJson(complaint1);
		MvcResult mvcResult1 = mvc.perform(
				MockMvcRequestBuilders.post(url).contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson))
				.andReturn();
		
		int status1 = mvcResult1.getResponse().getStatus();
		assertEquals(200, status1);
		
		String uri = "/bts-complaint/complaint/1";
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.delete(uri)).andReturn();
		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);

		String content = mvcResult.getResponse().getContentAsString();
		Bug bug = super.mapFromJson(content, Bug.class);
		assertEquals(1, bug.getBugId());

	}


}
