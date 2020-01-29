package po;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ManageUsersPage extends MenuComponent{

	
	
	@FindBy (id = "addUserModalBtn")
	WebElement addUserModalBtn;
	
	
	public ManageUsersPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	
	public void addUser(String username, String password, String email) {
		
		waitForWebsite();
		addUserModalBtn.click();
		waitForWebsite();
		
		driver.findElement(By.id("userName")).sendKeys(username);
		driver.findElement(By.id("upassword")).sendKeys(password);
		driver.findElement(By.id("uemail")).sendKeys(email);
		
		driver.findElement(By.id("createUserBtn")).click();
		
		clickAlert();
		driver.findElement(By.xpath("//div[@class='modal-footer']//button[1]")).click();
	}

}
