package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage{

	public MyAccountPage(WebDriver driver) {
		super(driver);
	}

	@FindBy (xpath = "//h2[text()='My Account']")
	WebElement msgHeading;
	
	@FindBy (xpath = "//div[@class='list-group']//a[text()='Logout']")
	WebElement lnkLogout;
	
	@FindBy (xpath = "//a[text()='Phones & PDAs']")
	WebElement lnkPhonesandPDAs;
	public boolean isMyAccountPageExists() {
		
		try {
			return (msgHeading.isDisplayed());
		}
		catch (Exception e) {
			return false;
		}
	}
	
	public void clkLogout() {
		lnkLogout.click();
	}
	
	public void clkPhonesandPDAs() {
		lnkPhonesandPDAs.click();
	}
}
