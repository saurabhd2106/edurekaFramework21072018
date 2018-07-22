package designPattern;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AmazonPOM1Style {
	
	public WebElement searchBox;
	
	public WebElement searchCat;
	
	public WebElement searchButton;
	
	
	public AmazonPOM1Style(WebDriver driver) {
		searchBox = driver.findElement(By.id("twotabsearchtextbox"));
		
		searchCat = driver.findElement(By.id("searchDropdownBox"));
		
		searchButton = driver.findElement(By.xpath("//form[@class='nav-searchbar']//input[@value='Go']"));
		
		}

}
