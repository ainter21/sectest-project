package utils;

import static org.junit.Assert.*;

import java.io.File;
import java.net.URISyntaxException;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AddDb {

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
					
					String absPath = "";
					String path = "src/main/resources/macbookpro.png";
					File file = new File(path);
					absPath = file.getAbsolutePath();
					
					
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
	
	@Test
	public void test() {
		
		 
		cleandb();
		initdb();
	}

}
