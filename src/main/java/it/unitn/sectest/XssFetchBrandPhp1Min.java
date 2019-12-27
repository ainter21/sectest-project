package it.unitn.sectest;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.JavascriptExecutor;

import po.BrandPage;
import po.DashBoardPage;
import utils.BaseTest;

public class XssFetchBrandPhp1Min extends BaseTest{


	@Test
	public void test() {
		
		dashboardPage = defaultLogin();
		
		brandPage = dashboardPage.goToBrandPage();
		
		brandPage.addBrand("Malicious<script>alert(\"brand\")</script>", "Available");
		
		waitForWebsite();

		
		assertTrue(brandPage.isAlert());
		
	}
	
	@After
	public void reset() {
		
		brandPage.removeBrand();
		waitForWebsite();
		dashboardPage.logout();
		
	}

}
