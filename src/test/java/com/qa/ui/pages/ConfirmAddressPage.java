package com.qa.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.utilities.BrowserUtility;

public class ConfirmAddressPage extends BrowserUtility{
	
	public ConfirmAddressPage(WebDriver driver) {
		super(driver);
	}
	
	private static final By PROCEED_TO_CHECKOUT= By.name("processAddress");
	
	
	public ShippmentPage goToShipmentPage() {
		clickOn(PROCEED_TO_CHECKOUT);
		return new ShippmentPage(getDriver());
	}

}
