package po;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class ProductPage extends MenuComponent{

	
	
	public ProductPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public String checkAlert() {
		
		String alertMessage = "";
		try {
			
			alertMessage = driver.switchTo().alert().getText();
			driver.switchTo().alert().accept();
			
		}catch(Exception e) {
			System.out.println("no alerts");
			
		}
		return alertMessage;
		
	}
}
