package com.qa.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.utilities.BrowserUtility;

public class ShippmentPage extends BrowserUtility{
	
	public ShippmentPage(WebDriver driver) {
		super(driver);
	}
	
	private static final By ACCEPT_TERMS_CHECKBOX_LOCATOR=By.id("uniform-cgv");
	private static final By PROCEED_TO_CHECKOUT_BUTTON_LOCATOR=By.name("processCarrier");
	
	public PaymentPage goToPaymentPage() {
		clickOnCheckbox(ACCEPT_TERMS_CHECKBOX_LOCATOR);
		clickOn(PROCEED_TO_CHECKOUT_BUTTON_LOCATOR);
		return new PaymentPage(getDriver());
	}
}
