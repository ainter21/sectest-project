package it.unitn.sectest;

import static org.junit.Assert.*;

import java.util.Set;

import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import po.DashBoardPage;
import po.NewOrderPage;
import po.OrdersPage;
import po.PDFReportPage;
import po.ReportPage;
import utils.BaseTest;

public class XssGetOrderReportPhp1Min extends BaseTest{



	String parentWindowHandle;


	@Test
	public void test() {

		parentWindowHandle = driver.getWindowHandle();
		dashboardPage = defaultLogin();

		newOrderPage = dashboardPage.goToNewOrderPage();

		newOrderPage.addOrder("Malicious<script>alert(\"name\")</script>", "Malicious<script>alert(\"number\")</script>");

		reportPage = newOrderPage.goToReportPage();
		
		reportPage.getReport();
		
		WebDriverWait webDriverWait = new WebDriverWait(driver, 10);
		webDriverWait.until(ExpectedConditions.numberOfWindowsToBe(2));

		
		System.out.println(parentWindowHandle);

		Set<String> allWindowHandles = driver.getWindowHandles();

		PDFReportPage pdf;
		
		for(String handle : allWindowHandles)
		{
			if(!handle.equals(parentWindowHandle)) {

				driver.switchTo().window(handle); //Switch to the desired window first and then execute commands using driver

				

				pdf = new PDFReportPage(driver);

				assertTrue(pdf.clickAlert());
				assertTrue(pdf.clickAlert());
				
				driver.close();
			}
			
		}

	}
	
	
	@After
	public void reset() {
		
		driver.switchTo().window(parentWindowHandle);
		ordersPage = reportPage.goToOrdersPage();
		ordersPage.clickAlert();
		ordersPage.clickAlert();
		ordersPage.removeOrder();
		ordersPage.logout();
	}

}
