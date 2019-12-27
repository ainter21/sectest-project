package it.unitn.sectest;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Test;

import po.DashBoardPage;
import po.IndexPage;
import po.UserSettingPage;
import utils.BaseTest;

public class XssDashboardPhp10Min extends BaseTest{


	@Test
	public void test() {

		//login
		String username="admin";
		String password = "admin";
		indexPage = new IndexPage(driver);
		dashboardPage = indexPage.login(username, password);
		waitForWebsite();
		//go to settings
		userSettingPage = dashboardPage.goToUserSettings();
		waitForWebsite();
		//change username
		String xssUsername = "<h1>admin</h1>";
		userSettingPage.changeUsername(xssUsername);
		waitForWebsite();
		//logout
		indexPage = userSettingPage.logout();
		waitForWebsite();
		//login again
		dashboardPage = indexPage.login(xssUsername, password);

		//assert that username has HTML inside

		String innerHTML = dashboardPage.getUserOrder().getAttribute("innerHTML");

		assertEquals("<h1>admin</h1>", innerHTML);





	}

	@After
	public void reset() {
		//change back username
		userSettingPage = dashboardPage.goToUserSettings();
		waitForWebsite();
		userSettingPage.changeUsername("admin");
		waitForWebsite();
	}






}
