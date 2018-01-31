package main.java.com.infolob.container.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class OrderConfirmationPage {
	
 
	private  WebDriver driver;
	private  int requisitionNumber;
	private String approverName;
	
	private WebElement approverText;
	public OrderConfirmationPage(WebDriver driver) 
	{
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}
	private String setApproverText()
	{
		
		approverText = driver.findElement(By.id("ApproverText"));
		return approverText.getText();
		
	}
	public int getRequisitionNumber()
	{ 
		this.requisitionNumber = Integer.parseInt(getStringAtIndex(setApproverText(), 1));
			return this.requisitionNumber;
	}
	
	public String getApproverName()
	{
		String firstName ;
		String lastName ;
		lastName = getStringAtIndex(setApproverText(), 6);
		int length = lastName.length();
		lastName = lastName.substring(0, length-1);
		
		firstName =  getStringAtIndex(setApproverText(), 7);
		return approverName;
	}
	
	private String getStringAtIndex(String str, int index)
	{

		String[] stringArray = str.split(" ");
		return stringArray[index];
	}
	
}
