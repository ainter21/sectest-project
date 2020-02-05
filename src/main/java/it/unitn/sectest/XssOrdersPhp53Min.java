package it.unitn.sectest;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Test;

import utils.BaseTest;

public class XssOrdersPhp53Min extends BaseTest{

	@Test
	public void test() {
		
		dashboardPage = defaultLogin();

		newOrderPage = dashboardPage.goToNewOrderPage();
		newOrderPage.addOrder("name", "1234", null, null, null, null, null, null, "\"/><script>alert(\"paid amount\")</script><input type=\"hidden\"", null);

		ordersPage = newOrderPage.goToOrdersPage();
		waitForWebsite();
		editOrderPage = ordersPage.goToEditOrder();

		assertTrue(editOrderPage.clickAlert());
	}
	


}
