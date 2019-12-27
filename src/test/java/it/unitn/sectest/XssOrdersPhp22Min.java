package it.unitn.sectest;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Test;

import utils.BaseTest;

public class XssOrdersPhp22Min extends BaseTest{

	@Test
	public void test() {
		
		dashboardPage = defaultLogin();
		newOrderPage = dashboardPage.goToNewOrderPage();
		
		newOrderPage.addOrder("name",
				"\"/><script>alert(\"contact\")</script><input type=\"hidden\"");
		
		ordersPage = newOrderPage.goToOrdersPage();
		ordersPage.clickAlert();
		editOrderPage = ordersPage.goToEditOrder();
		
		assertTrue(editOrderPage.clickAlert());
	}

	@After
	public void reset() {
		
		ordersPage = editOrderPage.goToOrdersPage();
		ordersPage.clickAlert();
		ordersPage.removeOrder();
		waitForWebsite();
		ordersPage.logout();
	}
}
