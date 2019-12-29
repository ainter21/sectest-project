package po;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class UserSettingPage extends MenuComponent{

		
	@FindBy (id = "username")
	WebElement username;

	@FindBy (id = "changeUsernameBtn")
	WebElement changeUsernameBtn;

	@FindBy (id = "bio")
	WebElement bio;

	@FindBy (id = "changeBioBtn")
	WebElement changeBioBtn;

	
	
	public UserSettingPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public void changeUsername(String username) {

		this.username.clear();
		this.username.sendKeys(username);
		changeUsernameBtn.click();
	}

	public void changeBio(String bio) {

		this.bio.clear();
		this.bio.sendKeys(bio);
		changeBioBtn.click();
	}
}
