package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class SearchedProduct extends BasePage{

	public SearchedProduct(WebDriver driver) {
		super(driver);
		}
	
	@FindBy (xpath="//button[@data-original-title='Compare this Product']")
	WebElement btnComparethisProduct;
	
	@FindBy (xpath="//a[normalize-space()='product comparison']")
	WebElement msgProductCompared;
	
	public void clickComparethisproduct() {
		Actions Act = new Actions(driver);
		Act.moveToElement(btnComparethisProduct).build().perform();
		btnComparethisProduct.click();
	}
	
	public String getTextofmsgProductCompared() {
		try{
			return (msgProductCompared.getText());
		}
		catch(Exception e) {
			return (e.getMessage());
		}
	}
}
