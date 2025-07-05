package com.qa.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.utilities.BrowserUtility;

public class ShoppingCartPage extends BrowserUtility{
	
	
	public ShoppingCartPage(WebDriver driver) {
		super(driver);
	}
	
	private final static By PROCEED_TO_CHECKOUT_BUTTON_LOCATOR =By.xpath("//p[contains(@class,'cart_navigation')]/a[@title='Proceed to checkout']");

	public ConfirmAddressPage goToConfirmAddressPage() {
		clickOn(PROCEED_TO_CHECKOUT_BUTTON_LOCATOR);
		return new ConfirmAddressPage(getDriver());
	}
}
