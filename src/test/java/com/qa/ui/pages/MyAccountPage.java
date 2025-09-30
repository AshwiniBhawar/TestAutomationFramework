package com.qa.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import com.qa.utilities.BrowserUtility;

public final class MyAccountPage extends BrowserUtility {

	public MyAccountPage(WebDriver driver) {
		super(driver);
	}
	
	private static final By USER_NAME_LOCATOR=By.xpath("//a[@title='View my customer account']/span");
	private static final By SEARCH_TEXT_BOX_LOCATOR=By.id("search_query_top");
	private static final By ADD_NEW_ADDRESS_LINK_LOCATOR=By.xpath("//a[@title='Add my first address']");
	
	public String getUserName(){
		return getVisibileText(USER_NAME_LOCATOR);
	}
	
	public SearchResultPage searchForAProcduct(String productName) {
		enterText(SEARCH_TEXT_BOX_LOCATOR, productName);
		enterSpecialText(SEARCH_TEXT_BOX_LOCATOR, Keys.ENTER);
		SearchResultPage searchresultPage=new SearchResultPage(getDriver());
		return searchresultPage;
		
	}
	
	public AddressPage goToAddAddressPage() {
		clickOn(ADD_NEW_ADDRESS_LINK_LOCATOR);
		AddressPage addressPage= new AddressPage(getDriver());
		return addressPage;
	}

}
