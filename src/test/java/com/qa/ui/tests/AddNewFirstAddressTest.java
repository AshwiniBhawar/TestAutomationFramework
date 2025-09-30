package com.qa.ui.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.pojo.AddressPOJO;
import com.qa.ui.pages.AddressPage;
import com.qa.ui.pages.MyAccountPage;
import com.qa.utilities.FakeAddressUtility;

public class AddNewFirstAddressTest extends TestBase{
	
	private MyAccountPage myAccountPage;
	private AddressPOJO address;
	
	@BeforeMethod(description="Valid first time user logs into the application")
	public void setUp() {
		myAccountPage=homePage.goToLoginPage().doLoginWith("automationframework@gmail.com", "tester1234");
		address=FakeAddressUtility.getFakeAddress();
	}
	
	@Test
	public void addNewAddress() {
		String newAddress=myAccountPage.goToAddAddressPage().saveAddress(address);
		Assert.assertEquals(newAddress, address.getAddressAlias().toUpperCase());	
	}

}
