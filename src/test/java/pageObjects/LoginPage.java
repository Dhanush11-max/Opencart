package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{
	
	public LoginPage(WebDriver driver) {
		super(driver);
	}
	@FindBy(xpath="//input[@id='input-email']")
	WebElement txtEmailAdd;
	
	@FindBy(xpath="//input[@id='input-password']")
	WebElement txtPass;
	
	@FindBy(xpath="//input[@value='Login']")
	WebElement btnLogin;
	
	public void setUserName(String Uname) {
		txtEmailAdd.sendKeys(Uname);
	}
	
	public void setPass(String Pass) {
		txtPass.sendKeys(Pass);
	}
	
	public void clkLogin() {
		btnLogin.click();
	}
}
