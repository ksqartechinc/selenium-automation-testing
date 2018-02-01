package test.java.com.infolob.container.test;

import java.net.MalformedURLException;
import java.net.URL;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Properties;

import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.RemoteWebDriver;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import main.java.com.infolob.container.dataprovider.NonCatalogRequestDataProvider;
import main.java.com.infolob.container.pages.HomePage;
import main.java.com.infolob.container.pages.LeftMenu;
import main.java.com.infolob.container.pages.LoginPage;
import main.java.com.infolob.container.pages.ProcurementShopPage;
import main.java.com.infolob.container.resources.Constants;
import main.java.com.infolob.container.workflows.BrowserLeftMenu;
import main.java.com.infolob.container.workflows.NonCatalogRequestPageActions;
import main.java.com.infolob.container.workflows.POStatus;

 // extent-report
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.ExtentTestInterruptedException;
import com.relevantcodes.extentreports.LogStatus;

public class BasicFlow {
	// extent-report
	public ExtentReports extent;
	public ExtentTest test;
	public ExtentTestInterruptedException testexception;

	private	WebDriver driver;
	private String URL = "http://infoebs02.infolob.com:8000";
	private LoginPage lp;
	private LeftMenu lm ;
	private BrowserLeftMenu blm;
	private NonCatalogRequestPageActions ncrpAction;
	private ProcurementShopPage psp;
	private HomePage homePage;
	private POStatus poStatus;

	@BeforeSuite
	public void setUp(){
			try {
				String workingDir = System.getProperty("user.dir");
				System.out.println("Current working directory : " + workingDir);

				extent = new ExtentReports(workingDir+"/Test_Execution_Report.html", true);
				extent.loadConfig(new File(workingDir+"/extent-config.xml"));
				extent.addSystemInfo("Environment","QA");

					ChromeOptions options = new ChromeOptions();
					options.setCapability(CapabilityType.SUPPORTS_ALERTS, true);
					options.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.ACCEPT);
					options.setUnhandledPromptBehaviour(UnexpectedAlertBehaviour.ACCEPT);
					options.addArguments("disable-popup-blocking");


			    driver = new RemoteWebDriver(new URL("http://192.168.7.121:4444/wd/hub"), options);
					driver.get(URL);
			    //more code goes here
			} catch(MalformedURLException ex){
			//do exception handling here
			}
	}

	@Test
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

		test.log(LogStatus.PASS, "QABot");
	}

	//Following test is an approval path

	// @Parameters({"username","password","approver","appPassword"})
	// @Test()
	// public void Test002(String username,String password, String approver, String appPassword) throws InterruptedException
	// {
	// 	lp = new LoginPage(driver);
	// 	lp.login( username ,password);
	// 	lm = new LeftMenu(driver);
	// 	blm = new  BrowserLeftMenu(lm);
	// 	blm.navigateToItem(Constants.IPROCUREMENT);
	// 	psp = new ProcurementShopPage(driver);
	// 	psp.setNonCatalogRequest();
	// 	ncrpAction = new NonCatalogRequestPageActions(driver,NonCatalogRequestDataProvider.getNCRObject(1));
	// 	ncrpAction.performAction("input data");
	// 	ncrpAction.performAction("addToCart");
	// 	ncrpAction.performAction("view cart");
	// 	ncrpAction.performAction("submit");
  //
  //
	// 	try {
	// 		Thread.sleep(10000);
	// 	} catch (InterruptedException e) {
	// 		// TODO Auto-generated catch block
	// 		e.printStackTrace();
	// 	}
	// 	//	  assertTrue(lm.isLeftMenuPresent(), "Could not find left menu");
	// 	homePage = new HomePage(driver);
	// 	homePage.logout();
  //
  //
  //
	// 	try {
	// 		Thread.sleep(30000);
	// 	} catch (InterruptedException e) {
	// 		// TODO Auto-generated catch block
	// 		e.printStackTrace();
	// 	}
	// 	lp.login(approver, appPassword);
	// 	try {
	// 		Thread.sleep(15000);
	// 	} catch (InterruptedException e) {
	// 		// TODO Auto-generated catch block
	// 		e.printStackTrace();
	// 	}
	// 	poStatus =  new POStatus(driver);
	// 	poStatus.changePurchaseRequisitionStatus(Constants.SW_APPROVE);
  //
	// 	try {
	// 		Thread.sleep(10000);
	// 	} catch (InterruptedException e) {
	// 		// TODO Auto-generated catch block
	// 		e.printStackTrace();
	// 	}
  //
	// 	homePage = new HomePage(driver);
	// 	homePage.logout();
	// 	try {
	// 		Thread.sleep(10000);
	// 	} catch (InterruptedException e) {
	// 		// TODO Auto-generated catch block
	// 		e.printStackTrace();
	// 	}
	// }

	@BeforeMethod
	public void BeforeMethod(Method method){
		test = extent.startTest( (this.getClass().getSimpleName() +" :: "+  method.getName()),method.getName());
		test.assignAuthor("QABot");
		test.assignCategory("Environment","QA");
	}


	@AfterMethod
	public void AfterMethod(){
		extent.endTest(test);
	}

	@AfterSuite
	public void AfterSuite(){
		extent.flush();
		extent.close();
	}

	@AfterTest
	void tearDown()
	{
		driver.quit();
	}

}
