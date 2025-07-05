package com.qa.ui.tests;

import static org.testng.Assert.assertEquals;

import org.apache.logging.log4j.Logger;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.qa.pojo.LoginTestData.User;
import com.qa.utilities.LoggerUtility;
import com.ui.listeners.MyRetryAnalyzer;

@Listeners(com.ui.listeners.TestListeners.class)
public class InvalidCredsLoginTest extends TestBase{
	
	Logger logger=LoggerUtility.getLogger(this.getClass());
	private static final String INVALID_EMAIL_ADDRESS="automationframework@gmail.com";
	private static final String INVALID_PASSWORD="tester";
	
	@Test(description="Verified if the proper error message is shown for the invalid credentials when user enters invalid credentials", groups={"e2e","smoke"})
	public void invalidLoginTest(){
		String errMsg=homePage.goToLoginPage().DoLoginWithInvalidCredentials(INVALID_EMAIL_ADDRESS,INVALID_PASSWORD).getErrorMessage();
		assertEquals(errMsg, "Authentication failed.");
	}
	
}
