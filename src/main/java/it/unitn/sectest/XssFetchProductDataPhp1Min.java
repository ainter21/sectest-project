package it.unitn.sectest;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import po.DashBoardPage;
import po.NewOrderPage;
import po.ProductPage;
import utils.BaseTest;

public class XssFetchProductDataPhp1Min extends BaseTest{

	DashBoardPage dashboardPage;
	ProductPage productPage;
	NewOrderPage newOrdersPage;
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

		newOrdersPage = productPage.goToNewOrderPage();

		waitForWebsite();
		newOrdersPage.clickAlert();
		waitForWebsite();
		newOrdersPage.clickAlert();
		waitForWebsite();
		newOrdersPage.clickAlert();
		
		newOrdersPage.addProductRow();
		waitForWebsite();
		newOrdersPage.clickAlert();
		assertTrue(newOrdersPage.isAlert());



	}

	@After
	public void reset() {

		waitForWebsite();
		productPage = newOrdersPage.goToProductPage();
		waitForWebsite();
		productPage.clickAlert();
		waitForWebsite();
		productPage.removeProduct();

		waitForWebsite();
		productPage.logout();

	}



}
