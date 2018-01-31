package main.java.com.infolob.container.workflows;

import javax.security.auth.login.LoginContext;

import org.openqa.selenium.WebDriver;

import main.java.com.infolob.container.pages.LoginPage;
import main.java.com.infolob.container.pages.PurchaseOrderDetailPage;
import main.java.com.infolob.container.pages.UserWorkListPage;
import main.java.com.infolob.container.resources.Constants;

public class POStatus {

	private UserWorkListPage userWorkListPage;
	private WebDriver driver;
	private LoginPage loginPage;
	private PurchaseOrderDetailPage purchaseOrderDetailPage;
	 
public POStatus(WebDriver driver)
{
	this.driver = driver;
	
}

public void loginAsUser(String username, String password)
{
	this.loginPage = new LoginPage(driver);
	this.loginPage.login(username, password);
}
public void  changePurchaseRequisitionStatus(int requisitionNumber,String action)
{
	
	this.userWorkListPage = new UserWorkListPage(driver);
	userWorkListPage.goToPurchaseRequisitionPage(requisitionNumber);
	
	purchaseRequisitionAction(action);
	
}

public void navigateToRequisitionDetailsPage(int requisitionNumber)
{
	this.userWorkListPage = new UserWorkListPage(driver);
	userWorkListPage.goToPurchaseRequisitionPage(requisitionNumber );
}
private void purchaseRequisitionAction(String action)
{
	this.purchaseOrderDetailPage = new PurchaseOrderDetailPage(driver);
	
	switch (action) {
	case Constants.SW_APPROVE:
		purchaseOrderDetailPage.approveRequisition();
		break;
	case Constants.SW_REJECT:
		purchaseOrderDetailPage.rejectRequisition();
		break;
	case Constants.SW_REASSIGN:
		purchaseOrderDetailPage.reAssign();
		break;
	case Constants.SW_APPROVE_AND_FORWARD:
		purchaseOrderDetailPage.approveAndForward();
		break;
	case Constants.SW_FORWARD:
		purchaseOrderDetailPage.forwardRequisition();
		break;
	case Constants.SW_REQUEST_INORMATION:
		purchaseOrderDetailPage.requestInformation();
		break;
		
	default:
		break;
	}
}
}
