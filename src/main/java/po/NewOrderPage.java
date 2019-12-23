package po;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NewOrderPage extends MenuComponent{

	
	@FindBy (id = "addRowBtn")
	WebElement addRowBtn;
	public NewOrderPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	
	public void addProductRow() {
		
		addRowBtn.click();
	}

}
