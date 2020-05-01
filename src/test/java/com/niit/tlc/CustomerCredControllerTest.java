package com.niit.tlc;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.ui.Model;
import org.springframework.web.servlet.ModelAndView;

import com.niit.tlc.controller.CustomerCredController;
import com.niit.tlc.controller.OrderController;
import com.niit.tlc.model.Customer;
import com.niit.tlc.model.Order;
import com.niit.tlc.model.Product;
import com.niit.tlc.service.LoginService;
import com.niit.tlc.service.OrderService;



public class CustomerCredControllerTest {

	@InjectMocks
	CustomerCredController customerCredController;

	@Mock
	private LoginService lService;

	@Mock
	private OrderService oserv;

	@Spy
	HttpServletRequest httpServlet;

	@Spy
	Model m;

	@Spy
	HttpServletRequest req;

	@Spy
	HttpSession ses;

	@Spy
	Model model;

	@Spy
	ModelAndView modelView;

	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void viewRegisterPageTest() {
		Assert.assertEquals(customerCredController.viewRegisterPage(model), "customer-form");
	}

	@Test
	public void viewHomePage() {
		Assert.assertEquals(customerCredController.viewHomePage(), "index");

	}

	@Test
	public void viewHomePageTest() {
		when(lService.listAll()).thenReturn(new ArrayList<Customer>());
		assertEquals(customerCredController.viewHomePage(model), "customerList");

	}

	@Test
	public void LoginPage() {
		Assert.assertEquals(customerCredController.LoginPage(), "login-customer");

	}

	@Test
	public void createCustomerTest() {
		Customer c1 = new Customer();
		c1.setEmailId("harshi@123");

		c1.setFirstName("harhsita");
		c1.setLastName("sharma");
		c1.setPassword("har123");
		c1.setPhoneNo((long) 700797829);

		lService.saveCustomer(c1);
		verify(lService, times(1)).saveCustomer(c1);

	}

	@Test
	public void showLoginForm() {
		Assert.assertEquals(customerCredController.showLoginForm(model), "login-customer");

	}

	@Test
	public void loginCustomer() {
		long customerPhoneno = 700787927L;
		Customer c = null;

		System.out.println("Customer: " + c);

		modelView = new ModelAndView("login-customer");
		ModelAndView mv = customerCredController.loginCustomer(customerPhoneno, "aGFyczEyMw==", req, c);
		assertEquals(modelView.getViewName(), mv.getViewName());

	}
	@Test
	public void showEditPage()
	{
		Customer c = new Customer();
		Long custPhn=70078654L;
		
		 when(req.getSession()).thenReturn(ses);
		 when(lService.findById(custPhn)).thenReturn(c);
		
		 
		 
		 
	}

	@Test
	public void loginCustomerEmailAndPasswordNotMatchTest() {
		long customerPhoneno = 700787927L;
		Customer c = new Customer();
		Long phoneNo = 7007867488L;
		String password = "123";
		
		c.setPhoneNo(phoneNo);
		c.setPassword(password);
		when(lService.findById(phoneNo)).thenReturn(c);
		assertEquals(c.getPhoneNo(), phoneNo);
		assertEquals(c.getPassword(),encryptPass(password));
		when(req.getSession()).thenReturn(ses);
	
		System.out.println("Customer: " + c);

		modelView = new ModelAndView("login-customer");
		ModelAndView mv = customerCredController.loginCustomer(customerPhoneno, "aGFyczEyMw==", req, c);
		assertEquals(modelView.getViewName(), mv.getViewName());

	}
	public String encryptPass(String pass) {
		Base64.Encoder encoder = Base64.getEncoder();
		String normalString = pass;
		String encodedString = encoder.encodeToString(
	    normalString.getBytes(StandardCharsets.UTF_8) );
		return encodedString;
	}
	


	@Test
	public void saveProduct() {

		Customer c = new Customer();
		Assert.assertEquals(customerCredController.saveProduct(c), "login-customer");

	}

	@Test
	public void editCustomerForm() {
		Customer cust = new Customer();
		modelView = new ModelAndView("viewP");
		ModelAndView mav = customerCredController.editCustomerForm(cust);
		cust.getPhoneNo();
		when(lService.saveCustomer(cust)).thenReturn(cust);

		Assert.assertEquals(modelView.getViewName(),mav.getViewName());

	}
//	@Test
//	public void viewOrders()
//	{
//	
//		List<Order> ordrdprdcts=new ArrayList<Order>();
//		when(oserv.findByCustomersList()).thenReturn(ordrdprdcts);
//		
//CustomerCredController customerCredController = new CustomerCredController();
//
//ModelAndView mav=new ModelAndView("orderList");
//
//	}

	@Test

	public void viewIndexPage() {
		
		Assert.assertEquals(customerCredController.viewIndexPage(), "welcome");
	}

	@Test
	public void viewdashboard() {
		Assert.assertEquals(customerCredController.viewDashboard(), "customerDashboard");

	}

	@Test
	public void deleteProduct() {
		assertEquals(customerCredController.unactivateCustomer(700797829), "redirect:customerList");

	}

	@Test
	public void logoutTest() {
		when(req.getSession()).thenReturn(ses);
		Assert.assertEquals(customerCredController.logout(req), "index");
	}

}