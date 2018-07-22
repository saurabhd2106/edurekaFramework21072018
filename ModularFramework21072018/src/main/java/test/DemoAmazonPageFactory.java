package test;

import org.openqa.selenium.WebDriver;

import commonLibs.implementation.CommonDriver;
import commonLibs.implementation.DropdownControl;
import commonLibs.implementation.ElementControls;
import designPattern.AmazonPOM1Style;
import designPattern.AmazonPOM2Style;
import designPattern.AmazonPageFactory;

public class DemoAmazonPageFactory {

	public static void main(String[] args) throws Exception{
		
		String url = "http://www.amazon.in";
		
		CommonDriver cmnDriver = new CommonDriver("chrome");
		
		cmnDriver.setPageLoadTimeout(30);

		cmnDriver.setElementDetectionTimeout(10);
		
		cmnDriver.navigateToFirstUrl(url);
		
		WebDriver driver = cmnDriver.getDriver();
		
		
		AmazonPageFactory homepage = new AmazonPageFactory(driver);
		
		homepage.searchProduct("Apple Watch", "Watches");
		
		cmnDriver.closeAllBrowsers();
	}

}
