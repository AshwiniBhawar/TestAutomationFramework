package com.qa.ui.tests;

import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.qa.ui.pages.MyAccountPage;
import com.qa.utilities.LoggerUtility;

@Listeners(com.ui.listeners.TestListeners.class)
public class SearchProductTest extends TestBase{
	Logger logger=LoggerUtility.getLogger(this.getClass());
	
	private MyAccountPage myAccountPage;
	private static final String SEARCH_TERM="Printed Summer Dress";
	
	@BeforeMethod(description="Valid user logs into the application")
	public void setUp() {
		myAccountPage=homePage.goToLoginPage().doLoginWith("automationframework@gmail.com", "tester1234");
	}
	
	@Test(description="verify if the logged in user is able to search for a product and correct products search results are displayed", 
			groups= {"e2e","smoke","sanity"})
	public void verifyProductSearchTest() throws InterruptedException {
		boolean actualResult=myAccountPage.searchForAProcduct(SEARCH_TERM).isSearchTermPresentInProductList(SEARCH_TERM);
		Assert.assertEquals(actualResult, true);
	}

}
