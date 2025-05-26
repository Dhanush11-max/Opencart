package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import BaseTest.BaseClass;
import pageObjects.HomePage;
import pageObjects.SearchedProduct;

public class TC005_CompareProduct extends BaseClass{
	
	@Test(groups={"Regression", "master"})
	
	public void verify_Compair_Product() {
		
		try{
			
		logger.info("*****Started TC005_CompareProduct*****");
		
		HomePage hp = new HomePage(driver);
		
		hp.clickSearchBar();
		logger.info("*****Clicked on Search-Bar*****");
	
		hp.searchProduct(p.getProperty("ProdName"));
		logger.info("*****Searchted for iPhone*****");
		
		hp.clickOnSearchIcon();
		
		SearchedProduct sp = new SearchedProduct(driver);
		
		sp.clickComparethisproduct();
		
		if (sp.getTextofmsgProductCompared().equalsIgnoreCase("product comparison")) {
			Assert.assertTrue(true);
		}
		else {
			Assert.assertTrue(false);
		}
		}
		catch (Exception e){
			Assert.fail();
		}
		logger.info("*****Finished TC005_CompareProduct*****");
	}
}
