package test.java.com.infolob.container.test;


import static org.testng.Assert.assertTrue;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

// extent-report
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.ExtentTestInterruptedException;
import com.relevantcodes.extentreports.LogStatus;

import main.java.com.infolob.container.common.utilities.CaptureScreenshotOnFailedTest;
import main.java.com.infolob.container.dataprovider.NonCatalogRequestDataProvider;
import main.java.com.infolob.container.pages.HomePage;
import main.java.com.infolob.container.pages.LeftMenu;
import main.java.com.infolob.container.pages.LoginPage;
import main.java.com.infolob.container.pages.OrderConfirmationPage;
import main.java.com.infolob.container.pages.ProcurementShopPage;
import main.java.com.infolob.container.pages.PurchaseOrderDetailPage;
import main.java.com.infolob.container.resources.Constants;
import main.java.com.infolob.container.workflows.BrowserLeftMenu;
import main.java.com.infolob.container.workflows.NonCatalogRequestPageActions;
import main.java.com.infolob.container.workflows.POStatus;


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
	private OrderConfirmationPage orderConfirmation;
	private PurchaseOrderDetailPage purchaseOrderDetailPage;
	@BeforeSuite
	public void setUp(){
		
				
		System.setProperty("webdriver.chrome.driver","C:\\Users\\aseem\\Documents\\Chrome drivers\\Chrome 2.35\\chromedriver_win32 (1)\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(URL);
		

	}
	@Test
	public void incorrectLogin()
	{
		lp = new LoginPage(driver);
		lp.login("aseema31", "password");
		lm = new LeftMenu(driver);


		assertTrue(lm.isLeftMenuPresent());
	}

	@Test(enabled = false)
	@Parameters({"username","password"})
	public void Test001(String username,String password) throws InterruptedException {
		lp = new LoginPage(driver);
		lp.login(username, password);
		test.log(LogStatus.INFO, "Loged into to webapp");

		lm = new LeftMenu(driver);
		blm = new  BrowserLeftMenu(lm);

		test.log(LogStatus.INFO, "Navigating to IPROCUREMENT");
		blm.navigateToItem(Constants.IPROCUREMENT);
		psp = new ProcurementShopPage(driver);
		psp.setNonCatalogRequest();

		ncrpAction = new NonCatalogRequestPageActions(driver,NonCatalogRequestDataProvider.getNCRObject(0));

		test.log(LogStatus.INFO, "input data");
		ncrpAction.performAction("input data");

		test.log(LogStatus.INFO, "addToCart");
		ncrpAction.performAction("addToCart");

		test.log(LogStatus.INFO, "view cart");
		ncrpAction.performAction("view cart");

		test.log(LogStatus.INFO, "submit");
		ncrpAction.performAction("submit");


		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		homePage = new HomePage(driver);
		homePage.logout();
		test.log(LogStatus.INFO, "Logout");

		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		test.log(LogStatus.PASS, "QABot");
	}

	//Following test is an approval path

	@Parameters({"username","password","approver","appPassword"})
	@Test(enabled = false)
	public void Test002(String username,String password, String approver, String appPassword) throws InterruptedException 
	{
		lp = new LoginPage(driver);
		lp.login( username ,password);
		lm = new LeftMenu(driver);
		blm = new  BrowserLeftMenu(lm);

		test.log(LogStatus.INFO, "Navigating to IPROCUREMENT");
		blm.navigateToItem(Constants.IPROCUREMENT);

		psp = new ProcurementShopPage(driver);
		psp.setNonCatalogRequest();
		ncrpAction = new NonCatalogRequestPageActions(driver,NonCatalogRequestDataProvider.getNCRObject(1));

		test.log(LogStatus.INFO, "input data");
		ncrpAction.performAction("input data");

		test.log(LogStatus.INFO, "addToCart");
		ncrpAction.performAction("addToCart");

		test.log(LogStatus.INFO, "view cart");
		ncrpAction.performAction("view cart");

		test.log(LogStatus.INFO, "submit");
		ncrpAction.performAction("submit");

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//Obtain order confirmation Number
		test.log(LogStatus.INFO, "Getting order confirmation Number");
		orderConfirmation = new OrderConfirmationPage(driver);
		int orderConfirmationNumber = orderConfirmation.getRequisitionNumber();

		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		test.log(LogStatus.INFO, "Loging out");
		homePage = new HomePage(driver);
		homePage.logout();

		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//Login as Approver

		test.log(LogStatus.INFO, "Login as Approver");


		lp.login(approver, appPassword);

		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		poStatus =  new POStatus(driver);
		poStatus.changePurchaseRequisitionStatus(16033,Constants.SW_APPROVE);

		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		test.log(LogStatus.INFO, "Loging out");

		purchaseOrderDetailPage = new PurchaseOrderDetailPage(driver);
		this.purchaseOrderDetailPage.changepurchaseRequisitionStatus(Constants.SW_APPROVE);

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

		test.log(LogStatus.INFO, "Login as opertations");
		lp.login(username, password);
		lp.login(username, password);

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		poStatus.navigateToRequisitionDetailsPage(16028);

		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		homePage = new HomePage(driver);
		homePage.logout();

		test.log(LogStatus.INFO, "Loging out");
		test.log(LogStatus.PASS, "QABot");
	}

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



		
	@AfterMethod 					 
	void tearDown(ITestResult result)
	{
		if(result.getStatus() == ITestResult.FAILURE)
		{
			CaptureScreenshotOnFailedTest captureScreenshotOnFailedTest  = new CaptureScreenshotOnFailedTest(driver  );
			captureScreenshotOnFailedTest.captureScreenshotOnFailure(result);
		}

	}

	@AfterClass
	void afterClass()

	{
		driver.quit();
	}

}
