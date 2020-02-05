package po;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageObject {

	protected WebDriver driver;
	private boolean alert= false;
	WebDriverWait wait;
	JavascriptExecutor js = (JavascriptExecutor)driver;
	
	public boolean isAlert() {
		return alert;
	}


	public void setAlert(boolean alert) {
		this.alert = alert;
	}


	public PageObject(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		js = (JavascriptExecutor)driver;
	}
	
	
	public boolean clickAlert() {
		try {
			WebDriverWait webDriverWait = new WebDriverWait(driver, 2);
			webDriverWait.until(ExpectedConditions.alertIsPresent());
			driver.switchTo().alert().accept();
			alert = true;
		}catch(NoAlertPresentException e) {
			alert = false;
			System.out.println("no alert");
		}catch (TimeoutException e) {
			alert = false;	
			System.out.println("timeout");
		}

		return alert;
		
	}
	
	public void waitForWebsite() {
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
