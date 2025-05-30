package com.ui.listeners;

import org.testng.ITestResult;

import com.qa.constants.EnvConstants;
import com.qa.utilities.JsonUtility;
import com.qa.utilities.PropertiesUtil;

import org.testng.IRetryAnalyzer;

public class MyRetryAnalyzer implements IRetryAnalyzer{

	//private static final int MAX_NUMBER_OF_ATTEMPTS=Integer.parseInt(PropertiesUtil.readProperty(EnvConstants.QA, "MAX_NUMBER_OF_ATTEMPTS"));
	private static final int MAX_NUMBER_OF_ATTEMPTS=JsonUtility.readJSONFile(EnvConstants.QA).getMAX_NUMBER_OF_ATTEMPTS();
	private int currentAttempt=1;
	
	@Override
	public boolean retry(ITestResult result) {
		
		if(currentAttempt<=MAX_NUMBER_OF_ATTEMPTS) {
			currentAttempt++;
			return true;
		}
		
		return false;
	}

}
