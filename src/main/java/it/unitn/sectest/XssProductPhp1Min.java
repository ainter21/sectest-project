package it.unitn.sectest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Test;

import po.BrandPage;
import po.DashBoardPage;
import po.ProductPage;
import utils.BaseTest;

public class XssProductPhp1Min extends BaseTest{

	DashBoardPage dashboardPage;
	BrandPage brandPage;
	ProductPage productPage;
	
	@Test
	public void test() {
		
		dashboardPage = defaultLogin();
		waitForWebsite();
		brandPage = dashboardPage.goToBrandPage();
		brandPage.addBrand("Malicious<script>alert(\"brand\")</script>", "Available");
		waitForWebsite();
		productPage = brandPage.goToProductPage();
		productPage.clickAlert();
		waitForWebsite();
		productPage.clickAlert();
		assertTrue(productPage.isAlert());
		
		
		
	}
	
	@After
	public void reset() {
		
		waitForWebsite();
		brandPage = productPage.goToBrandPage();
		brandPage.clickAlert();
		waitForWebsite();
		brandPage.removeBrand();
		waitForWebsite();
		productPage.logout();
		
	}

}
