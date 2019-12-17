package it.unitn.sectest;

import static org.junit.Assert.assertEquals;

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
		String expected = "brand";
		String actual = productPage.checkAlert();
		productPage.checkAlert();
		waitForWebsite();
		assertEquals(expected, actual);
		
		
		
	}
	
	@After
	public void reset() {
		
		waitForWebsite();
		productPage.goToBrandPage();
		waitForWebsite();
		brandPage.removeBrand();
		waitForWebsite();
		productPage.logout();
		
	}

}
