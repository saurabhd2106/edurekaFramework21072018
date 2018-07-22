package com.mercurytravel.test;

import org.testng.Assert;
import org.testng.annotations.Test;

public class HomepageTests extends BasicOperations {

	@Test(priority = 0)
	public void verifyTitleOfThePage() throws Exception {
		Assert.assertEquals(cmnDriver.getTitle(),
				"Mercury Travels: Holiday Packages, Flight Booking, Hotels, Forex, Visa & Travel Insurance");
	}

	@Test(priority = 1000)
	public void verifyUserLogin() throws Exception {

		homepage.userLogin("saurabh.d2106@gmail.com", "Pro@1234");

		String expectedWelcomeText = "Welcome, Saurabh";

		String actualWelcomeText = homepage.getWelcomeText();
		Assert.assertEquals(actualWelcomeText, expectedWelcomeText);
	}
}
