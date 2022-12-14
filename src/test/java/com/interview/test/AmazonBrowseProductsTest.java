package com.interview.test;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.interview.pageObjects.GoogleSearchPage;
import com.interview.pageObjects.AmazonHomepage;
import com.interview.utility.DriverManagement;
import com.interview.utility.TestDataHandling;

public class AmazonBrowseProductsTest {
	
	WebDriver driver;
	
	private final String SITE = "Amazon";
	private final String CATEGORY = "Electronics";
	private final String QUERY = "dell computers";
	private final String BROWSER = "chrome";
	private final String URL = "url";
	private final String LOWER = "20000";
	private final String HIGHER = "30000";
	
	@Test
	public void testLogin() {
		try {
			TestDataHandling data = new TestDataHandling();
			DriverManagement driverHandle = new DriverManagement();
			driver=driverHandle.getDriver(BROWSER, data.getProperty(URL));
			Thread.sleep(3000);
			GoogleSearchPage googleSearchObj = new GoogleSearchPage(driver);
			googleSearchObj.searchWithText(SITE);
			googleSearchObj.printResultsIntheLogs();
			googleSearchObj.clickOnAmazonLink(driver);
			
			AmazonHomepage amazonHomeObj = new AmazonHomepage(driver);
			amazonHomeObj.waitForAmazonHome(driver);
			//Main
			/*amazonHomeObj.selectCategory(CATEGORY);
			amazonHomeObj.searchQuery(QUERY);
			amazonHomeObj.setPriceRange(LOWER, HIGHER);
			amazonHomeObj.checkPricesWithRange(Integer.valueOf(LOWER), Integer.valueOf(HIGHER));
			*/
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
	}

}
