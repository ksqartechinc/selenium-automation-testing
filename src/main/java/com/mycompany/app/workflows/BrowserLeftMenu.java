package com.mycompany.app.workflows;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.mycompany.app.pages.LeftMenu;
import com.mycompany.app.resources.Constants;

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
