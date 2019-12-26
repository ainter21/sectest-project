package po;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OrdersPage extends MenuComponent{

	
	
	@FindBy (xpath = "//tr[@class='even']//button[@class='btn btn-default dropdown-toggle'][contains(text(),'Action')]")
	WebElement actionMenu;
	
	@FindBy (xpath = "//div[@class='btn-group open']//a[@id='removeOrderModalBtn']")
	WebElement removeMenuBtn;
	
	@FindBy (id = "removeOrderBtn")
	WebElement removeOrderBtn;
	
	
	public OrdersPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	
	public void removeOrder() {
		
		actionMenu.click();
		js.executeScript("arguments[0].scrollIntoView(true);", removeMenuBtn);
		removeMenuBtn.click();
		removeOrderBtn.click();
	}
	
	
	

}
