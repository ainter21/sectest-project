package it.unitn.sectest;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Test;

import utils.BaseTest;

public class XssOrdersPhp27Min extends BaseTest{

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
		
		waitForWebsite();
		newOrderPage = productPage.goToNewOrderPage();
		
		newOrderPage.clickAlert();
		newOrderPage.clickAlert();
		newOrderPage.clickAlert();
		
		newOrderPage.addOrder("name", 
				"1234", null, null, null, null, null);
		
		ordersPage = newOrderPage.goToOrdersPage();
		
		editOrderPage = ordersPage.goToEditOrder();
		
		assertTrue(editOrderPage.clickAlert());
	}
	
	@After
	public void reset() {
		
		ordersPage = editOrderPage.goToOrdersPage();
		
		ordersPage.removeOrder();
		waitForWebsite();
		productPage = ordersPage.goToProductPage();
		
		productPage.clickAlert();
		productPage.removeProduct();
		
		waitForWebsite();
		productPage.logout();
	}

}
