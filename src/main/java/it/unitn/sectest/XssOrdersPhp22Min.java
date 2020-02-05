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
				"\"/><script>alert(\"contact\")</script><input type=\"hidden\"", null, null, null, null, null, null, null, null);
		
		ordersPage = newOrderPage.goToOrdersPage();
		ordersPage.clickAlert();
		waitForWebsite();
		editOrderPage = ordersPage.goToEditOrder();
		
		assertTrue(editOrderPage.clickAlert());
	}

}
