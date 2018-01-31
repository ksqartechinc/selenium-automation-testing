package main.java.com.infolob.container.workflows;

import org.openqa.selenium.WebDriver;

import main.java.com.infolob.container.objects.NonCatalogRequestObject;
import main.java.com.infolob.container.pages.NonCatalogRequestPage;

public class NonCatalogRequestPageActions {

	private NonCatalogRequestPage catalogRequestPage;
	private NonCatalogRequestObject catalogRequestObject;
	private WebDriver driver;

	public NonCatalogRequestPageActions(WebDriver driver,NonCatalogRequestObject catalogRequestObject) 
	{
		this.driver = driver;
		this.catalogRequestObject = catalogRequestObject;
	}
	private void inputInformation() {

		catalogRequestPage = new NonCatalogRequestPage(driver);
		catalogRequestPage.setItemDescription(catalogRequestObject.getItemDescription());
		catalogRequestPage.setCategory(catalogRequestObject.getCategory());//("SUPPLIES.OFFICE");
		catalogRequestPage.setQuantity(String.valueOf(catalogRequestObject.getQuantity()));
		catalogRequestPage.setUnitOfMeasure(catalogRequestObject.getUnitOfMeasure());
		catalogRequestPage.setUnitPrice(String.valueOf(catalogRequestObject.getUnitPrice()));
		catalogRequestPage.setCurrency("USD");
		
	}
	private  void clearAll()
	{
		catalogRequestPage.setClearAll();
	}

	private void addToCart() throws InterruptedException
	{
		Thread.sleep(10000);
		catalogRequestPage.setAddToCart();
	}

	public void performAction(String action) throws InterruptedException
	{
		switch (action) {
		case "input data" :
			inputInformation();
			break;
		case "clearAll":
			clearAll();
			break;
		case "addToCart":
			addToCart();
			break;
		case "view cart":
			try {
				viewCart();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		break;
		case "submit" :
			submit();
			break;
		default:
			break;
		}
	}
	
	
	
		private void submit() {

		// TODO Auto-generated method stub
		
		catalogRequestPage.shoppingCartSubmit();
		
	}
	private void viewCart() throws InterruptedException {
		// TODO Auto-generated method stub
		catalogRequestPage.setViewCartAndCheckout();
		
		Thread.sleep(10000);
		
	}
}
