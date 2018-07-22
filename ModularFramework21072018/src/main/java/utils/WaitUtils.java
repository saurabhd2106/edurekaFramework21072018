package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtils {
	private WebDriver driver;

	public WaitUtils(WebDriver driver) {
		this.driver = driver;
	}

	private WebDriverWait getWait(int timeOutInSeconds) {
		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		return wait;
	}

	public void waitTillElementPresent(WebElement element, int timeOutInSeconds) {

		getWait(timeOutInSeconds).until(ExpectedConditions.visibilityOf(element));
	}

	public void waitTillAlertIsPresent(int timeOutInSeconds) {
		getWait(timeOutInSeconds).until(ExpectedConditions.alertIsPresent());
	}

	public void waitTillElementIsClickable(WebElement element, int timeOutInSeconds) {
		getWait(timeOutInSeconds).until(ExpectedConditions.elementToBeClickable(element));
	}

	public void waitForSeconds(int timeOutInSeconds) throws Exception {
		Thread.sleep(timeOutInSeconds*1000);
	}
}
