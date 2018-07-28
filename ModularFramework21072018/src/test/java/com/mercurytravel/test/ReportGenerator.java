package com.mercurytravel.test;

import java.util.Properties;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import utils.DateUtils;
import utils.ReadConfigFileUtils;

public class ReportGenerator {
	public String currentProjectDirectory;
	private String testExecutionStartTime;

	public Properties configProperties;
	private String configFilename;

	public ExtentHtmlReporter htmlReporter;

	public ExtentReports extent;
	
	public ExtentTest test;

	@BeforeSuite
	public void initialSetup() throws Exception {
		currentProjectDirectory = System.getProperty("user.dir");
		testExecutionStartTime = DateUtils.getDate();

		configFilename = currentProjectDirectory + "/config/config.properties";
		configProperties = ReadConfigFileUtils.readProperties(configFilename);

		String reportName = String.format("%s\\reports\\%s%s.html", currentProjectDirectory,
				configProperties.getProperty("reportName"), testExecutionStartTime);
		System.out.println(reportName);
		htmlReporter = new ExtentHtmlReporter(reportName);
		
		extent = new ExtentReports();
		
		extent.attachReporter(htmlReporter);
	}
	
	@AfterSuite
	public void cleanup(){
		extent.flush();
	}

}
