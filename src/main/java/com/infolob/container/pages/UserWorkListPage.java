package main.java.com.infolob.container.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class UserWorkListPage {
	
	private WebDriver driver;
	private WebElement workListItem;
	private WebElement workListTable;
	
	public UserWorkListPage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public void goToPurchaseRequisitionPage()
	{
		workListItem =  driver.findElement(By.xpath("//*[@id=\"NtfWorklist:Content\"]/tbody/tr[1]/td[3]"));
		System.out.println(workListItem.getText());
		workListItem.click();
	}

}
