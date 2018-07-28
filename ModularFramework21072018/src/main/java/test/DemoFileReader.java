package test;

import java.util.Properties;

import utils.ReadConfigFileUtils;

public class DemoFileReader {
	
	public static void main(String[] args) throws Exception {
		
		String filename = System.getProperty("user.dir") + "/config/config.properties";
		Properties property = ReadConfigFileUtils.readProperties(filename);
		
		System.out.println(property.getProperty("browserType"));
		
		System.out.println(property.getProperty("baseUrl"));
	}

}
