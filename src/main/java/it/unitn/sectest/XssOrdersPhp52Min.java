package it.unitn.sectest;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import utils.BaseTest;

public class XssOrdersPhp52Min extends BaseTest{

	@Test
	public void test() {

		
		dashboardPage = defaultLogin();
		
		newOrderPage = dashboardPage.goToNewOrderPage();
		
		newOrderPage.addOrder("name", "1234", null, null, null, null, null, null, null, null);
		
		ordersPage = newOrderPage.goToOrdersPage();
		waitForWebsite();
		editOrderPage = ordersPage.goToEditOrder();
		
		WebElement gstn = driver.findElement(By.id("gstn"));
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].setAttribute('value', arguments[1])", gstn, "\"/><script>alert(\"gstn\")</script><input type=\"hidden\"");
		
		editOrderPage.confirmEdit();
		
		driver.navigate().refresh();
		
		assertTrue(editOrderPage.clickAlert());
		
	}


}
