package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import BaseTest.BaseClass;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import utilities.DataProviders;

public class TC003_LoginDDT extends BaseClass {

	@Test(dataProvider = "LoginData", dataProviderClass = DataProviders.class, groups={"DadaDriven","Master"})

	public void verify_LoginDDT(String email, String pwd, String exp) {

		try {
			logger.info("***** Starting TC003_LoginDDT*****");

			HomePage hp = new HomePage(driver); // Home Page
			hp.clickMyAccount();
			hp.clickLogin();

			LoginPage lp = new LoginPage(driver); // Login Page
			lp.setUserName(email); // Reading UserName from properties file
			lp.setPass(pwd); // Reading Password from properties file
			lp.clkLogin();

			MyAccountPage macc = new MyAccountPage(driver); // My Account Page
			boolean Targetpage = macc.isMyAccountPageExists();

			/*
			 * 1) Data is valid --> i)login success - test pass - logout 
			 *                     ii)login failed - test fail
			 * 
			 * 2) Data is invalid --> i)login success - test fail -logout 
			 *                       ii) login failed - test pass
			 */

			if (exp.equalsIgnoreCase("Valid")) {

				if (Targetpage == true) {
					macc.clkLogout();
					Assert.assertTrue(true);
				} else {
					Assert.assertTrue(false);
				}
			}
			if (exp.equalsIgnoreCase("Invalid")) {

				if (Targetpage == true) {
					macc.clkLogout();
					Assert.assertTrue(false);
				} else {
					Assert.assertTrue(true);
				}
			}
		} catch (Exception e) {
			Assert.fail();
		}
		logger.info("***** Finished TC003_LoginDDT*****");
	}
}
