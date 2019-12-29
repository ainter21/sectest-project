package utils;

import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import po.BrandPage;
import po.CategoriesPage;
import po.DashBoardPage;
import po.EditOrderPage;
import po.IndexPage;
import po.NewOrderPage;
import po.OrdersPage;
import po.PrintOrderPage;
import po.ProductPage;
import po.ReportPage;
import po.UserSettingPage;

public class BaseTest {

	protected static WebDriver driver;
	protected static String URL = "http://localhost/inventory-management-system/";
	
	protected DashBoardPage dashboardPage;
	protected ProductPage productPage;
	protected NewOrderPage newOrderPage;
	protected BrandPage brandPage;
	protected CategoriesPage categoriesPage;
	protected IndexPage indexPage;
	protected OrdersPage ordersPage;
	protected ReportPage reportPage;
	protected UserSettingPage userSettingPage;
	protected EditOrderPage editOrderPage;
	protected PrintOrderPage printOrderPage;

	public void waitForWebsite() {
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	public DashBoardPage defaultLogin() {
		
		DashBoardPage dashBoardPage = new IndexPage(driver).login("admin", "admin");
		waitForWebsite();
		return dashBoardPage;
	}
	
	/*
	 * Initialize the Firefox driver and connect to the main page
	 * 
	 * */
	@BeforeClass
	public static void setUp() throws InterruptedException {
		driver = getDriver();
		driver.get(URL);
	}

	/*
	 * Terminate the driver after all the tests
	 * */
	@AfterClass
	public static void tearDown() {
		driver.quit();
		driver = null;
	}

	public static WebDriver getDriver() {
		if (driver == null) {
			// Uncomment to use Opera (suggested alternative)
			// WebDriverManager.operadriver().setup();
			// driver = new OperaDriver();
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
			driver.get(URL);
		}
		return driver;
	}

	
}