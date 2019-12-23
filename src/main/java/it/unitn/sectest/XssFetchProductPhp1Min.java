package it.unitn.sectest;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Test;

import po.BrandPage;
import po.CategoriesPage;
import po.DashBoardPage;
import po.ProductPage;
import utils.BaseTest;

public class XssFetchProductPhp1Min extends BaseTest{

	
	DashBoardPage dashboardPage;
	BrandPage brandPage;
	CategoriesPage categoriesPage;
	ProductPage productPage;
	
	@Test
	public void test() {
		
		dashboardPage = defaultLogin();
		brandPage = dashboardPage.goToBrandPage();
		brandPage.addBrand("Malicious<script>alert(\"brand\");</script>", "Available");
		
		categoriesPage = brandPage.goToCategoriesPage();
		categoriesPage.addCategory("Malicious<script>alert(\"categories\");</script>", "Available");
		
		productPage = categoriesPage.goToProductPage();
//		productPage = dashboardPage.goToProductPage();
		for(int i = 0; i<4;++i) {
			waitForWebsite();
			productPage.clickAlert();
		}
		waitForWebsite();
		productPage.addProduct("Malicious<script>alert(\"name\")</script>", 
				"10<script>alert(\"quantitiy\")</script>", 
				"10<script>alert(\"rate\")</script>", 
				"Malicious<br><script>alert(\"brand\");</script>", 
				"Smartphones", 
				"Available");
		
		assertTrue(productPage.isAlert());		
		
		
		
	}
	
	@After
	public void reset() {
	
		waitForWebsite();
		productPage.removeProduct();
		waitForWebsite();
		categoriesPage = productPage.goToCategoriesPage();
		waitForWebsite();
		categoriesPage.clickAlert();
		waitForWebsite();
		categoriesPage.removeCategory();
		waitForWebsite();
		
		brandPage = categoriesPage.goToBrandPage();
		waitForWebsite();
		brandPage.clickAlert();
		waitForWebsite();
		brandPage.removeBrand();
		waitForWebsite();
		brandPage.logout();
		
	}

}
