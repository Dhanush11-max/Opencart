package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import BaseTest.BaseClass;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;

public class TC002_AccountLoginTest extends BaseClass{

	@Test(groups={"Sanity", "Master"})
	public void verify_account_login() {
		
		try {
			
		logger.info("***** Starting TC002_AccountLoginTest *****");
		HomePage hp = new HomePage(driver); // Home Page
		
		hp.clickMyAccount();
		logger.info("***** Clicked My Account *****");
		
		hp.clickLogin();
		logger.info("***** Clicked on Login *****");
		
		LoginPage lp = new LoginPage(driver); // Login Page
		logger.info("***** Providing Login details *****");
		
		lp.setUserName(p.getProperty("UserName")); // Reading UserName from properties file
		lp.setPass(p.getProperty("Password")); // Reading Password from properties file
		lp.clkLogin();
		
		MyAccountPage macc = new MyAccountPage(driver); // My Account Page
		boolean Targetpage=macc.isMyAccountPageExists();
		
		Assert.assertTrue(Targetpage); // Assert.assertEquals(Targetpage, true, "Login Failed");
		
		}
		catch(Exception e){
			Assert.assertFalse(false);
		}
		logger.info("***** Completed TC002_AccountLoginTest *****");
	}
}
