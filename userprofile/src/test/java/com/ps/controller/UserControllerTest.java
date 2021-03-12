package com.ps.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ps.model.Address;
import com.ps.model.User;

@RunWith(SpringRunner.class)
@WebMvcTest(value=UserController.class)
public class UserControllerTest {
	
	@Autowired
	private MockMvc mockMvc;

	/*@Test
	@Order(2)
		public void getUserDetailsTest() throws Exception {
		
		MockHttpServletRequestBuilder getReq=MockMvcRequestBuilders.get("/user/Javed");
		 MvcResult result = mockMvc.perform(getReq).andReturn();
		 
		 MockHttpServletResponse response = result.getResponse();
		 System.out.println("Response ::"+response.getContentAsString());
		 int status = response.getStatus();
		 assertEquals(500, status);
		}*/
		
		
	@Test
	@Order(2)
		public void getUserDetailsWithDataTest() throws Exception {
		
		MockHttpServletRequestBuilder getReq=MockMvcRequestBuilders.get("/user/Javed");
		 MvcResult result = mockMvc.perform(getReq).andReturn();
		 
		 MockHttpServletResponse response = result.getResponse();
		 System.out.println("Response ::"+response.getContentAsString());
		 int status = response.getStatus();
		 assertEquals(200, status);
		}
	
	
	
	
	
	
	@Test
	@Order(1)
	public void getUserSaveTest() throws Exception {
		
		User user=new User();
		user.setFirstName("Javed");
		
		ObjectMapper mapper=new ObjectMapper();
		String reqJson=mapper.writeValueAsString(user);
		
		
	MockHttpServletRequestBuilder postReq = MockMvcRequestBuilders.post("/user").contentType(MediaType.APPLICATION_JSON).content(reqJson);
	
		 MvcResult result = mockMvc.perform(postReq).andReturn();
		 MockHttpServletResponse response = result.getResponse();
		 System.out.println("********Response ******** ::"+response.getContentAsString());
		 int status = response.getStatus();
		 assertEquals(201, status);
	}
	
	
	//testing for enum methods
	
	/*@Test
	public void giveOrderByAddressTest() {
		Address addr=new Address();
		
		addr.setAddress(Address.);
		
	}*/
	
	
	
	
	
	
	
	
	
	
}
