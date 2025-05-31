package com.qa.utilities;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
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
import com.qa.constants.BrowserConstants;
import com.qa.constants.TimeConstants;

public abstract class BrowserUtility {

	Logger logger = LoggerUtility.getLogger(this.getClass());

	private static ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();

	public WebDriver getDriver() {
		return driver.get();
	}

	public BrowserUtility(WebDriver driver) {
		this.driver.set(driver); // initialize the instance variable driver
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
				break;
			} else {
				driver.set(new ChromeDriver());
				break;
			}
		case FIREFOX:
			if (isHeadless) {
				FirefoxOptions options = new FirefoxOptions();
				options.addArguments("--headless");
				options.addArguments("--window-size==1920,1080");
				driver.set(new FirefoxDriver(options));
				break;
			} else {
				driver.set(new FirefoxDriver());
				break;
			}
		case EDGE:
			if (isHeadless) {
				EdgeOptions options = new EdgeOptions();
				options.addArguments("--headless");
				options.addArguments("disable-gpu");
				options.addArguments("--window-size==1920,1080");
				driver.set(new EdgeDriver(options));
				break;
			} else {
				driver.set(new EdgeDriver());
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
		WebElement element = driver.get().findElement(locator);
		logger.info("Element found and now performing Click");
		element.click();
	}

	public void enterText(By locator, String textToEnter) {
		logger.info("Finding element with locator: " + locator);
		WebElement element = driver.get().findElement(locator);
		logger.info("Element found and now enter text :" + textToEnter);
		element.sendKeys(textToEnter);
	}

	public String getVisibileText(By locator) {
		logger.info("Finding element with locator: " + locator);
		WebElement element = driver.get().findElement(locator);
		logger.info("Element found and now returning the visible text: " + element.getText());
		return element.getText();
	}
	
	public void quit(){
		driver.get().quit();
	}

	public String takeScreenshot(String name) {
		TakesScreenshot ts = (TakesScreenshot) driver.get();
		File scourceFile = ts.getScreenshotAs(OutputType.FILE);

		String path = "./screenshot/" + name + "-" + DateTimeFormatUtility.getTime()
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
