package it.unitn.sectest;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.JavascriptExecutor;

import po.BrandPage;
import po.DashBoardPage;
import utils.BaseTest;

public class XssFetchBrandPhp1Min extends BaseTest{

	DashBoardPage dashBoardPage;
	BrandPage brandPage;
	@Test
	public void test() {
		
		dashBoardPage = defaultLogin();
		
		brandPage = dashBoardPage.goToBrandPage();
		
		brandPage.addBrand("Malicious<script>alert(\"brand\")</script>", "Available");
		
		waitForWebsite();
		
		
		//String expected = "Malicious<script>alert(\"brand\")</script>";
		
		//((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", brandPage.getBrandName());
		waitForWebsite();
		
		assertTrue(brandPage.isAlert());
		
	}
	
	@After
	public void reset() {
		
		brandPage.removeBrand();
		waitForWebsite();
		dashBoardPage.logout();
		
	}

}
