package po;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MenuComponent extends PageObject{


	@FindBy(xpath = "//li[@id='navSetting']//a[@class='dropdown-toggle']")
	WebElement userMenu;

	@FindBy(xpath = "//li[@id='topNavSetting']//a[1]")
	WebElement userSettingMenu;

	@FindBy(xpath = "//li[@id='topNavLogout']//a[1]")
	WebElement logoutMenu;
	
	@FindBy (xpath = "//a[contains(text(),'Brand')]")
	WebElement brandMenu;
	
	public MenuComponent(WebDriver driver) {
		super(driver);

	}


	public UserSettingPage goToUserSettings() {

		userMenu.click();
		userSettingMenu.click();
		return new UserSettingPage(driver);
	}
	
	public IndexPage logout() {
		
		userMenu.click();
		logoutMenu.click();
		return new IndexPage(driver);
		
	}
	
	public BrandPage goToBrandPage() {
		
		brandMenu.click();
		return new BrandPage(driver);
		
	}

}
