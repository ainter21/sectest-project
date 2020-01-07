package it.unitn.sectest;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.BaseTest;

public class XssPrintOrderPhp1Min extends BaseTest{

	
	String parentWindowHandle = driver.getWindowHandle();
	@Test
	public void test() {

		dashboardPage = defaultLogin();

		newOrderPage = dashboardPage.goToNewOrderPage();
		newOrderPage.addOrder("name", 
				"1234", 
				null, 
				null, 
				null, 
				null, 
				null, 
				null, 
				null, 
				null);

		ordersPage = newOrderPage.goToOrdersPage();
		editOrderPage = ordersPage.goToEditOrder();

		JavascriptExecutor js = (JavascriptExecutor)driver;

		WebElement name = driver.findElement(By.id("clientName"));
		js.executeScript("arguments[0].setAttribute('value', arguments[1])", name, "<h1 id=\"malicious_name\">name</h1>");

		WebElement contact = driver.findElement(By.id("clientContact"));
		js.executeScript("arguments[0].setAttribute('value', arguments[1])", contact, "<h1 id=\"malicious_contact\">1234</h1>");

		WebElement totalValue1 = driver.findElement(By.id("totalValue1"));
		js.executeScript("arguments[0].setAttribute('value', arguments[1])", totalValue1, "\"/><h1 id=\"malicious_product\">1234</h1>");

		WebElement subTotal = driver.findElement(By.id("subTotalValue"));
		js.executeScript("arguments[0].setAttribute('value', arguments[1])", subTotal, "\"/><h1 id=\"malicious_subtotal\">988</h1>");

		WebElement gstn = driver.findElement(By.id("gstn"));
		js.executeScript("arguments[0].setAttribute('value', arguments[1])", gstn, "\"/><h1 id=\"malicious_gstn\">333</h1>");

		editOrderPage.confirmEdit();

		ordersPage = editOrderPage.goToOrdersPage();




		printOrderPage = ordersPage.goToPrintOrderPage();

		

		for(String handle: driver.getWindowHandles()) {

			if(!handle.equals(parentWindowHandle)) {

				driver = driver.switchTo().window(handle);
			}
		}


		assertTrue(driver.findElements( By.id("malicious_name") ).size() != 0);
		assertTrue(driver.findElements( By.id("malicious_contact") ).size() != 0);
		assertTrue(driver.findElements( By.id("malicious_subtotal") ).size() != 0);
		assertTrue(driver.findElements( By.id("malicious_product") ).size() != 0);
		assertTrue(driver.findElements( By.id("malicious_gstn") ).size() != 0);

		

	}

	@After 
	public void reset() {

		driver.close();
		driver.switchTo().window(parentWindowHandle);
		ordersPage.removeOrder();
	}

}
