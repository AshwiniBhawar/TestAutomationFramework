package com.qa.utilities;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.constants.BrowserConstants;
import com.qa.constants.TimeConstants;

public abstract class BrowserUtility {

	Logger logger = LoggerUtility.getLogger(this.getClass());
	
	private static ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
	private WebDriverWait wait;
	
	public WebDriver getDriver() {
		//driver.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		return driver.get();	
	}

	public BrowserUtility(WebDriver driver) {
		this.driver.set(driver); // initialize the instance variable driver
		wait= new WebDriverWait(driver, Duration.ofSeconds(30L));
	}

	public BrowserUtility(BrowserConstants browserName, boolean isHeadless) {
		logger.info("Launching Browser for: " + browserName);

		switch (browserName) {
		case CHROME:
			if (isHeadless) {
				ChromeOptions options = new ChromeOptions();
				options.addArguments("--headless");
				options.addArguments("--window-size==1920,1080");
				driver.set(new ChromeDriver(options));
				wait= new WebDriverWait(driver.get(), Duration.ofSeconds(30L));
				break;
			} else {
				driver.set(new ChromeDriver());
				wait= new WebDriverWait(driver.get(), Duration.ofSeconds(30L));
				break;
			}
		case FIREFOX:
			if (isHeadless) {
				FirefoxOptions options = new FirefoxOptions();
				options.addArguments("--headless");
				options.addArguments("--window-size==1920,1080");
				driver.set(new FirefoxDriver(options));
				wait= new WebDriverWait(driver.get(), Duration.ofSeconds(30L));
				break;
			} else {
				driver.set(new FirefoxDriver());
				wait= new WebDriverWait(driver.get(), Duration.ofSeconds(30L));
				break;
			}
		case EDGE:
			if (isHeadless) {
				EdgeOptions options = new EdgeOptions();
				options.addArguments("--headless");
				options.addArguments("disable-gpu");
				options.addArguments("--window-size==1920,1080");
				driver.set(new EdgeDriver(options));
				wait= new WebDriverWait(driver.get(), Duration.ofSeconds(30L));
				break;
			} else {
				driver.set(new EdgeDriver());
				wait= new WebDriverWait(driver.get(), Duration.ofSeconds(30L));
				break;
			}

		default:
			logger.info("Invalid browser name..Please select Chrome, Edge or Firefox only");
			System.err.println("Invalid browser name..Please select Chrome, Edge or Firefox only");
			throw new CustomException("Browser not supported");
		}

		logger.info("Implicit wait set to " + TimeConstants.MEDIUM_TIMEOUT + " seconds");
		driver.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(TimeConstants.MEDIUM_TIMEOUT));
		logger.info("Maximizing the browser window");
		driver.get().manage().window().maximize();

	}

	public void goToWebSite(String url) {
		logger.info("Visiting the website: " + url);
		driver.get().get(url);
	}

	public void maximizeWindow() {
		logger.info("Maximizing the browser window");
		driver.get().manage().window().maximize();
	}

	public void clickOn(By locator) {
		logger.info("Finding element with locator: " + locator);
		//WebElement element = driver.get().findElement(locator);
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
		logger.info("Element found and now performing Click");
		element.click();
	}
	
	public void clickOnCheckbox(By locator) {
		logger.info("Finding element with locator: " + locator);
		//WebElement element = driver.get().findElement(locator);
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		logger.info("Element found and now performing Click");
		element.click();
	}
	
	public void clickOn(WebElement element) {
		logger.info("Element found and now performing Click");
		WebElement elementClick = wait.until(ExpectedConditions.elementToBeClickable(element));
		elementClick.click();
	}

	public void enterText(By locator, String textToEnter) {
		logger.info("Finding element with the locator: " + locator);
		//WebElement element = driver.get().findElement(locator);
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		logger.info("Element found and now enter text :" + textToEnter);
		element.sendKeys(textToEnter);
	}
	
	public void clearText(By textBoxLocator) {
		logger.info("Finding element with the locator: " + textBoxLocator);
		//WebElement element= driver.get().findElement(textBoxLocator);
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(textBoxLocator));
		logger.info("Element found and clearing the textbox fields");
		element.clear();
	}
	
	public void selectFromDropDown(By dropDownLocator, String textToSelect) {
		logger.info("Finding element with the locator: " + dropDownLocator);
		WebElement element= driver.get().findElement(dropDownLocator);
		Select select= new Select(element);
		logger.info("Selecting the option: " + textToSelect);
		select.selectByVisibleText(textToSelect);
		
	}
	
	public void enterSpecialText(By locator, Keys keyToEnter) {
		logger.info("Finding element with the locator: " + locator);
		//WebElement element = driver.get().findElement(locator);
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		logger.info("Element found and now enter special key :" + keyToEnter);
		element.sendKeys(keyToEnter);
	}

	public String getVisibileText(By locator) {
		logger.info("Finding element with the locator: " + locator);
		//WebElement element = driver.get().findElement(locator);
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		logger.info("Element found and now returning the visible text: " + element.getText());
		return element.getText();
	}
	
	public String getVisibileText(WebElement element) {
		logger.info("Return the visible text: " + element.getText());
		return element.getText();
	}
	
	public List<String> getAllVisibleText(By locator) {
		logger.info("Finding all elements with the locator: " + locator);
		//List<WebElement> elementList = driver.get().findElements(locator);
		List<WebElement> elementList = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
		logger.info("Element found and now printing the list of Elements");
		List<String> visibleTextList= new ArrayList();
		for(WebElement element:elementList) {
			System.out.println(getVisibileText(element));
			visibleTextList.add(getVisibileText(element));
		}
		
		return visibleTextList;
		
	}
	
	public List<WebElement> getAllElements(By locator) {
		logger.info("Finding all elements with the locator: " + locator);
		//List<WebElement> elementList = driver.get().findElements(locator);
		List<WebElement> elementList = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
		logger.info("Element found and now printing the list of Elements");
		
		return elementList;
		
	}
	
	public void quit(){
		driver.get().quit();
	}

	public String takeScreenshot(String name) {
		TakesScreenshot ts = (TakesScreenshot) driver.get();
		File scourceFile = ts.getScreenshotAs(OutputType.FILE);

		String path = "./screenshots/" + name + "-" + DateTimeFormatUtility.getTime()
				+ ".png";
		File destFile = new File(path);
		try {
			FileUtils.copyFile(scourceFile, destFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return path;
	}

}
