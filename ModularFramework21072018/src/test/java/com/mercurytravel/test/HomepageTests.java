package com.mercurytravel.test;

import org.testng.Assert;
import org.testng.annotations.Test;

public class HomepageTests extends BasicOperations {

	@Test(priority = 0)
	public void verifyTitleOfThePage() throws Exception {

		String actualHomepageTitle = configProperties.getProperty("homepageTitle");
		Assert.assertEquals(cmnDriver.getTitle(), actualHomepageTitle);
	}

	@Test(priority = 1000)
	public void verifyUserLogin() throws Exception {

		String userEmailId = configProperties.getProperty("userEmailId");
		String userPassword = configProperties.getProperty("userPassword");
		homepage.userLogin(userEmailId, userPassword);

		String expectedWelcomeText = configProperties.getProperty("welcomeText");;

		String actualWelcomeText = homepage.getWelcomeText();
		
	//	camera.captureAndSaveScreenshot(currentProjectDirectory+"/screenshots/verifyUserlogin.png");
		Assert.assertEquals(actualWelcomeText, expectedWelcomeText);
	}
}
