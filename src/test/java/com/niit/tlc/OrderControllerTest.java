package com.niit.tlc;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.springframework.ui.Model;
import org.springframework.web.servlet.ModelAndView;

import com.niit.tlc.controller.OrderController;
import com.niit.tlc.model.Address;
import com.niit.tlc.model.Customer;
import com.niit.tlc.model.Order;
import com.niit.tlc.model.Payment;
import com.niit.tlc.model.Product;
import com.niit.tlc.service.AddressService;
import com.niit.tlc.service.LoginService;
import com.niit.tlc.service.OrderService;
import com.niit.tlc.service.PaymentService;
import com.niit.tlc.service.ProductService;

import junit.framework.Assert;

public class OrderControllerTest {

	@InjectMocks
	OrderController orderController;

	@Mock
	private ProductService serv;

	@Mock
	private LoginService lserv;
	
	@Mock
	private OrderService oserv;

	@Mock
	private PaymentService payserv;

	@Mock
	private AddressService addserv;

	
	@Spy
	Model m;

	@Spy
	HttpServletRequest req;

	@Spy
	HttpSession ses;

	@Spy
	ModelAndView model;

}
/*	public void confirmOrder() {
		Customer c =mock(Customer.class);
		Product p = new Product();
		Payment payment = new Payment();
		Order order = new Order();
		Address add = new Address();

		int orderAmt=10;
		Long custid=101L;
		String pid="paymentId";
		System.out.println("Customer: "+c);
		when(lserv.findById(custid)).thenReturn(c);
		when(serv.findById(pid)).thenReturn(p);
		String aid="12";
		when(addserv.findById(aid)).thenReturn(add);
		
		assertEquals(orderController.confirmOrder(payment, order, orderAmt, custid, pid, req), "welcome");

	}

	@Test
	public void cancelOrder()
	{
		String oid="01";
		when(req.getSession()).thenReturn(ses);
		ModelAndView mav=new ModelAndView("orderlist");
		model=orderController.cancelOrder(oid, req);
		assertEquals(model.getViewName(), mav.getViewName());
	}
}*/