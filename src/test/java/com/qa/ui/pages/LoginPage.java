package com.qa.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.utilities.BrowserUtility;

public final class LoginPage extends BrowserUtility{

	public LoginPage(WebDriver driver) {
		super(driver);
	}
	
	private static final By EMAIL_TEXT_BOX_LOCATOR= By.id("email");
	private static final By PASSWORD_TEXT_BOX_LOCATOR= By.id("passwd");
	private static final By SIGNIN_BUTTON_LOCATOR= By.id("SubmitLogin");
	
	public MyAccountPage doLoginWith(String emailAddress, String password) {
		enterText(EMAIL_TEXT_BOX_LOCATOR, emailAddress);
		enterText(PASSWORD_TEXT_BOX_LOCATOR, password);
		clickOn(SIGNIN_BUTTON_LOCATOR);
		MyAccountPage myAccount=new MyAccountPage(getDriver());
		return myAccount;
	}

}
