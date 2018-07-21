package commonLibs.implementation;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import commonLibs.contracts.JavaScript;

public class JavascriptControl implements JavaScript {

	private WebDriver driver;

	public JavascriptControl(WebDriver driver) {
		this.driver = driver;
	}

	private JavascriptExecutor getJsEngine() {
		JavascriptExecutor jsEngine;
		jsEngine = (JavascriptExecutor) driver;

		return jsEngine;
	}

	@Override
	public void executeJavaScript(String scriptToExecute) throws Exception {

		getJsEngine().executeScript(scriptToExecute);

	}

	@Override
	public void scrollDown(int x, int y) throws Exception {

		String jsCommand = String.format("window.scrollBy(%d,%d)", x, y);
		getJsEngine().executeScript(jsCommand);

	}

	@Override
	public String executeJavaScriptWithReturnValue(String scriptToExecute) throws Exception {
		
		return getJsEngine().executeScript(scriptToExecute).toString();
	}

}
