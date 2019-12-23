package po;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MenuComponent extends PageObject{

	
	WebDriverWait wait;
	JavascriptExecutor js = (JavascriptExecutor)driver;
	
	@FindBy(xpath = "//li[@id='navSetting']//a[@class='dropdown-toggle']")
	WebElement userMenu;

	@FindBy(xpath = "//li[@id='topNavSetting']//a[1]")
	WebElement userSettingMenu;

	@FindBy(xpath = "//li[@id='topNavLogout']//a[1]")
	WebElement logoutMenu;
	
	@FindBy (xpath = "//a[contains(text(),'Brand')]")
	WebElement brandMenu;
	@FindBy(xpath = "//li[@id='navCategories']//a[1]")
	WebElement categoriesMenu;
	@FindBy(xpath = "/html[1]/body[1]/nav[1]/div[1]/div[2]/ul[1]/li[4]/a[1]")
	WebElement productMenu;
	
	public MenuComponent(WebDriver driver) {
		super(driver);
		wait = new WebDriverWait(driver, 10);

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

	public CategoriesPage goToCategoriesPage() {
		
		js.executeScript("arguments[0].click();", categoriesMenu);
		return new CategoriesPage(driver);
		
	}
	
	public ProductPage goToProductPage() {
		
		js.executeScript("arguments[0].click();", productMenu);

		return new ProductPage(driver);
	}
}
