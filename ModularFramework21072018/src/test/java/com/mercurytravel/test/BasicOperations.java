package com.mercurytravel.test;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
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

		test = extent.createTest("TC - 001 : Invoke Browser");

		String browserType = configProperties.getProperty("browserType");
		test.info("Browser Type is :: " + browserType);

		cmnDriver = new CommonDriver(browserType);

		int pageloadtimeout = Integer.parseInt(configProperties.getProperty("pageLoadTimeout"));
		cmnDriver.setPageLoadTimeout(pageloadtimeout);
		test.info("Page load Timeout : "+pageloadtimeout);
		
		int elementDetectionTimeout = Integer.parseInt(configProperties.getProperty("elementDetectionTimeout"));
		cmnDriver.setElementDetectionTimeout(elementDetectionTimeout);
		test.info("Element Detection Timeout :: "+elementDetectionTimeout);
		
		String url = configProperties.getProperty("baseUrl");
		test.info("Navigating to url : "+ url);
		cmnDriver.navigateToFirstUrl(url);

		driver = cmnDriver.getDriver();
		
		test.info("Initializing homepage driver instance");
		homepage = new Homepage(driver);
	
		test.info("Initializing screenshot instance");
		camera = new ScreenshotControl(driver);

	}
	
	@AfterMethod
	public void afterAMethod(ITestResult result) throws Exception {

		if (result.getStatus() == ITestResult.FAILURE) {
			test.fail("Test case Failed :: " + result.getName());

			String fileName = String.format("%s/screenshots/%s%s.png",
					currentProjectDirectory,result.getName(), testExecutionStartTime);

			String resultPath = camera.captureAndSaveScreenshot(fileName);

			
			test.addScreenCaptureFromPath(resultPath);
		}

		else if (result.getStatus() == ITestResult.SKIP) {

			test.skip("Test case Skipped :: " + result.getName());
		} else {
			test.pass("Test case passed :: " + result.getName());
		}

	}

	@AfterClass
	public void closeBrowser() throws Exception {
		cmnDriver.closeAllBrowsers();
	}

}
