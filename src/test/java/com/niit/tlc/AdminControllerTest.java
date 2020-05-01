package com.niit.tlc;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import javax.servlet.http.HttpServletRequest;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.springframework.ui.Model;
import org.springframework.web.servlet.ModelAndView;

import com.niit.tlc.controller.AdminHomeController;
import com.niit.tlc.model.Customer;

public class AdminControllerTest {
	@InjectMocks 
	AdminHomeController admincontroller;
	@Spy
	HttpServletRequest httpServlet;
	@Spy
	Model model;

	@Before
	public void init()
	{
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void viewAdminLoginTest()
	{
		Assert.assertEquals( admincontroller.adminPage(),"adminLogin");
	}
	
	@Test
	public void viewAdminPageTest()
	{
		Assert.assertEquals( admincontroller.AdminPage(),"admin");
	}

		@Test
		public void customerManagementTest()
		{
			Assert.assertEquals(admincontroller.customerManagement(model),"customerManagement");
		}
		@Test
		public void productManagement()
		{
			Assert.assertEquals(admincontroller.productManagement(model),"productManagement");
		}
	
		}