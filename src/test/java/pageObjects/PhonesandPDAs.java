package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PhonesandPDAs extends BasePage{

	public PhonesandPDAs(WebDriver driver) {
		super(driver);
	}
	
	@FindBy (xpath = "//span[text()='Add to Cart']")
	WebElement lnkAddtoCart;
	
	@FindBy (xpath = "//a[normalize-space()='shopping cart']")
	WebElement msgCartAdded;
	
	public void clkAddtoCart() {
		lnkAddtoCart.click();
	}
	public String getTextofmsgCartAdded() {
		try{
			return (msgCartAdded.getText());
		} catch (Exception e) {
			return (e.getMessage());
		}
	}
}
