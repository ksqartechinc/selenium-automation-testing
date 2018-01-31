package main.java.com.infolob.container.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
	
	private WebElement logout;
	private WebDriver driver;
	private WebElement taskListTable;
	
	
	public HomePage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}

	public void logout()
	{	
		logout = driver.findElement(By.cssSelector("img[title='Logout']"))	;
		logout.click();
	}
}
