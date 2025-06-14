package com.qa.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.utilities.BrowserUtility;

public final class MyAccountPage extends BrowserUtility {

	public MyAccountPage(WebDriver driver) {
		super(driver);
	}
	
	private static final By USER_NAME_LOCATOR=By.xpath("//a[@title='View my customer account']/span");
	
	public String getUserName(){
		return getVisibileText(USER_NAME_LOCATOR);
	}

}
