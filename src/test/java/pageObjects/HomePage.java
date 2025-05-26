package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{
	
	WebDriver driver;
	
	public HomePage(WebDriver driver) {
		super (driver);
	}

	@FindBy(xpath="//span[normalize-space()='My Account']")
	WebElement lnkMyAccount;
	
	@FindBy (xpath="//a[normalize-space()='Register']")
	WebElement lnkResister;
	
	@FindBy (xpath="//a[normalize-space()=\"Login\"]")
	WebElement lnkLogin;
	
	@FindBy (xpath="//input[@name='search']")
	WebElement txtSearchBar;
	
	@FindBy (xpath="//span[@class='input-group-btn']")
	WebElement lnkSearchIcon;
	
	public void clickMyAccount() {
		lnkMyAccount.click();
	}
	
	public void clickResister() {
		lnkResister.click();
	}
	
	public void clickLogin() {
		lnkLogin.click();
	}
	
	public void clickSearchBar() {
		txtSearchBar.click();
	}
	public void searchProduct(String ProdName) {
		txtSearchBar.sendKeys(ProdName);
	}
	
	public void clickOnSearchIcon() {
		lnkSearchIcon.click();
	}
}
