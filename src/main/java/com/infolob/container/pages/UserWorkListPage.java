package main.java.com.infolob.container.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class UserWorkListPage {

	private WebDriver driver;
	private WebElement workListRow;


	public UserWorkListPage(WebDriver driver)
	{
		this.driver = driver;
	}

	public void goToPurchaseRequisitionPage(int requisitionNumber)
	{
		workListRow =  driver.findElement(By.xpath("//*[@id=\"NtfWorklist:Content\"]/tbody/tr[1]/td[3]"));
		System.out.println(workListRow.getText());
		workListRow.click();
	}

}




