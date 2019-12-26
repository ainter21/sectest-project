package it.unitn.sectest;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Test;

import po.DashBoardPage;
import po.NewOrderPage;
import po.OrdersPage;
import utils.BaseTest;

public class XssFetchOrderPhp1Min extends BaseTest{

	
	DashBoardPage dashboardPage;
	NewOrderPage newOrderPage;
	OrdersPage ordersPage;
	
	@Test
	public void test() {
	
		
		dashboardPage = defaultLogin();
		
		newOrderPage = dashboardPage.goToNewOrderPage();
		waitForWebsite();
		newOrderPage.addOrder("Malicious<script>alert(\"name\")</script>","Malicious<script>alert(\"number\")</script>");
		waitForWebsite();
		ordersPage = newOrderPage.gotToOrdersPage();
		
		//waitForWebsite();
		;
		//waitForWebsite();
		;
		
		assertTrue(ordersPage.clickAlert());
		assertTrue(ordersPage.clickAlert());
	}
	
	
	@After public void reset() {
		
		waitForWebsite();
		ordersPage.removeOrder();
		waitForWebsite();
		ordersPage.logout();
	}

}
