package com.niit.tlc;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import javax.servlet.http.HttpServletRequest;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.ui.Model;

import com.niit.tlc.controller.AddressController;
import com.niit.tlc.controller.CustomerCredController;
import com.niit.tlc.model.Address;
import com.niit.tlc.model.Customer;
import com.niit.tlc.model.Order;
import com.niit.tlc.model.Payment;
import com.niit.tlc.service.AddressService;
import com.niit.tlc.service.LoginService;

public class AddressControllerTest {
	@InjectMocks
	AddressController addressController;
	
	@InjectMocks
	CustomerCredController customerController;
	
	@Mock
	private AddressService addServ;

	@Mock
	private LoginService lserv;
	
	@Spy
	HttpServletRequest req;
	 @Spy
	 Model model;
	 
	@Before
	public void init()
	{
		MockitoAnnotations.initMocks(this);
	}
@Test
public void saveAddress()
{	
 
 
	Address a1= new Address();
	a1.setCity("kanpur");
	a1.setHouseNumber("panchwati");
	a1.setPincode(208925);
	a1.setState("up");
	addServ.saveAddress(a1);
	verify(addServ,times(1)).saveAddress(a1);
	
}

@Test
public void confirmOrd()
{
	Order or=new Order();
	

	Assert.assertEquals( addressController.confirmOrd(model),"confirm-order");
}
@Test
public void checkout()
{
	Payment payment=new Payment();
	Address add = new Address();
	Assert.assertEquals( addressController.checkOut(model, add, req),"checkout-page");
	
}
}