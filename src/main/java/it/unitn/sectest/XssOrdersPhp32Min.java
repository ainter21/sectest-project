package it.unitn.sectest;

import static org.junit.Assert.*;

import org.junit.Test;

import utils.BaseTest;

public class XssOrdersPhp32Min extends BaseTest{

	@Test
	public void test() {
		
		
		dashboardPage = defaultLogin();
		
		newOrderPage = dashboardPage.goToNewOrderPage();
		
		newOrderPage.addOrder("name", "1234", null, null, null, null, null, null, null, null);
		
		productPage = newOrderPage.goToProductPage();
		
		waitForWebsite();
		waitForWebsite();
		waitForWebsite();
		waitForWebsite();
		productPage.editProduct("name", "10<script>alert(\"quantity\")</script>","999", "Apple", "Smartphones", "Available");
		
		waitForWebsite();
		
		ordersPage = productPage.goToOrdersPage();
		
		editOrderPage = ordersPage.goToEditOrder();
		
		assertTrue(editOrderPage.clickAlert());
		
	}

}
