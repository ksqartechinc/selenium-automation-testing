package com.mycompany.app.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.mycompany.app.resources.Constants;

public class LoginPage {

 private WebDriver driver;
 
 private WebElement userTextBox;
 private WebElement passwordTextBox; 
 
 private WebElement submitButton;
 public LoginPage(WebDriver driver)
 {
	 this.driver = driver;
 }
 
 private void setUserName(String userName)
 {
	 WebDriverWait wait = new WebDriverWait(driver,15);
	 wait.until(ExpectedConditions.presenceOfElementLocated(By.id(Constants.ID_USERNAME)));
	 userTextBox = driver.findElement(By.id(Constants.ID_USERNAME));
	 userTextBox.sendKeys(userName);
 }
 
 private void setPassword(String password)
 {
	
	 passwordTextBox = driver.findElement(By.id(Constants.ID_PASSOWRD));
	 passwordTextBox.sendKeys(password);
 }
 
 private void submitLogin()
 {
	 submitButton = driver.findElement(By.cssSelector(Constants.ID_SUBMITLOGIN));
	 submitButton.click();
 }
 public void login(String userName, String password)
 {
	 setUserName(userName);
	 setPassword(password);
	 submitLogin();
 }
}
