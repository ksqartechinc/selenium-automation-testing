package main.java.com.infolob.container.pages;

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


public void approveRequisition() {
	 WebDriverWait wait = new WebDriverWait(driver,15);
	 wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(Constants.RP_APPROVE)));
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
