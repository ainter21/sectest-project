package it.unitn.sectest;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Test;

import po.CategoriesPage;
import po.DashBoardPage;
import po.ProductPage;
import utils.BaseTest;

public class XssProductPhp2Min extends BaseTest{

	
	DashBoardPage dashboardPage;
	CategoriesPage categoriesPage;
	ProductPage productPage;
	@Test
	public void test() {
		
		dashboardPage = defaultLogin();
		waitForWebsite();
		
		categoriesPage = dashboardPage.goToCategoriesPage();
		
		categoriesPage.addCategory("Malicious<script>alert(\"categories\")</script>", "Available");
		
		waitForWebsite();
		
		productPage = categoriesPage.goToProductPage();
		productPage.clickAlert();
		waitForWebsite();
		productPage.clickAlert();
		waitForWebsite();
		
		assertTrue(productPage.isAlert());
		
	}
	
	@After
	public void reset() {
	
		categoriesPage = productPage.goToCategoriesPage();
		waitForWebsite();
		categoriesPage.clickAlert();
		waitForWebsite();
		categoriesPage.removeCategory();
		waitForWebsite();
		categoriesPage.logout();
		
	}

}
