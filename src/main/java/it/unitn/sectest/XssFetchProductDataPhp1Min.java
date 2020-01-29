package it.unitn.sectest;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Test;

import utils.BaseTest;

public class XssFetchProductDataPhp1Min extends BaseTest{


	@Test
	public void test() {


		dashboardPage = defaultLogin();

		productPage = dashboardPage.goToProductPage();

		waitForWebsite();
		productPage.addProduct("Malicious<script>alert(\"name\")</script>", 
				"10", 
				"100", 
				"Apple", 
				"PC",
				"Available");

		newOrderPage = productPage.goToNewOrderPage();


		newOrderPage.clickAlert();

		newOrderPage.clickAlert();

		newOrderPage.clickAlert();
		
		newOrderPage.addProductRow();		
//		assertTrue(newOrderPage.clickAlert());
		assertTrue(newOrderPage.clickAlert());



	}

	@After
	public void reset() {

		waitForWebsite();
		productPage = newOrderPage.goToProductPage();
		waitForWebsite();
		productPage.clickAlert();
		waitForWebsite();
		productPage.removeProduct();

		waitForWebsite();
		productPage.logout();

	}



}
