package com.mycompany.app.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.mycompany.app.resources.Constants;

public class NonCatalogRequestPage {

	private WebDriver driver;
	private Select itemType;
	private WebElement itemDescription;
	private WebElement category;
	private WebElement quantity;
	private WebElement unitOfMeasure;
	private WebElement unitPrice;
	private Select currency;
	private WebElement contractNumber;
	private WebElement isNewSupplier;
	private WebElement isRFQRequired;
	private WebElement isNegotiated;
	private WebElement SupplierName;
	private WebElement site;
	private WebElement contactName;
	private WebElement phone;
	private WebElement supplierItem;
	private WebElement clearAll;
	private WebElement addToCart;
	private WebElement addToFavourites; 
	private WebElement shoppingCart;
	private WebElement viewCartAndCheckout;


	private WebElement submitRequest;

	public WebElement getViewCartAndCheckout() {
		return viewCartAndCheckout;
	}
	public void setViewCartAndCheckout( ) {
		WebDriverWait wait = new WebDriverWait(driver,15);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id(Constants.NCR_VIEW_CART_AND_CHECKOUT)));
		this.viewCartAndCheckout = driver.findElement(By.id(Constants.NCR_VIEW_CART_AND_CHECKOUT));
		this.viewCartAndCheckout.click();

	}
	public NonCatalogRequestPage(WebDriver driver)
	{
		this.driver = driver;

	}
	public Select getItemType() {
		return itemType;
	}
	public void setItemType(int index) {
		WebDriverWait wait = new WebDriverWait(driver,15);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id(Constants.NCR_ITEM_TYPE)));
		this.itemType = new Select(driver.findElement(By.id(Constants.NCR_ITEM_TYPE)));
		this.itemType.selectByIndex(index);
	}
	public WebElement getItemDescription() {
		return itemDescription;
	}
	public void setItemDescription(String itemDescription) {
		this.itemDescription = driver.findElement(By.id(Constants.NCR_ITEM_DESCRIPTION));
		this.itemDescription.sendKeys(itemDescription);
	}
	public WebElement getCategory() {
		return category;
	}
	public void setCategory(String category) {
		WebDriverWait wait = new WebDriverWait(driver,15);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id(Constants.NCR_CATEGORY)));
		this.category = driver.findElement(By.id(Constants.NCR_CATEGORY));
		this.category.sendKeys(category);
	}
	public WebElement getQuantity() {
		return quantity;
	}
	public void setQuantity(String  quantity) {
		this.quantity = driver.findElement(By.id(Constants.NCR_QUANTITY));
		this.quantity.sendKeys(quantity);
	}
	public WebElement getUnitOfMeasure() {
		return unitOfMeasure;
	}
	public void setUnitOfMeasure(String unitOfMeasure) {
		WebDriverWait wait = new WebDriverWait(driver,15);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id(Constants.NCR_UNIT_OF_MEASURE)));
		this.unitOfMeasure = driver.findElement(By.id(Constants.NCR_UNIT_OF_MEASURE));
		this.unitOfMeasure.sendKeys(unitOfMeasure);
	}
	public WebElement getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(String unitPrice) {
		this.unitPrice = driver.findElement(By.id(Constants.NCR_UNIT_PRICE));
		this.unitPrice.sendKeys(unitPrice);
	}
	public Select getCurrency() {
		return currency;
	}
	public void setCurrency(String visibleText ) {

		itemType = new Select(driver.findElement(By.id(Constants.NCR_CURRENCY)));
		itemType.selectByVisibleText(visibleText);
	}
	public WebElement getContractNumber() {
		return contractNumber;
	}
	public void setContractNumber(WebElement contractNumber) {
		this.contractNumber = contractNumber;
	}
	public WebElement getIsNewSupplier() {
		return isNewSupplier;
	}
	public void setIsNewSupplier(WebElement isNewSupplier) {
		this.isNewSupplier = isNewSupplier;
	}
	public WebElement getIsRFQRequired() {
		return isRFQRequired;
	}
	public void setIsRFQRequired(WebElement isRFQRequired) {
		this.isRFQRequired = isRFQRequired;
	}
	public WebElement getIsNegotiated() {
		return isNegotiated;
	}
	public void setIsNegotiated(WebElement isNegotiated) {
		this.isNegotiated = isNegotiated;
	}
	public WebElement getSupplierName() {
		return SupplierName;
	}
	public void setSupplierName(WebElement supplierName) {
		SupplierName = supplierName;
	}
	public WebElement getSite() {
		return site;
	}
	public void setSite(WebElement site) {
		this.site = site;
	}
	public WebElement getContactName() {
		return contactName;
	}
	public void setContactName(WebElement contactName) {
		this.contactName = contactName;
	}
	public WebElement getPhone() {
		return phone;
	}
	public void setPhone(WebElement phone) {
		this.phone = phone;
	}
	public WebElement getSupplierItem() {
		return supplierItem;
	}
	public void setSupplierItem(WebElement supplierItem) {
		this.supplierItem = supplierItem;
	}
	public WebElement getClearAll() {
		return clearAll;
	}
	public void setClearAll( ) {
		clearAll = driver.findElement(By.id(Constants.NCR_CLEAR_ALL));
		clearAll.click();
	}
	public WebElement getAddToCart() {
		return addToCart;
	}
	public void setAddToCart( ) {
		WebDriverWait wait = new WebDriverWait(driver,15);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id(Constants.NCR_ADD_TO_CART)));
		this.addToCart = driver.findElement(By.id(Constants.NCR_ADD_TO_CART));
		addToCart.click();
	}
	public WebElement getAddToFavourites() {
		return addToFavourites;
	}
	public void setAddToFavourites(WebElement addToFavourites) {
		this.addToFavourites = addToFavourites;
	}
	public WebElement getShoppingCart() {
		return shoppingCart;
	}
	public void setShoppingCart(WebElement shoppingCart) {
		this.shoppingCart = shoppingCart;
	}

	public void getToShoppingcart()
	{
		driver.switchTo().frame(driver.findElement(By.cssSelector("#iframeShoppingCartPopup")));
		driver.switchTo().frame(driver.findElement(By.cssSelector("frame[title='Content']")));
	}
	public void shoppingCartSubmit()
	{
		//driver.switchTo().activeElement();
		
		WebDriverWait wait = new WebDriverWait(driver,15);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id(Constants.SHOPPING_CART_SUBMIT)));
		this.submitRequest = driver.findElement(By.cssSelector("img[title='Submit Requisition']"));
		this.submitRequest.click();
	}

}


