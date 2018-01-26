package com.mycompany.app.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.mycompany.app.resources.Constants;

public class ShoppingCartModal {
	
	private WebDriver driver;
	private WebElement description;
	private WebElement justification;
	private WebElement needByDate;
	private WebElement deliveryToLocation;
	private WebElement deleteRequest;
	private WebElement submitRequest;
	private WebElement editRequest;
	private WebElement saveRequest;
	private WebElement continueShopping;
	

	public void setDescription(String description) {
		this.description = driver.findElement(By.id(Constants.SHOPPING_CART_DESCRIPTION));
		this.description.sendKeys(description);
	}

	public void setJustification( String justification) {
	
		this.justification = driver.findElement(By.id(Constants.SHOPPING_CART_JUSTIFICATION));
		this.justification.sendKeys(justification);
	}

	public void setNeedByDate(String date ) {
		this.needByDate = driver.findElement(By.id(Constants.SHOPPING_CART_NEED_BY_DATE));
		this.needByDate.sendKeys(date);
	}

	public void setDeliveryToLocation(String location ) {
		this.deliveryToLocation = driver.findElement(By.id(Constants.SHOPPING_CART_DELIVER_TO_LOCATION));
		this.deliveryToLocation.sendKeys(location);
	}

	public void setDeleteRequest( ) {
		this.deleteRequest =   driver.findElement(By.id(Constants.SHOPPING_CART_DELETE));
		this.deleteRequest.click();
	}

	public void setSubmitRequest( ) {
		
		 WebDriverWait wait = new WebDriverWait(driver,15);
		 wait.until(ExpectedConditions.presenceOfElementLocated(By.id(Constants.SHOPPING_CART_SUBMIT)));
		this.submitRequest = driver.findElement(By.id(Constants.SHOPPING_CART_SUBMIT));
		this.submitRequest.click();
	}

	public void setEditRequest( ) {
		this.editRequest = driver.findElement(By.id(Constants.SHOPPING_CART_EDIT));
		this.editRequest.click();
	}

	public void setSaveRequest( ) {
		this.saveRequest =  driver.findElement(By.id(Constants.SHOPPING_CART_SAVE));
		this.saveRequest.click();
	}

	public void setContinueShopping( ) {
		this.continueShopping = driver.findElement(By.id(Constants.SHOPPING_CART_CONTINUE_SHOPPING));
		this.continueShopping.click();
	}

	public ShoppingCartModal(WebDriver driver)
	{
		this.driver = driver;
	}


}
