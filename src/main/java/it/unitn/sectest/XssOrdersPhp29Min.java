package it.unitn.sectest;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Test;

import utils.BaseTest;

public class XssOrdersPhp29Min extends BaseTest{

	@Test
	public void test() {
		

		dashboardPage = defaultLogin();
		
		productPage = dashboardPage.goToProductPage();
		
		productPage.addProduct("name", "10", "\"/><script>alert(\"rate\")</script><input type=\"hidden\"", "Apple", "PC", "Available");
		
		newOrderPage = productPage.goToNewOrderPage();
		
		newOrderPage.addOrder("name", "1234", null, null, null, null, null, null, null, null);
		
		ordersPage = newOrderPage.goToOrdersPage();
		
		editOrderPage = ordersPage.goToEditOrder();
		
		editOrderPage.addProductToExistingOrder("name");
		
		ordersPage = editOrderPage.goToOrdersPage();
		waitForWebsite();
		editOrderPage = ordersPage.goToEditOrder();
		
		editOrderPage.clickAlert();
		assertTrue(editOrderPage.clickAlert());
		
		
		
	}


}
