package it.unitn.sectest;

import static org.junit.Assert.*;

import org.junit.Test;

import po.EditOrderPage;
import utils.BaseTest;

public class XssOrdersPhp6Min extends BaseTest{

	@Test
	public void test() {
		

		String url = "http://localhost/inventory-management-system/orders.php?o=editOrd&i=8<script>alert(\"id\")</script>";
		
		dashboardPage = defaultLogin();
		
		driver.get(url);
		
		editOrderPage = new EditOrderPage(driver);
		
		assertTrue(editOrderPage.clickAlert());
	}

}
