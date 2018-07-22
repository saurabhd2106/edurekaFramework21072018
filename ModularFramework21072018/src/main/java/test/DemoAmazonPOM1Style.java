package test;

import org.openqa.selenium.WebDriver;

import commonLibs.implementation.CommonDriver;
import commonLibs.implementation.DropdownControl;
import commonLibs.implementation.ElementControls;
import designPattern.AmazonPOM1Style;

public class DemoAmazonPOM1Style {

	public static void main(String[] args) throws Exception{
		
		String url = "http://www.amazon.in";
		
		CommonDriver cmnDriver = new CommonDriver("chrome");
		
		cmnDriver.setPageLoadTimeout(30);

		cmnDriver.setElementDetectionTimeout(10);
		
		cmnDriver.navigateToFirstUrl(url);
		
		WebDriver driver = cmnDriver.getDriver();
		
		ElementControls elementControl = new ElementControls();
		
		DropdownControl dropdown = new DropdownControl();
		
		AmazonPOM1Style homepage = new AmazonPOM1Style(driver);
		
		elementControl.setText(homepage.searchBox, "Apple Watch");
		
		dropdown.selectViaVisibleText(homepage.searchCat, "Watches");
		
		elementControl.click(homepage.searchButton);
		
		cmnDriver.closeAllBrowsers();
	}

}
