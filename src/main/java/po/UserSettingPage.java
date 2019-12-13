package po;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class UserSettingPage extends MenuComponent{

	
	@FindBy(how = How.ID, using = "username")
	WebElement changeUsernameInput;
	@FindBy(how = How.ID, using = "changeUsernameBtn")
	WebElement changeUsernameSubmit;
	
	public UserSettingPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public void changeUsername(String username) {
		changeUsernameInput.clear();
		changeUsernameInput.sendKeys(username);
		changeUsernameSubmit.click();
	}
}
