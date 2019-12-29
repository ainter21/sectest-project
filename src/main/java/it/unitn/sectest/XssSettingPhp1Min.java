package it.unitn.sectest;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Test;
import utils.BaseTest;

public class XssSettingPhp1Min extends BaseTest{

	@Test
	public void test() {
		
		dashboardPage = defaultLogin();

		userSettingPage = dashboardPage.goToSettingPage();
		
		userSettingPage.changeUsername("admin\"/><script>alert(\"hello\")</script><input type=\"hidden\"");
		
		
		driver.navigate().refresh();
		

		assertTrue(userSettingPage.clickAlert());
	}
	
	@After
	public void reset() {
		userSettingPage.changeUsername("admin");
	}

}
