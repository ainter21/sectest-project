package it.unitn.sectest;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Test;

import po.CategoriesPage;
import po.DashBoardPage;
import po.ProductPage;
import utils.BaseTest;

public class XssProductPhp4Min extends BaseTest{


	@Test
	public void test() {
		
		dashboardPage = defaultLogin();
		waitForWebsite();
		
		categoriesPage = dashboardPage.goToCategoriesPage();
		
		categoriesPage.addCategory("Malicious<script>alert(\"categories\")</script>", "Available");
		
		waitForWebsite();
		
		productPage = categoriesPage.goToProductPage();
		

		
		assertTrue(productPage.clickAlert());
		productPage.clickAlert();
		
	}


}
