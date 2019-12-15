package po;


import org.openqa.selenium.JavascriptExecutor;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import org.openqa.selenium.support.ui.Select;


public class BrandPage extends PageObject{

	
	@FindBy (xpath = "//button[@class='btn btn-default button1']")
	WebElement addBrandButton;
	@FindBy (how = How.ID, using = "brandName")
	WebElement brandNameInput;
	@FindBy (how = How.ID, using = "brandStatus")
	WebElement brandStatusSelect;
	@FindBy(how = How.ID, using = "createBrandBtn")
	WebElement createBrandBtn;
	@FindBy(xpath ="//button[contains(text(),'Close')]")
	WebElement closeButton;
	@FindBy (xpath = "/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[3]/table[1]/tbody[1]/tr[2]/td[1]")
	WebElement brandName;
	@FindBy (xpath = "/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[3]/table[1]/tbody[1]/tr[2]/td[3]/div[1]/button[1]")
	WebElement actionButton;
	@FindBy (xpath = "//tr[@class='even']//li[2]//a[1]")
	WebElement removeButton;
	
	public WebElement getRemoveButton() {
		return removeButton;
	}


	public void setRemoveButton(WebElement removeButton) {
		this.removeButton = removeButton;
	}

	@FindBy (how = How.ID, using = "removeBrandBtn")
	WebElement removeBrandBtn;
	
	
	
	
	public BrandPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	
	public void addBrand(String name, String availability) {
		
		addBrandButton.click();
		brandNameInput.sendKeys(name);
		Select element = new Select(brandStatusSelect);
		element.selectByVisibleText(availability);
		createBrandBtn.click();
		closeButton.click();
		
	}


	public WebElement getBrandName() {
		return brandName;
	}


	public void setBrandName(WebElement brandName) {
		this.brandName = brandName;
	}
	
	public void removeBrand() {
		
		actionButton.click();

		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("arguments[0].scrollIntoView(true);", removeButton);
		removeButton.click();		
		removeBrandBtn.click();
	}
	

}
