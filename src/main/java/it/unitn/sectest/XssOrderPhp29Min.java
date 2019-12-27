package it.unitn.sectest;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Test;

import utils.BaseTest;

public class XssOrderPhp29Min extends BaseTest{

	@Test
	public void test() {
		

		dashboardPage = defaultLogin();
		
		productPage = dashboardPage.goToProductPage();
		
		productPage.addProduct("name", "10", "\"/><script>alert(\"rate\")</script><input type=\"hidden\"", "Apple", "PC", "Available");
		
		newOrderPage = productPage.goToNewOrderPage();
		
		newOrderPage.addOrder("name", "1234");
		
		ordersPage = newOrderPage.goToOrdersPage();
		
		editOrderPage = ordersPage.goToEditOrder();
		
		editOrderPage.addProductToExistingOrder("name");
		
		ordersPage = editOrderPage.goToOrdersPage();
		
		editOrderPage = ordersPage.goToEditOrder();
		
		editOrderPage.clickAlert();
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
