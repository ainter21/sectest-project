package it.unitn.sectest;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Test;

import utils.BaseTest;

public class XssOrdersPhp45Min extends BaseTest{

	@Test
	public void test() {
		
		dashboardPage = defaultLogin();

		newOrderPage = dashboardPage.goToNewOrderPage();
		newOrderPage.addOrder("name", "1234", null, null, null, "\"/><script>alert(\"discount\")</script><input type=\"hidden\"", null, null, null, null);

		ordersPage = newOrderPage.goToOrdersPage();

		editOrderPage = ordersPage.goToEditOrder();

//		editOrderPage.clickAlert();
		assertTrue(editOrderPage.clickAlert());
	}


}
