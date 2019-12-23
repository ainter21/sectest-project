package po;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class CategoriesPage extends MenuComponent{

	
	@FindBy(how = How.ID, using = "addCategoriesModalBtn")
	WebElement addCategoriesModalBtn;
	@FindBy(id = "categoriesName")
	WebElement categoriesNameInput;
	@FindBy(id = "categoriesStatus")
	WebElement categoriesStatusSelect;
	@FindBy(id = "createCategoriesBtn")
	WebElement createCategoriesBtn;
	@FindBy(xpath = "//div[@class='modal-footer']//button[1]")
	WebElement closeAddCategoriesModal;
	@FindBy(xpath = "//tr[4]//td[3]//div[1]//button[1]")
	WebElement actionButton;
	@FindBy(xpath = "//div[@class='btn-group open']//a[@id='removeCategoriesModalBtn']")
	WebElement removeButton;
	@FindBy(id = "removeCategoriesBtn")
	WebElement removeCategoriesBtn;
	
	@FindBy(xpath = "//tr[4]//td[1]")
	WebElement categoriesName;
	
	
	public WebElement getCategoriesName() {
		return categoriesName;
	}


	public CategoriesPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	
	public void addCategory(String name, String availability) {
		
		wait.until(ExpectedConditions.elementToBeClickable(By.id("addCategoriesModalBtn"))).click();
		categoriesNameInput.sendKeys(name);
		Select select = new Select(categoriesStatusSelect);
		select.selectByVisibleText(availability);
		createCategoriesBtn.click();
		clickAlert();
		closeAddCategoriesModal.click();
	}
	
	
	public void removeCategory() {
		
		actionButton.click();
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("arguments[0].scrollIntoView(true);", removeButton);
		removeButton.click();
		removeCategoriesBtn.click();
	}
	

}
