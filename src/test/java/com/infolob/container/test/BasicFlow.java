package test.java.com.infolob.container.test;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import main.java.com.infolob.container.dataprovider.NonCatalogRequestDataProvider;
import main.java.com.infolob.container.pages.HomePage;
import main.java.com.infolob.container.pages.LeftMenu;
import main.java.com.infolob.container.pages.LoginPage;
import main.java.com.infolob.container.pages.OrderConfirmationPage;
import main.java.com.infolob.container.pages.ProcurementShopPage;
import main.java.com.infolob.container.resources.Constants;
import main.java.com.infolob.container.workflows.BrowserLeftMenu;
import main.java.com.infolob.container.workflows.NonCatalogRequestPageActions;
import main.java.com.infolob.container.workflows.POStatus;



public class BasicFlow {
	private	WebDriver driver;
	private String URL = "http://infoebs02.infolob.com:8000";
	private LoginPage lp;
	private LeftMenu lm ;
	private BrowserLeftMenu blm;
	private NonCatalogRequestPageActions ncrpAction;
	private ProcurementShopPage psp;
	private HomePage homePage;
	private POStatus poStatus;
	private OrderConfirmationPage orderConfirmation;
	@BeforeSuite
	public void setUp(){

		try {

		     ChromeOptions options = new ChromeOptions();
		     options.setCapability(CapabilityType.SUPPORTS_ALERTS, true);
		     options.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.ACCEPT);
		     options.setUnhandledPromptBehaviour(UnexpectedAlertBehaviour.ACCEPT);
		     options.addArguments("disable-popup-blocking");


		       driver = new RemoteWebDriver(new URL("http://192.168.1.129:4444/wd/hub"), options);
		     driver.get(URL);
		       //more code goes here
		   } catch(MalformedURLException ex){
		   //do exception handling here
		   }
		
	}
	/*@Test
	@Parameters({"username","password"})
	public void Test001(String username,String password) throws InterruptedException {
		lp = new LoginPage(driver);
		lp.login(username, password);
		//	  System.out.println("In test Test001");
		lm = new LeftMenu(driver);
		blm = new  BrowserLeftMenu(lm);
		blm.navigateToItem(Constants.IPROCUREMENT);
		psp = new ProcurementShopPage(driver);
		psp.setNonCatalogRequest();
		ncrpAction = new NonCatalogRequestPageActions(driver,NonCatalogRequestDataProvider.getNCRObject(0));
		ncrpAction.performAction("input data");
		ncrpAction.performAction("addToCart");
		ncrpAction.performAction("view cart");
		ncrpAction.performAction("submit");
		

		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//	  assertTrue(lm.isLeftMenuPresent(), "Could not find left menu");
		homePage = new HomePage(driver);
		homePage.logout();

		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	*/
	//Following test is an approval path

	@Parameters({"username","password","approver","appPassword"})
	@Test()
	public void Test002(String username,String password, String approver, String appPassword) throws InterruptedException 
	{
		lp = new LoginPage(driver);
		lp.login( username ,password);
		lm = new LeftMenu(driver);
		blm = new  BrowserLeftMenu(lm);
		blm.navigateToItem(Constants.IPROCUREMENT);
		psp = new ProcurementShopPage(driver);
		psp.setNonCatalogRequest();
		ncrpAction = new NonCatalogRequestPageActions(driver,NonCatalogRequestDataProvider.getNCRObject(1));
		ncrpAction.performAction("input data");
		ncrpAction.performAction("addToCart");
		ncrpAction.performAction("view cart");
		ncrpAction.performAction("submit");
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//Obtain order confirmation Number
		orderConfirmation = new OrderConfirmationPage(driver);
		int orderConfirmationNumber = orderConfirmation.getRequisitionNumber();
	
		System.out.println(orderConfirmationNumber);
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//	  assertTrue(lm.isLeftMenuPresent(), "Could not find left menu");
		homePage = new HomePage(driver);
		homePage.logout();
		
		

		try {
			Thread.sleep(30000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//Login as Approver
		
		lp.login(approver, appPassword);
		
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		poStatus =  new POStatus(driver);
		poStatus.navigateToRequisitionDetailsPage(orderConfirmationNumber);
		poStatus.changePurchaseRequisitionStatus(orderConfirmationNumber,Constants.SW_APPROVE);
			
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		homePage = new HomePage(driver);
		homePage.logout();
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//Login as operations
		lp.login(username, password);
		
		try {
			Thread.sleep(15000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		poStatus.navigateToRequisitionDetailsPage(orderConfirmationNumber);
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		homePage = new HomePage(driver);
		homePage.logout();
		
	}

	@AfterTest  					 
	void tearDown()
	{
		driver.quit();
	}

}
