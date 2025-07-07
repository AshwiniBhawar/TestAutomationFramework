package com.qa.ui.pages;

import static com.qa.constants.EnvConstants.QA;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.constants.BrowserConstants;
import com.qa.utilities.BrowserUtility;
import com.qa.utilities.JsonUtility;
import com.qa.utilities.LoggerUtility;
import com.qa.utilities.PropertiesUtil;

public final class HomePage extends BrowserUtility{
	
	Logger logger=LoggerUtility.getLogger(this.getClass());
	
	public HomePage(BrowserConstants browserName, boolean isHeadless) {
		super(browserName, isHeadless);		//to call parent class constructor from the child class constructor
		goToWebSite(JsonUtility.readJSONFile(QA).getUrl());
		//goToWebSite(readProperty(QA, "URL"));
	}
	
	public HomePage(WebDriver driver) {
		super(driver);						//to call parent class constructor from the child class constructor
		//goToWebSite(JsonUtility.readJSONFile(QA).getUrl());
		goToWebSite(PropertiesUtil.readProperty(QA, "URL"));
	}

	private static final By SIGN_IN_LINK_LOCATOR= By.xpath("//a[contains(text(),'Sign in')]");
		
	
	public LoginPage goToLoginPage() {		//PageFunctions
		logger.info("Trying to perform click to go to Sign In page");
		clickOn(SIGN_IN_LINK_LOCATOR);
		LoginPage loginpPage=new LoginPage(getDriver());
		return loginpPage;
	}
	
}
