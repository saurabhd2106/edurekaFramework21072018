package com.mercurytravel.test;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.mercurytravel.pages.Homepage;

import commonLibs.implementation.CommonDriver;

public class BasicOperations {
	
	public CommonDriver cmnDriver;
	public Homepage homepage;
	public WebDriver driver;

	@BeforeClass
	public void invokeBrowser() throws Exception {
		cmnDriver = new CommonDriver("chrome");

		cmnDriver.setPageLoadTimeout(30);
		cmnDriver.setElementDetectionTimeout(10);

		cmnDriver.navigateToFirstUrl("https://www.mercurytravels.co.in/");

		driver = cmnDriver.getDriver();
		homepage = new Homepage(driver);
	}

	@AfterClass
	public void closeBrowser() throws Exception {
		cmnDriver.closeAllBrowsers();
	}



}
