package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import BaseTest.BaseClass;
import pageObjects.AccountResistrationPage;
import pageObjects.HomePage;

public class TC001_AccountResistrationTest extends BaseClass{

	
	@Test(groups={"Regression", "Master"})
	public void verify_account_resistration() {
		
		logger.info("***** Starting TC001_AccountResistrationTest *****");
		
		try {
		HomePage hp = new HomePage(driver);
		
		hp.clickMyAccount();
		logger.info("***** Clicked on My Account link *****");
		
		hp.clickResister();
	    logger.info("***** Clicked on Resister link *****");
		
		AccountResistrationPage regpage = new AccountResistrationPage(driver);
		
		logger.info("***** Providing Customer details *****");
		regpage.setFirstname(randomString().toUpperCase());
		regpage.setLastname(randomString().toUpperCase());
		regpage.setEmail(randomString()+"@gmail.com");
		regpage.setTeliphone(randomNumber());
		
		// Here "Password" and "ConfirmPassword" should be same, thats why we ran the 'randomAlphaNumeric' method and store the result in variable call 'password' and pass this for 'password' and 'confirmpassword'
		String password = randomAlphaNumeric();
		
		regpage.setPassword(password);
		regpage.setConfirmPassword(password);
		
		regpage.setPrivacyPolicy();
		regpage.clickContinue();
		
		logger.info("***** Validating Expected Result *****");
		String confmsg = regpage.getConfirmationMsg();
		
		if(confmsg.equals("Your Account Has Been Created!")) {
			Assert.assertTrue(true);
		}
		else {
			logger.error("***** Test Failed *****");
			logger.debug("***** Debug Logs *****");
			Assert.assertTrue(false);
		}
		
		}
		catch(Exception e){
			Assert.fail();
		}
		logger.info("***** Finished TC001_AccountResistrationTest *****");

		}
}

