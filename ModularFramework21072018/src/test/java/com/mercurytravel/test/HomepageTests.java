package com.mercurytravel.test;

import org.testng.Assert;
import org.testng.annotations.Test;

public class HomepageTests extends BasicOperations {

	@Test(priority = 0)
	public void verifyTitleOfThePage() throws Exception {
		test = extent.createTest("TC - 002 - Verify Title of the page");

		String actualHomepageTitle = cmnDriver.getTitle();
		String expectedHomePageTitle = configProperties.getProperty("homepageTitle");
		
		test.info("Comparing actual and expected home page title");
		Assert.assertEquals(actualHomepageTitle, expectedHomePageTitle);
	}

	@Test(priority = 1000)
	public void verifyUserLogin() throws Exception {
		test = extent.createTest("TC - 003 - Verify User login");
		String userEmailId = configProperties.getProperty("userEmailId");
		String userPassword = configProperties.getProperty("userPassword");
		homepage.userLogin(userEmailId, userPassword);

		String expectedWelcomeText = configProperties.getProperty("welcomeText");
		;

		String actualWelcomeText = homepage.getWelcomeText();
		test.info("Compare Actual and Expected Welcome Text");
		// camera.captureAndSaveScreenshot(currentProjectDirectory+"/screenshots/verifyUserlogin.png");
		Assert.assertEquals(actualWelcomeText, expectedWelcomeText);
	}
}
