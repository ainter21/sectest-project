package po;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class EditOrderPage extends MenuComponent{

	
	@FindBy (id = "productName1")
	WebElement productName1;
	
	@FindBy (id = "editOrderBtn")
	WebElement editOrderBtn;
	
	public EditOrderPage(WebDriver driver) {
		super(driver);

	}
	
	
	
	public void addProductToExistingOrder(String productName) {
		
		
		Select productSelect = new Select(productName1);
		
		productSelect.selectByVisibleText(productName);
		
		waitForWebsite();
		
		editOrderBtn.click();
	}

}
