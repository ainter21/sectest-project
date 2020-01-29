package it.unitn.sectest;

import static org.junit.Assert.*;

import org.junit.Test;

import po.DashBoardPage;
import utils.BaseTest;

public class XssIndexPhp2Min extends BaseTest{

	@Test
	public void test() {
		
		
		dashboardPage = new DashBoardPage(driver);
		driver.get("http://localhost/inventory-management-system/index.php/%22%3E%3Cscript%3Ealert('login')%3C/script%3E");
		assertTrue(dashboardPage.clickAlert());
	}

}
