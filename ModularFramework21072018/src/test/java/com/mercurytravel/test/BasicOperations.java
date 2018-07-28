package com.mercurytravel.test;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.mercurytravel.pages.Homepage;

import commonLibs.implementation.CommonDriver;
import commonLibs.implementation.ScreenshotControl;

public class BasicOperations extends ReportGenerator {

	public CommonDriver cmnDriver;
	public Homepage homepage;
	public WebDriver driver;
	public ScreenshotControl camera;

	@BeforeClass
	public void invokeBrowser() throws Exception {

		test = extent.createTest("Test case Id : Test-001 : Invoke Browser");

		String browserType = configProperties.getProperty("browserType");
		test.info("Browser Type is :: " + browserType);

		cmnDriver = new CommonDriver(browserType);

		int pageloadtimeout = Integer.parseInt(configProperties.getProperty("pageLoadTimeout"));
		cmnDriver.setPageLoadTimeout(pageloadtimeout);
		test.info("Page load Timeout : "+pageloadtimeout);
		
		int elementDetectionTimeout = Integer.parseInt(configProperties.getProperty("elementDetectionTimeout"));
		cmnDriver.setElementDetectionTimeout(elementDetectionTimeout);
		test.info("Element Detection Timeout :: "+elementDetectionTimeout);
		
		cmnDriver.navigateToFirstUrl(configProperties.getProperty("baseUrl"));

		driver = cmnDriver.getDriver();
		homepage = new Homepage(driver);
		camera = new ScreenshotControl(driver);

	}

	@AfterClass
	public void closeBrowser() throws Exception {
		cmnDriver.closeAllBrowsers();
	}

}
