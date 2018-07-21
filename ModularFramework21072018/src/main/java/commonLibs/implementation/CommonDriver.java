package commonLibs.implementation;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import commonLibs.contracts.Driver;

public class CommonDriver implements Driver {

	private WebDriver driver;
	private int pageLoadTimeout;
	private int elementDetectionTimeout;

	public CommonDriver(String browserType) throws Exception {
		browserType = browserType.trim();

		pageLoadTimeout = 20;
		elementDetectionTimeout = 5;

		if (browserType.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					"C:\\Users\\Saurabh Dhingra\\workspace\\libs\\chromeDriver36\\chromedriver.exe");

			driver = new ChromeDriver();

		} else if (browserType.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver",
					"C:\\Users\\Saurabh Dhingra\\workspace\\libs\\geckodriver-v0.20.1-win64\\geckodriver.exe");
			driver = new FirefoxDriver();

		} else if (browserType.equalsIgnoreCase("edge")) {
			System.setProperty("webdriver.edge.driver",
					"C:\\Users\\Saurabh Dhingra\\workspace\\libs\\MicrosoftWebDriver.exe");

			driver = new EdgeDriver();

		} else {
			throw new Exception("Invalid Browser type : " + browserType);
		}

		driver.manage().window().maximize();

		driver.manage().deleteAllCookies();
	}

	public WebDriver getDriver() {
		return driver;
	}

	public void setPageLoadTimeout(int pageLoadTimeout) {
		this.pageLoadTimeout = pageLoadTimeout;
	}

	public void setElementDetectionTimeout(int elementDetectionTimeout) {
		this.elementDetectionTimeout = elementDetectionTimeout;
	}

	@Override
	public void navigateToFirstUrl(String url) throws Exception {

		url = url.trim();

		driver.manage().timeouts().pageLoadTimeout(pageLoadTimeout, TimeUnit.SECONDS);

		driver.manage().timeouts().implicitlyWait(elementDetectionTimeout, TimeUnit.SECONDS);

		driver.get(url);
	}

	@Override
	public String getTitle() throws Exception {

		return driver.getTitle();
	}

	@Override
	public String getCurrentUrl() throws Exception {

		return driver.getCurrentUrl();
	}

	@Override
	public String getPageSource() throws Exception {

		return driver.getPageSource();
	}

	@Override
	public void navigateToUrl(String url) throws Exception {

		url = url.trim();
		driver.navigate().to(url);

	}

	@Override
	public void navigateForward() throws Exception {
		driver.navigate().forward();

	}

	@Override
	public void navigateBackward() throws Exception {
		driver.navigate().back();

	}

	@Override
	public void refresh() throws Exception {
		driver.navigate().refresh();

	}

	@Override
	public void closeBrowser() throws Exception {
		if(driver !=null){
			driver.close();
		}

	}

	@Override
	public void closeAllBrowsers() throws Exception {
		if(driver != null){
			driver.quit();
		}

	}

}
