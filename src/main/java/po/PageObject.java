package po;

import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class PageObject {

	protected WebDriver driver;
	private boolean alert= false;
	
	public boolean isAlert() {
		return alert;
	}


	public void setAlert(boolean alert) {
		this.alert = alert;
	}


	public PageObject(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	public boolean clickAlert() {
		try {
			driver.switchTo().alert().accept();
			alert = true;
		}catch(NoAlertPresentException e) {
			alert = false;
		}
		return alert;
		
	}
	
	public void waitForWebsite() {
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
