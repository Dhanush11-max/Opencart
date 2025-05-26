package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import BaseTest.BaseClass;
import pageObjects.HomePage;
import pageObjects.MyAccountPage;
import pageObjects.PhonesandPDAs;

public class TC004_AddtoCart extends BaseClass{

	@Test(groups={"master","Regression"})
	public void verify_Add_to_Cart() {
		
		try{
	
		logger.info("*****Started TC004_AddtoCart*****");
		
		HomePage hp = new HomePage(driver);
		 
		hp.clickMyAccount();
		hp.clickLogin();
		
		MyAccountPage ma = new MyAccountPage(driver);
		
		ma.clkPhonesandPDAs();
		
		PhonesandPDAs pp = new PhonesandPDAs(driver);
		
		pp.clkAddtoCart();
		
		String sucmsg = pp.getTextofmsgCartAdded();
		
		logger.info("*****Validating Add to Cart success msg*****");
		
		if(sucmsg.equalsIgnoreCase("shopping cart")) {
			Assert.assertTrue(true);
		}
		else {
			logger.error("***** Test Failed *****");
			logger.debug("***** Debug Logs *****");
			Assert.assertTrue(false);
		}
		}
		catch(Exception e) {
			Assert.fail();
		}
		logger.info("*****Finished TC004_AddtoCart*****");
	}
}
