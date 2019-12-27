package it.unitn.sectest;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Test;

import po.DashBoardPage;
import po.NewOrderPage;
import po.ProductPage;
import utils.BaseTest;

public class XssOrdersPhp11Min extends BaseTest{

	
	
	
	@Test
	public void test() {
		
		dashboardPage = defaultLogin();
		
		productPage = dashboardPage.goToProductPage();

		productPage.addProduct("Malicious<script>alert(\"name\")</script>",
				"1", 
				"1", 
				"Apple", 
				"PC", 
				"Available");
		
		newOrderPage = productPage.goToNewOrderPage();
		
		assertTrue(newOrderPage.clickAlert());
		assertTrue(newOrderPage.clickAlert());
		assertTrue(newOrderPage.clickAlert());
		
	}
	
	
	@After
	public void reset() {
		
		productPage = newOrderPage.goToProductPage();
		productPage.clickAlert();
		productPage.removeProduct();
		waitForWebsite();
		productPage.logout();
	}

}
