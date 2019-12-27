package it.unitn.sectest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Test;

import po.CategoriesPage;
import po.DashBoardPage;
import utils.BaseTest;

public class XssFetchCategoriesPhp1Min extends BaseTest{


	
	@Test
	public void test() {
		
		dashboardPage = defaultLogin();
		waitForWebsite();
		
		categoriesPage = dashboardPage.goToCategoriesPage();
		
		String expected = "Malicious<script>alert(\"categories\")</script>)";
		categoriesPage.addCategory(expected, "Available");
		waitForWebsite();

		assertTrue(categoriesPage.isAlert());
		
		
		
	}
	
	@After
	public void reset() {
		
		categoriesPage.removeCategory();
		waitForWebsite();
		dashboardPage.logout();
	}
}
