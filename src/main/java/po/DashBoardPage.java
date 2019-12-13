package po;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DashBoardPage extends MenuComponent{

	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[2]/div[5]/div[1]/div[2]/table[1]/tbody[1]/tr[1]/td[1]")
	WebElement userOrder;
	
	public WebElement getUserOrder() {
		return userOrder;
	}

	public void setUserOrder(WebElement userOrder) {
		this.userOrder = userOrder;
	}

	public DashBoardPage(WebDriver driver) {
		super(driver);
	}
	
	
	

	

}
