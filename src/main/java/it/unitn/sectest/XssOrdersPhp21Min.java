package it.unitn.sectest;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Test;
import utils.BaseTest;

public class XssOrdersPhp21Min extends BaseTest{

	

	@Test
	public void test() {

		dashboardPage = defaultLogin();
		newOrderPage = dashboardPage.goToNewOrderPage();
		
		newOrderPage.addOrder("\"/><script>alert(\"hello\")</script><input type=\"hidden\"",
				"1234");
		
		ordersPage = newOrderPage.goToOrdersPage();
		ordersPage.clickAlert();
		editOrder = ordersPage.goToEditOrder();
		
		assertTrue(editOrder.clickAlert());
		
	}
	
	@After
	public void reset() {
		
		ordersPage = editOrder.goToOrdersPage();
		ordersPage.clickAlert();
		ordersPage.removeOrder();
		waitForWebsite();
		ordersPage.logout();
	}

}
