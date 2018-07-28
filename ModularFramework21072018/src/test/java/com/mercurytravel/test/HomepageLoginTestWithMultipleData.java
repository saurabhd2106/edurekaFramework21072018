package com.mercurytravel.test;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import utils.TestDataProvider;

public class HomepageLoginTestWithMultipleData extends BasicOperations {

	@Test(priority = 0)
	public void verifyTitleOfThePage() throws Exception {

		String actualHomepageTitle = configProperties.getProperty("homepageTitle");
		Assert.assertEquals(cmnDriver.getTitle(), actualHomepageTitle);
	}

	@Test(priority = 1000, groups="multipleTest",dataProvider="getData",dataProviderClass=TestDataProvider.class)
	public void verifyUserLogin(String userEmailId, String userPassword) throws Exception {

	
		homepage.userLogin(userEmailId, userPassword);

		String expectedWelcomeText = configProperties.getProperty("welcomeText");;

		String actualWelcomeText = homepage.getWelcomeText();
		
	//	camera.captureAndSaveScreenshot(currentProjectDirectory+"/screenshots/verifyUserlogin.png");
		Assert.assertEquals(actualWelcomeText, expectedWelcomeText);
		
		
	}
	
	@AfterMethod(groups="multipleTest")
	public void afterTest(){
		homepage.logout();
	}
}
