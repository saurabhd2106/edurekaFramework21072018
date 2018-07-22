package designPattern;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import commonLibs.implementation.DropdownControl;
import commonLibs.implementation.ElementControls;

public class AmazonPOM2Style {

	private WebElement searchBox;

	private WebElement searchCat;

	private WebElement searchButton;
	
	private WebElement result;
	
	private ElementControls elementControl;
	
	private DropdownControl dropdown;

	public AmazonPOM2Style(WebDriver driver) {
		searchBox = driver.findElement(By.id("twotabsearchtextbox"));

		searchCat = driver.findElement(By.id("searchDropdownBox"));

		searchButton = driver.findElement(By.xpath("//form[@class='nav-searchbar']//input[@value='Go']"));

		result = driver.findElement(By.id("s-result-count"));
		
		elementControl = new ElementControls();
		
		dropdown = new DropdownControl();
	}
	
	public void searchProduct(String product, String category) throws Exception{
		elementControl.setText(searchBox, product);
		
		dropdown.selectViaVisibleText(searchCat, category);
		
		elementControl.click(searchButton);
	}

}
