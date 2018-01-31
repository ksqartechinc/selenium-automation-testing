package main.java.com.infolob.container.workflows;

import main.java.com.infolob.container.pages.LeftMenu;
import main.java.com.infolob.container.resources.Constants;

public class BrowserLeftMenu {
	
	private LeftMenu leftMenu;

	public BrowserLeftMenu(LeftMenu leftMenu)
	{
		this.leftMenu = leftMenu;
	}
	
	
	public void navigateToItem(String menuEntry) { 
		
		switch(menuEntry)
		{
		case "iProcurement":
		leftMenu.isLeftMenuPresent();
		leftMenu.navigateToElementInMenu(Constants.LT_IPROCUREMENT);
		break;
		case "" :
			
		break;
		default:
			System.out.println("Defaul executed");
		
		}
	}

	

}
