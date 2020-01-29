package it.unitn.sectest;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

import po.ManageUsersPage;
import utils.BaseTest;

public class XssFetchUserPhp1Min extends BaseTest{

	@Test
	public void test() {
		
		
		dashboardPage = defaultLogin();
		
		ManageUsersPage manageUsersPage = dashboardPage.goToManageUsersPage();
		
		waitForWebsite();
		manageUsersPage.addUser("user<script>alert(\"user\")</script>", "user", "user@user.com");
		
		assertTrue(manageUsersPage.isAlert());
		
		
		
	}
	
	@After
	public void reset() {
		
		waitForWebsite();
		driver.findElement(By.xpath("//tr[3]//td[2]//div[1]//button[1]")).click();
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath("//div[@class='btn-group open']//a[@id='removeUserModalBtn']")));
		driver.findElement(By.xpath("//div[@class='btn-group open']//a[@id='removeUserModalBtn']")).click();
		
		driver.findElement(By.id("removeProductBtn")).click();
		
	}

}
