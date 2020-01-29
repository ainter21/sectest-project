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

	

	
	@Test
	public void test() {
		
		dashboardPage = defaultLogin();
			
		productPage = dashboardPage.goToProductPage();
//		productPage = dashboardPage.goToProductPage();
		waitForWebsite();
		productPage.addProduct("Malicious<script>alert(\"name\")</script>", 
				"10<script>alert(\"quantitiy\")</script>", 
				"10<script>alert(\"rate\")</script>", 
				"Apple", 
				"Smartphones", 
				"Available");
		
		assertTrue(productPage.isAlert());		
		
		
		
	}
	
	

}
