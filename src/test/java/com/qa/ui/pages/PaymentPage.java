package com.qa.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.utilities.BrowserUtility;

public class PaymentPage extends BrowserUtility{
	
	public PaymentPage(WebDriver driver) {
		super(driver);
	}
	
	private static final By PAYMENT_BY_WIRE_BUTTON_LOCATOR =By.xpath("//a[@title='Pay by bank wire']");
	private static final By CONFIRM_PAYMENT_BUTTON_LOCATOR =By.xpath("//p[contains(@class,'cart_navigation')]/button");
	private static final By ALERT_SUCCESS_MESSAGE_LOCATOR =By.xpath("//p[contains(@class,'success')]");
	
	
	public String makePaymentByWire() {
		clickOn(PAYMENT_BY_WIRE_BUTTON_LOCATOR);
		clickOn(CONFIRM_PAYMENT_BUTTON_LOCATOR);
		return getVisibileText(ALERT_SUCCESS_MESSAGE_LOCATOR);
	}

}
