package com.niit.tlc;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.ui.Model;
import org.springframework.web.servlet.ModelAndView;

import com.niit.tlc.controller.ProductController;
import com.niit.tlc.model.Address;
import com.niit.tlc.model.Product;
import com.niit.tlc.service.ProductService;

public class ProductControllerTest {
	@InjectMocks
	ProductController  productController;
	@Mock
	private ProductService serv;
	@Spy
	Model model;
	@Spy
	ModelAndView modelAndView;
	@Spy
	HttpServletRequest req;
	@Spy
	HttpSession ses;

	
	
	@Before
	public void init()
	{
		MockitoAnnotations.initMocks(this);
	}
	@Test
	public void saveProductTest()
	{
		Product product= new Product();
		product.setProductId("12");
		product.setProductName("Tv");
		product.setProductBrand("lg");
	product.setProductCategory("led");
	product.setProductPrice(3000);
	product.setProductDescription("company gives subscription");
	serv.saveProduct(product);
	
		verify(serv,times(1)).saveProduct(product);
		
	
		
}
//@Test
//public void productMobile()
//{
//	List<Product> listProduct=new ArrayList<Product>();
//when(serv.findByproductCategory("Mobile")).thenReturn(listProduct);
//ProductController productController=new ProductController();
//
//ReflectionTestUtils.setField(productController,"serv",serv);
//System.out.println("getProductId");
//modelAndView= productController.productMob();
//ModelAndView mav=new ModelAndView("temp2");
//assertEquals(modelAndView.getViewName(),mav.getViewName());
//
//
//}
@Test
public void uploadImage()
{
	Product product = new Product();
	int prdct=13;
	assertEquals( productController.uploadImage(product),"redirect:/productlistAdmin");
	
}
		@Test
	public void uploadImageTest()

	{

		Assert.assertEquals( productController.uploadImageDemo(model),"product_validateAdmin");
		
	
	
	}
//	
//	@Test
//	public void productTv()
//	{
//		
//		List<Product>listProducts=new ArrayList<Product>();
//		listProducts.add(new Product());
//		when(serv.findByproductCategory("cat")).thenReturn(listProducts);
//		
//		ProductController productController=new ProductController();
//		
//		ReflectionTestUtils.setField(productController,"serv",serv);
////	
////		modelAndView= productController.productTv();
//		ModelAndView mav=new ModelAndView("temp2");
//		assertEquals(modelAndView.getViewName(),mav.getViewName());
//	}
	@Test 
	public void deleteProduct()
	{
		assertEquals(productController.deleteProduct("1"),"redirect:/productlistAdmin");
		
	}
	@Test
	public void UpdateProduct()
	{
		Product p = new Product();
		String pid="12";
		when(serv.get(pid)).thenReturn(p);
		modelAndView=productController.updateProduct("12");
		ModelAndView mav=new ModelAndView("update-productList");
		assertEquals(modelAndView.getViewName(),mav.getViewName());

	}
	@Test
	
	public void productListAdmin()
	{
		List<Product>productList=new ArrayList<Product>();
		productList.add(new Product());
		when(serv.findAllProducts()).thenReturn(productList);
	ProductController productController=new ProductController();
		
		ReflectionTestUtils.setField(productController,"serv",serv);
		modelAndView= productController.productListAdmin();
		ModelAndView mav=new ModelAndView("product-list-admin");
		assertEquals(modelAndView.getViewName(),mav.getViewName());
	
		
	}
//	@Test
//	public void updateProduct()
//	{
//		Product product = new Product();
//		List<Product>productList=new ArrayList<Product>();
//		when(serv.findAllProducts()).thenReturn(productList);
//		when(serv.findAllProducts()).thenReturn(productList);
//		ProductController productController=new ProductController();
//			
//			ReflectionTestUtils.setField(productController,"serv",serv);
//			
//			modelAndView= productController.updateProductsave(product);
////			ModelAndView mav=new ModelAndView("product-list-admin");
////			assertEquals(modelAndView.getViewName(),mav.getViewName());
//	}
	/*@Test
	public void buyProduct()
	{
		Address address = new Address();
		modelAndView= productController.buyProduct(req);
		ModelAndView mav=new ModelAndView("address");
		when(req.getSession()).thenReturn(ses);
	
		
	}
	*/
	
	
	}