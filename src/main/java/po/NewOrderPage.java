package po;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class NewOrderPage extends MenuComponent{

	
	@FindBy (id = "addRowBtn")
	WebElement addRowBtn;
	
	@FindBy (id = "orderDate")
	WebElement orderDate;
	@FindBy (id = "clientName")
	WebElement clientName;
	@FindBy (id = "clientContact")
	WebElement clientContact;
	
	@FindBy (id = "productName1")
	WebElement productName1;
	
	@FindBy (id = "discount")
	WebElement discount;
	@FindBy (id = "paid")
	WebElement paid;
	@FindBy (id = "paymentType")
	WebElement paymentType;
	@FindBy (id = "paymentStatus")
	WebElement paymentStatus;
	@FindBy (id = "paymentPlace")
	WebElement paymentPlace;
	
	@FindBy (id = "createOrderBtn")
	WebElement createOrderBtn;
	
	@FindBy (id = "totalAmountValue")
	WebElement totalAmountValue;
	
	@FindBy (id = "totalValue1")
	WebElement totalValue1;
	
	@FindBy (id = "subTotalValue")
	WebElement subTotalValue;
	
	@FindBy (id = "grandTotalValue")
	WebElement grandTotalValue;
	
	public NewOrderPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	
	public void addProductRow() {
		
		addRowBtn.click();
	}

	
	public void addOrder(String clientName, String clientContact, String totalValue1, String totalAmountValue, String subTotalValue, String discount, String grandTotalValue) {
		
		
		Actions builders = new Actions(driver);
		Action series = builders
				.moveToElement(orderDate)
				.click()
				.sendKeys("12/01/2019")
				.sendKeys(Keys.ESCAPE)
				.build();
		series.perform();
		this.clientName.sendKeys(clientName);
		this.clientContact.sendKeys(clientContact);
		waitForWebsite();
		
		Select product = new Select(productName1);
		product.selectByVisibleText("iPhone");
		
		driver.findElement(By.xpath("//tr[@id='row3']//button[@id='removeProductRowBtn']")).click();
		driver.findElement(By.xpath("//tr[@id='row2']//button[@id='removeProductRowBtn']")).click();

		if(totalValue1!=null) {
			js.executeScript("arguments[0].setAttribute('value', arguments[1])", this.totalValue1, totalValue1);
		}
		if(totalAmountValue!=null) {
			js.executeScript("arguments[0].setAttribute('value', arguments[1])", this.totalAmountValue, totalAmountValue);
		}
		if(subTotalValue!=null) {
			js.executeScript("arguments[0].setAttribute('value', arguments[1])", this.subTotalValue, subTotalValue);
		}
		if(discount!=null) {
			this.discount.sendKeys(discount);
		}else {
			this.discount.sendKeys("0");
		}
		
		if(grandTotalValue!=null) {
			js.executeScript("arguments[0].setAttribute('value', arguments[1])", this.grandTotalValue, grandTotalValue);
		}
		
		paid.sendKeys("0");
		
		Select payment = new Select(paymentType);
		payment.selectByVisibleText("Cheque");
		
		payment = new Select(paymentStatus);
		payment.selectByVisibleText("Full Payment");
		
		payment = new Select(paymentPlace);
		payment.selectByVisibleText("In Gujarat");
		
		createOrderBtn.click();

		
	}
	
}
