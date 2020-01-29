package it.unitn.sectest;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Test;

import po.BrandPage;
import po.DashBoardPage;
import po.ProductPage;
import utils.BaseTest;

public class XssProductPhp3Min extends BaseTest{


	@Test
	public void test() {

		dashboardPage = defaultLogin();
		waitForWebsite();
		brandPage = dashboardPage.goToBrandPage();
		brandPage.addBrand("Malicious<script>alert(\"brand\")</script>", "Available");
		waitForWebsite();
		productPage = brandPage.goToProductPage();
		
		
		assertTrue(productPage.clickAlert());
		productPage.clickAlert();
		
		
	}


}
