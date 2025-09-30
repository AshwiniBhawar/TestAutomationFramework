package com.qa.ui.pages;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.utilities.BrowserUtility;

public class SearchResultPage extends BrowserUtility{
	
	public SearchResultPage(WebDriver driver) {
		super(driver);
	}
	
	private static final By PRODUCT_LISTING_TITLE_LOCATOR= By.xpath("//span[@class='lighter']");
	private static final By ALL_PRODUCT_LISTS_LOCATOR =By.xpath("//h5[@itemprop='name']/a");
	
	public String getSearchResultTitle() {
		return getVisibileText(PRODUCT_LISTING_TITLE_LOCATOR);
	}
	
	public boolean isSearchTermPresentInProductList(String searchTerm) {
		List<String> keywords=Arrays.asList(searchTerm.toLowerCase().split(" "));
		List<String> productNamesList=getAllVisibleText(ALL_PRODUCT_LISTS_LOCATOR);
		
		int count=0;
		for (String productName : productNamesList) {
		    String lowerCaseProductName = productName.toLowerCase();
		    
		    for (String keyword : keywords) {
		        if (lowerCaseProductName.contains(keyword)) {
		           count++;
		        }
		    }
		}
		if(count>0) {
			return true;
		}
		return false; 
		
		/*boolean result=productNamesList.stream()
							.anyMatch(name->(keywords.stream().anyMatch(name.toLowerCase()::contains)));
		return false;*/		
	}
	
	public ProductDetailPage clickOnProductAtIndex(int index) {
		clickOn(getAllElements(ALL_PRODUCT_LISTS_LOCATOR).get(index));
		ProductDetailPage productDetailPage=new ProductDetailPage(getDriver());
		return productDetailPage;
	}
	
}
