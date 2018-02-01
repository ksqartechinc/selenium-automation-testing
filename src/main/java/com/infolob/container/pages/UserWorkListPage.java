package main.java.com.infolob.container.pages;

import java.sql.Date;
import java.text.DateFormat;
import java.util.Calendar;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import main.java.com.infolob.container.common.utilities.StringExtraction;

public class UserWorkListPage {

	private WebDriver driver;
	private WebElement workListRow;
	private List<WebElement> workListTable;
	private WebElement approval;

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




