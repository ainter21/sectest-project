package it.unitn.sectest;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;

import utils.BaseTest;

public class XssGetOrderReportPhp1Min extends BaseTest{



	


	String parentWindowHandle = driver.getWindowHandle();
	
	@Test
	public void test() {

		dashboardPage = defaultLogin();
		
		newOrderPage = dashboardPage.goToNewOrderPage();
		
		newOrderPage.addOrder("<h1 id=\"malicious_name\">name</h1>", 
				"<h1 id=\"malicious_contact\">1234</h1>", 
				null, null, null, null, "<h1 id=\"malicious_total\">1234</h1>", null, null, null);
		
		reportPage = newOrderPage.goToReportPage();
		
		reportPage.getReport();
		waitForWebsite();
		waitForWebsite();
		
		
		for(String handle: driver.getWindowHandles()) {

			if(!handle.equals(parentWindowHandle)) {

				driver.switchTo().window(handle);
			}
		}
		
		assertTrue(driver.findElements( By.id("malicious_name") ).size() != 0);
		assertTrue(driver.findElements( By.id("malicious_contact") ).size() != 0);
		assertTrue(driver.findElements( By.id("malicious_total") ).size() != 0);
		
	}
	
	@After 
	public void reset() {

		driver.close();
		driver.switchTo().window(parentWindowHandle);
		ordersPage = reportPage.goToOrdersPage();
		ordersPage.removeOrder();
	}

}
