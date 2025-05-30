package com.qa.ui.tests;

import static org.testng.Assert.assertEquals;

import org.apache.logging.log4j.Logger;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.qa.pojo.LoginTestData.User;
import com.qa.utilities.LoggerUtility;
import com.ui.listeners.MyRetryAnalyzer;

@Listeners(com.ui.listeners.TestListeners.class)
public class LoginTest extends TestBase{
	
	Logger logger=LoggerUtility.getLogger(this.getClass());
	
	@Test(description="Verified the valid user is able to login into the application", groups={"e2e","smoke"}, 
			dataProviderClass =com.qa.utilities.DataProviderUtility.class, dataProvider = "LoginDataProviderJSON",
			retryAnalyzer =MyRetryAnalyzer.class)
	public void loginJSONTest(User user){
		String userName=homePage.goToLoginPage().doLoginWith(user.getEmail(), user.getPassword()).getUserName();
		assertEquals(userName, user.getTitle());
	}
	
	@Test(description="Verified the valid user is able to login into the application", groups={"e2e","smoke"}, 
			dataProviderClass =com.qa.utilities.DataProviderUtility.class, dataProvider = "LoginDataProviderCSV")
	public void loginCSVTest(User user){
		String userName=homePage.goToLoginPage().doLoginWith(user.getEmail(), user.getPassword()).getUserName();
		assertEquals(userName, user.getTitle());
	}
	
	@Test(description="Verified the valid user is able to login into the application", groups={"e2e","smoke"}, 
			dataProviderClass =com.qa.utilities.DataProviderUtility.class, dataProvider = "LoginDataProviderExcel")
	public void loginExcelTest(User user){
		String userName=homePage.goToLoginPage().doLoginWith(user.getEmail(), user.getPassword()).getUserName();
		assertEquals(userName, user.getTitle());
	}

}
