package po;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class IndexPage extends PageObject{

	@FindBy(xpath="//input[@id='username']")
	WebElement usernameInput;
	@FindBy(xpath = "//input[@id='password']")
	WebElement passwordInput;
	@FindBy(xpath = "//button[@class='btn btn-default']")
	WebElement signInButton;
	
	public IndexPage(WebDriver driver) {
		super(driver);
		
	}
	
	
	public DashBoardPage login(String username, String password) {
		
		
		clearFields();
		usernameInput.sendKeys(username);
		passwordInput.sendKeys(password);
		signInButton.click();
		return new DashBoardPage(driver);
	}
	
	
	public void clearFields() {
		usernameInput.clear();
		passwordInput.clear();
	}
	
	

}
