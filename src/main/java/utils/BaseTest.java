package utils;

import java.net.URISyntaxException;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.concurrent.TimeUnit;

import org.jsoup.safety.Cleaner;
import org.junit.AfterClass;
import org.junit.Before;
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
		cleandb();
	}

	/*
	 * Terminate the driver after all the tests
	 * */
	@AfterClass
	public static void tearDown() {
		driver.quit();
		driver = null;
		cleandb();
		
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
	@Before
	public void initdb() {
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection(  
					"jdbc:mysql://localhost:3306/store","root","");  
					//here sonoo is database name, root is username and password  
					Statement stmt=con.createStatement();
					int rs = stmt.executeUpdate("INSERT INTO brands (brand_id, brand_name, brand_active, brand_status) VALUES (1,'Apple', 1, 1)");
					rs = stmt.executeUpdate("INSERT INTO categories (categories_id, categories_name, categories_active, categories_status) VALUES (1,'Smartphones', 1, 1)");
					rs = stmt.executeUpdate("INSERT INTO categories (categories_id,categories_name, categories_active, categories_status) VALUES (2,'PC', 1, 1)");
					rs = stmt.executeUpdate("INSERT INTO categories (categories_id,categories_name, categories_active, categories_status) VALUES (3,'Tablet', 1, 1)");
					
					String absPath = "../assets/images/photo_default.png";
//					try {
//						absPath = Paths.get(getClass().getClassLoader().getResource("macbookpro.png").toURI()).toFile().getAbsolutePath();
//						System.out.println(absPath);
//					} catch (URISyntaxException e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					}
					
					rs = stmt.executeUpdate("INSERT INTO product "
							+ "(product_id, product_name, product_image, brand_id, categories_id, quantity, rate, active, status) "
							+ "VALUES (1,'iPhone','" + absPath +"', 1, 1, '100', '999',1,1)");
					rs = stmt.executeUpdate("INSERT INTO product "
							+ "(product_id, product_name, product_image, brand_id, categories_id, quantity, rate, active, status) "
							+ "VALUES (2,'MacBook Pro','" + absPath +"', 1, 2, '100', '999',1,1)");
					
					rs = stmt.executeUpdate("INSERT INTO orders "
							+ "(order_id, order_date, client_name, client_contact, sub_total, vat, total_amount, discount, grand_total, paid, due, payment_type, payment_status, payment_place, gstn, order_status, user_id) "
							+ "VALUES (1, '2019-12-17', 'john', '1234', '999.00', '179.82', '1178.82','0','1178.82','500', '678.82', 1, 1, 1, '179.82', 1,1)");
					
					rs = stmt.executeUpdate("INSERT INTO order_item "
							+ "(order_item_id, order_id, product_id, quantity, rate, total, order_item_status) "
							+ "VALUES (1, 1, 1, '1', '999','999.00', 1)");
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void cleandb() {
		
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection(  
					"jdbc:mysql://localhost:3306/store","root","");  
					//here sonoo is database name, root is username and password  
					Statement stmt=con.createStatement();
					int rs = stmt.executeUpdate("TRUNCATE TABLE order_item");
					rs = stmt.executeUpdate("TRUNCATE TABLE orders");
					rs = stmt.executeUpdate("TRUNCATE TABLE product");
					rs = stmt.executeUpdate("TRUNCATE TABLE categories");
					rs = stmt.executeUpdate("TRUNCATE TABLE brands");
					
					
					
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
}