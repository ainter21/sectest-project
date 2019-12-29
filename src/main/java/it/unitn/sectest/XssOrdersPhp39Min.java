package it.unitn.sectest;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Test;

import utils.BaseTest;

public class XssOrdersPhp39Min extends BaseTest{

	@Test
	public void test() {
		

		dashboardPage = defaultLogin();
		
		newOrderPage = dashboardPage.goToNewOrderPage();
		newOrderPage.addOrder("name", "1234", "11\"/><script>alert(\"hello\")</script><input type=\"hidden\"", null, null, null, null, null, null, null);
		
		ordersPage = newOrderPage.goToOrdersPage();
		
		editOrderPage = ordersPage.goToEditOrder();
		
		editOrderPage.clickAlert();
		assertTrue(editOrderPage.clickAlert());
		
		
		
		
	}
	
	
	@After 
	public void reset() {
		
		ordersPage = editOrderPage.goToOrdersPage();
		ordersPage.removeOrder();
	}

}
