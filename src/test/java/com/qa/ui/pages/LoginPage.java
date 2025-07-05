package com.qa.ui.pages;

import java.time.Duration;

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
	private static final By ERROR_MSG_LOCATOR=By.xpath("//div[contains(@class,'alert-danger')]//li");
	
	public MyAccountPage doLoginWith(String emailAddress, String password) {
		enterText(EMAIL_TEXT_BOX_LOCATOR, emailAddress);
		enterText(PASSWORD_TEXT_BOX_LOCATOR, password);
		clickOn(SIGNIN_BUTTON_LOCATOR);
		MyAccountPage myAccount=new MyAccountPage(getDriver());
		return myAccount;
	}
	
	public LoginPage DoLoginWithInvalidCredentials(String emailAddress, String password) {
		enterText(EMAIL_TEXT_BOX_LOCATOR, emailAddress);
		enterText(PASSWORD_TEXT_BOX_LOCATOR, password);
		clickOn(SIGNIN_BUTTON_LOCATOR);
		LoginPage loginPage=new LoginPage(getDriver());
		return loginPage;
	}
	
	public String getErrorMessage() {
		return getVisibileText(ERROR_MSG_LOCATOR);
	}

}
