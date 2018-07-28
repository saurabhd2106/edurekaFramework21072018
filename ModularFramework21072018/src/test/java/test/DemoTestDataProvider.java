package test;

import org.testng.annotations.Test;

import utils.TestDataProvider;

public class DemoTestDataProvider {
	
	@Test(dataProvider="getData", dataProviderClass=TestDataProvider.class)
	public void printTestData(String emailId, String password){
	
		System.out.println(emailId);
		System.out.println(password);
	}

}
