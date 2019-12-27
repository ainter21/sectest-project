package po;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class ReportPage extends MenuComponent{


	@FindBy (id = "startDate")
	WebElement startDate;
	@FindBy (id = "endDate")
	WebElement endDate;

	@FindBy (id = "generateReportBtn")
	WebElement generateReportBtn;

	public ReportPage(WebDriver driver) {
		super(driver);

	}


	public void getReport() {

		Actions builders = new Actions(driver);
		Action series = builders
				.moveToElement(startDate)
				.click()
				.sendKeys("12/01/2019")
				.sendKeys(Keys.ESCAPE)
				.build();
		series.perform();
		series = builders
				.moveToElement(endDate)
				.click()
				.sendKeys("12/01/2019")
				.sendKeys(Keys.ESCAPE)
				.build();
		series.perform();
		
		waitForWebsite();
		waitForWebsite();
		waitForWebsite();
		generateReportBtn.click();
	

	}

}
