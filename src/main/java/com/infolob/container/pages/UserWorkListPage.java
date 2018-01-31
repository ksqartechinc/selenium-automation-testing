package main.java.com.infolob.container.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import main.java.com.infolob.container.common.utilities.StringExtraction;

public class UserWorkListPage {
	
	private WebDriver driver;
	private List<WebElement> workListRow;
	private List<WebElement> workListTable;
	
	public UserWorkListPage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public void goToPurchaseRequisitionPage(int requisitionNumber)
	{
		workListRow =  driver.findElements(By.xpath("//*[@id=\"NtfWorklist:Content\"]/tbody/tr"));
		
	 for(int i=1;i<workListRow.size();i++)
	 {
		 String xpath = "//*[@id=\"NtfWorklist:Content\"]/tbody/tr["+i+"]"+"/td[3]";
		 
		if(Integer.parseInt(StringExtraction.getStringAtIndex(workListRow.get(i).findElement(By.xpath(xpath)).getText(),2)) == requisitionNumber) {
			
			workListRow.get(i).findElement(By.xpath(xpath)).click();
			break;
		}else
		{
			System.out.println("Requisition not present in user's worklist, please try later");
		}
	 }
	}

}
