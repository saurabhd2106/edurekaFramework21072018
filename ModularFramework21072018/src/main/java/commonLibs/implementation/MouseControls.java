package commonLibs.implementation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import commonLibs.contracts.MouseOperation;

public class MouseControls implements MouseOperation {

	private WebDriver driver;

	public MouseControls(WebDriver driver) {
		this.driver = driver;
	}

	private Actions getAction() {
		Actions action = new Actions(driver);

		return action;
	}

	@Override
	public void dragAndDrop(WebElement element1, WebElement element2) throws Exception {

		getAction().dragAndDrop(element1, element2).build().perform();
	}

	@Override
	public void moveToElement(WebElement element) throws Exception {
		getAction().moveToElement(element).build().perform();

	}

	@Override
	public void rightClick(WebElement element) throws Exception {

		getAction().contextClick(element).build().perform();

	}

	@Override
	public void doubleClick(WebElement element) throws Exception {
		getAction().doubleClick().build().perform();

	}

	@Override
	public void moveToElementAndClick(WebElement element) throws Exception {
		getAction().moveToElement(element).click().build().perform();

	}

}
