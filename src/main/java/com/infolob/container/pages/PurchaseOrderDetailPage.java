package main.java.com.infolob.container.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import main.java.com.infolob.container.resources.Constants;

public class PurchaseOrderDetailPage {
	
	private WebDriver driver;
	private WebElement approve;
	private WebElement reject;
	private WebElement approveAndForward;
	private WebElement forward;
	private WebElement reAssign;
	private WebElement requestInformation;
	
 public PurchaseOrderDetailPage(WebDriver driver) {
	// TODO Auto-generated constructor stub
	 
	 this.driver = driver;
}
 private static String OS = null;
 public static String getOsName()
 {
    if(OS == null) { OS = System.getProperty("os.name"); }
    return OS;
 }
 public static boolean isWindows()
 {
    return getOsName().startsWith("Windows");
 }

 public void changepurchaseRequisitionStatus(String status)
 {
	WebElement table = driver.findElement(By.id("NtfDetailsControls"));
	WebElement btnTable =  table.findElement(By.id("pgBtnBarTbl"));
	List<WebElement> btns = btnTable.findElements(By.cssSelector("button[class='x80']"));
//	System.out.println(btns.size());
	for(WebElement btn:btns)
	{
//	System.out.println(btn.getText());
	}
	
	
	
	 switch (status) {
		case Constants.SW_APPROVE:
			btns.get(0).click();
			break;
		case Constants.SW_REJECT:
			btns.get(3).click();
			break;
		case Constants.SW_REASSIGN:
//			purchaseOrderDetailPage.reAssign();
			break;
		case Constants.SW_APPROVE_AND_FORWARD:
			btns.get(1).click();
			break;
		case Constants.SW_FORWARD:
//			purchaseOrderDetailPage.forwardRequisition();
			break;
		case Constants.SW_REQUEST_INORMATION:
			btns.get(1).click();
			break;
			
		default:
			break;
		}
 }

public void approveRequisition() {
	 WebDriverWait wait = new WebDriverWait(driver,15);
	 wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Constants.RP_APPROVE)));
	 this.approve = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(Constants.RP_APPROVE)));;
	 this.approve.click();
	 
}

public void rejectRequisition() {
	WebDriverWait wait = new WebDriverWait(driver,15);
	 wait.until(ExpectedConditions.presenceOfElementLocated(By.id(Constants.CSS_REJECT))); 
	this.reject = wait.until(ExpectedConditions.presenceOfElementLocated(By.id(Constants.CSS_REJECT)));;
	 this.reject.click();
}

public void approveAndForward() {
	WebDriverWait wait = new WebDriverWait(driver,15);
	 wait.until(ExpectedConditions.presenceOfElementLocated(By.id(Constants.CSS_APPROVE_AND_FORWARD)));
	this.approveAndForward = wait.until(ExpectedConditions.presenceOfElementLocated(By.id(Constants.CSS_APPROVE_AND_FORWARD)));;
	 this.approveAndForward.click();
}

public void forwardRequisition() {
	WebDriverWait wait = new WebDriverWait(driver,15);
	 wait.until(ExpectedConditions.presenceOfElementLocated(By.id(Constants.ID_FORWARD)));
	this.forward = wait.until(ExpectedConditions.presenceOfElementLocated(By.id(Constants.ID_FORWARD)));;
	 this.forward.click();
}

public void reAssign() {
	WebDriverWait wait = new WebDriverWait(driver,15);
	 wait.until(ExpectedConditions.presenceOfElementLocated(By.id(Constants.ID_REASSIGN)));
	 this.reAssign = wait.until(ExpectedConditions.presenceOfElementLocated(By.id(Constants.ID_REASSIGN)));;
	 this.reAssign.click();
	 }

public void requestInformation() {
	WebDriverWait wait = new WebDriverWait(driver,15);
	 wait.until(ExpectedConditions.presenceOfElementLocated(By.id(Constants.ID_REQUEST_INORMATION)));
	 this.requestInformation = wait.until(ExpectedConditions.presenceOfElementLocated(By.id(Constants.ID_REQUEST_INORMATION)));;
	 this.requestInformation.click();
	 }
 
}
