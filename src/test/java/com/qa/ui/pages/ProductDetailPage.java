package com.qa.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.constants.Size;
import com.qa.utilities.BrowserUtility;

public class ProductDetailPage extends BrowserUtility{
	
	public ProductDetailPage(WebDriver driver) {
		super(driver);
	}
	
	private static final By Size_DROP_DOWN_LOCATOR= By.id("group_1");
	private static final By ADD_TO_CART_BUTTON_LOCATOR= By.name("Submit");
	private static final By PROCEED_TO_CHECKOUT_BUTTON_LOCATOR= By.xpath("//a[@title='Proceed to checkout']");
	
	public ProductDetailPage changeSize(Size size) {
		selectFromDropDown(Size_DROP_DOWN_LOCATOR, size.toString());
		return new ProductDetailPage(getDriver());
	}
	
	public ProductDetailPage addProductToCart() {
		clickOn(ADD_TO_CART_BUTTON_LOCATOR);
		return new ProductDetailPage(getDriver());
	}
	
	public ShoppingCartPage proceedToCheckout() {
		 clickOn(PROCEED_TO_CHECKOUT_BUTTON_LOCATOR);
		 return new ShoppingCartPage(getDriver());
	}
}
