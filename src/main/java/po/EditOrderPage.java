package po;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class EditOrderPage extends MenuComponent{

	
	@FindBy (id = "productName1")
	WebElement productName1;
	
	@FindBy (id = "editOrderBtn")
	WebElement editOrderBtn;
	
	@FindBy (id = "total1")
	WebElement total1;
	
	public EditOrderPage(WebDriver driver) {
		super(driver);

	}
	
	
	
	public void addProductToExistingOrder(String productName) {
		
		
		Select productSelect = new Select(productName1);
		
		productSelect.selectByVisibleText(productName);
		
		waitForWebsite();
		
		editOrderBtn.click();
	}
	
	public void changeTotal(String inputString) {
		
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("arguments[0].setAttribute('disabled', false)", total1);
		
		js.executeScript("arguments[0].setAttribute('value', arguments[1])", total1, inputString);
		
		editOrderBtn.click();
		
		
	}

	public void confirmEdit() {
		
		editOrderBtn.click();
	}
}
