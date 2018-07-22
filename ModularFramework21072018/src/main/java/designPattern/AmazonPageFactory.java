package designPattern;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commonLibs.implementation.DropdownControl;
import commonLibs.implementation.ElementControls;

public class AmazonPageFactory {

	@CacheLookup
	@FindBy(id="twotabsearchtextbox")
	private WebElement searchBox;

	@CacheLookup
	@FindBy(id="searchDropdownBox")
	private WebElement searchCat;

	@CacheLookup
	@FindBy(xpath="//input[@value='Go']")
	private WebElement searchButton;
	
	@FindBy(id="s-result-count")
	private WebElement result;
	
	private ElementControls elementControl;
	
	private DropdownControl dropdown;

	public AmazonPageFactory(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
		elementControl = new ElementControls();
		
		dropdown = new DropdownControl();
	}
	
	public void searchProduct(String product, String category) throws Exception{
		elementControl.setText(searchBox, product);
		
		dropdown.selectViaVisibleText(searchCat, category);
		
		elementControl.click(searchButton);
		
		String sResult = elementControl.getText(result);
		
		System.out.println(sResult);
	}

}
