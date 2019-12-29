package it.unitn.sectest;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Test;

import utils.BaseTest;

public class XssSettingPhp3Min extends BaseTest{

	@Test
	public void test() {
		
		dashboardPage = defaultLogin();

		userSettingPage = dashboardPage.goToSettingPage();
		
		userSettingPage.changeBio("bio\"/><script>alert(\"hello\")</script><input type=\"hidden\"");
		
		
		driver.navigate().refresh();
		

		assertTrue(userSettingPage.clickAlert());
	}
	
	@After
	public void reset() {
		userSettingPage.changeBio("I am your admin");
	}

}
