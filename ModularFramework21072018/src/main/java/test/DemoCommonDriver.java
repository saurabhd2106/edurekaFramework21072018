package test;

import commonLibs.implementation.CommonDriver;

public class DemoCommonDriver {

	public static void main(String[] args) {
		try {

			CommonDriver cmnDriver = new CommonDriver("chrome");

			cmnDriver.setPageLoadTimeout(60);

			cmnDriver.setElementDetectionTimeout(3);

			cmnDriver.navigateToFirstUrl("http://www.ebay.in");

			System.out.println(cmnDriver.getTitle());

			cmnDriver.closeAllBrowsers();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
