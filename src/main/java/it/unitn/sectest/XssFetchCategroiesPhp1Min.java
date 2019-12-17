package it.unitn.sectest;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Test;

import po.CategoriesPage;
import po.DashBoardPage;
import utils.BaseTest;

public class XssFetchCategroiesPhp1Min extends BaseTest{

	
	DashBoardPage dashboardPage;
	CategoriesPage categoriesPage;
	
	@Test
	public void test() {
		
		dashboardPage = defaultLogin();
		waitForWebsite();
		
		categoriesPage = dashboardPage.goToCategoriesPage();
		
		String expected = "<h1>Malicious</h1>";
		categoriesPage.addCategory(expected, "Available");
		waitForWebsite();
		
		
		String actual = categoriesPage.getCategoriesName().getAttribute("innerHTML");
		assertEquals(expected, actual);
		
		
		
	}
	
	@After
	public void reset() {
		
		categoriesPage.removeCategory();
		waitForWebsite();
		dashboardPage.logout();
	}
}
