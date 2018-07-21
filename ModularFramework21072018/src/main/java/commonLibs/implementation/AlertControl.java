package commonLibs.implementation;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;

import commonLibs.contracts.Alerts;

public class AlertControl implements Alerts {

	private WebDriver driver;

	public AlertControl(WebDriver driver) {
		this.driver = driver;
	}

	private Alert getAlert() {
		Alert alert = driver.switchTo().alert();

		return alert;
	}

	@Override
	public void acceptAlert() throws Exception {

		getAlert().accept();
	}

	@Override
	public void rejectAlert() throws Exception {
		getAlert().dismiss();
	}

	@Override
	public String getMessageFromAlert() throws Exception {

		return getAlert().getText();
	}

	@Override
	public boolean isAlertPresent(int timeoutInSeconds) throws Exception {

		return false;
	}

}
