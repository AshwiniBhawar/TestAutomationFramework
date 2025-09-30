package com.qa.ui.tests;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import com.qa.constants.BrowserConstants;
import com.qa.ui.pages.HomePage;
import com.qa.utilities.BrowserUtility;
import com.qa.utilities.LoggerUtility;

public class TestBase {
	
	protected HomePage homePage;
	Logger logger=LoggerUtility.getLogger(this.getClass());
	
	@Parameters({"browser","isHeadless"})
	@BeforeMethod(description="Load the homepage of the website")
	public void setUp(
			@Optional("chrome")String browser, 
			@Optional("false")boolean isHeadless,
			ITestResult result) {
			
			logger.info("Load the homepage of the website");
			homePage= new HomePage(BrowserConstants.valueOf(browser.toUpperCase()),isHeadless);
	}
	
	public BrowserUtility getInstance() {
		return homePage;
	}
	
	@AfterMethod(description="Tear Down the browser")
	public void tearDown() {
		
		homePage.quit();	//local
	}

}
