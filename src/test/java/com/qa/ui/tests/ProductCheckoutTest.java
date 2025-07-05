package com.qa.ui.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static com.qa.constants.Size.*;
import com.qa.ui.pages.SearchResultPage;

@Listeners(com.ui.listeners.TestListeners.class)
public class ProductCheckoutTest extends TestBase{
	
	private static final String SEARCH_ITEM="Printed Summer Dress";
	private SearchResultPage searchResultPage;
	
	@BeforeMethod(description="User logs into the application and searched for product")
	public void setUp(){
		searchResultPage=homePage.goToLoginPage().doLoginWith("automationframework@gmail.com","tester1234").searchForAProcduct(SEARCH_ITEM);
	}

	
	@Test(description= "verify if the logged in user is able to buy a dress", groups= {"sanity", "smoke", "e2e"})
	public void checkoutTest() {
		String result=searchResultPage.clickOnProductAtIndex(1).changeSize(L).addProductToCart().proceedToCheckout().goToConfirmAddressPage()
		.goToShipmentPage().goToPaymentPage().makePaymentByWire();
		
		Assert.assertTrue(result.equals("Your order on My Shop is complete."));
	}
	
	
}
