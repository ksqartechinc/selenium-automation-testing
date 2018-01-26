package com.mycompany.app.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.mycompany.app.resources.Constants;

public class ProcurementShopPage {

	private WebElement stores;
	private WebElement shoppingList;
	private WebElement nonCatalogRequest;
	private WebElement contractorRequest;
	private WebDriver driver;
	
	public ProcurementShopPage(WebDriver driver)
	{
		this.driver = driver;
	}
	public WebElement getStores() {
		return stores;
	}
	public void setStores() {
		WebDriverWait wait = new WebDriverWait(driver,15);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id(Constants.SHOP_STORES)));
		stores = driver.findElement(By.id(Constants.SHOP_STORES));
		stores.click();
	}
	public WebElement getShoppingList() {
		return shoppingList;
	}
	public void setShoppingList() {
		WebDriverWait wait = new WebDriverWait(driver,15);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id(Constants.SHOP_SHOPPING_LIST)));
		shoppingList = driver.findElement(By.id(Constants.SHOP_SHOPPING_LIST));
//		shoppingList.click();
	}
	public WebElement getNonCatalogRequest() {
		return nonCatalogRequest;
	}
	public void setNonCatalogRequest() {
		WebDriverWait wait = new WebDriverWait(driver,15);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id(Constants.SHOP_NON_CATALOG_REQUEST)));
		nonCatalogRequest = driver.findElement(By.id(Constants.SHOP_NON_CATALOG_REQUEST));
		nonCatalogRequest.click();
	}
	public WebElement getContractorRequest() {
		return contractorRequest;
	}
	public void setContractorRequest() {
		WebDriverWait wait = new WebDriverWait(driver,15);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id(Constants.SHOP_CONTRACTOR_REQUEST)));
		contractorRequest = driver.findElement(By.id(Constants.SHOP_CONTRACTOR_REQUEST));
//		contractorRequest.click();
	}
	
	
}
