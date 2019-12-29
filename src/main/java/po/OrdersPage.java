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
	
	@FindBy (xpath = "/html[1]/body[1]/div[1]/div[2]/div[2]/div[2]/table[1]/tbody[1]/tr[2]/td[7]/div[1]/ul[1]/li[1]/a[1]")
	WebElement editOrderModalBtn;
	
	@FindBy (xpath = "/html[1]/body[1]/div[1]/div[2]/div[2]/div[2]/table[1]/tbody[1]/tr[2]/td[7]/div[1]/ul[1]/li[3]/a[1]")
	WebElement printOrderBtn;
	
	
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
	
	
	public EditOrderPage goToEditOrder() {
		
		
		actionMenu.click();
		js.executeScript("arguments[0].scrollIntoView(true);", editOrderModalBtn);
		editOrderModalBtn.click();
		return new EditOrderPage(driver);
	}
	
public PrintOrderPage goToPrintOrderPage() {
		
		waitForWebsite();
		actionMenu.click();
		js.executeScript("arguments[0].scrollIntoView(true);", printOrderBtn);
		printOrderBtn.click();
		return new PrintOrderPage(driver);
	}
	
	

}
