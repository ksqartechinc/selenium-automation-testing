package main.java.com.infolob.container.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class UserWorkListPage {

 private WebDriver driver;
 private WebElement workListRow;


 public UserWorkListPage(WebDriver driver)
 {
  this.driver = driver;
 }
 private static String OS = null;
 public static String getOsName()
 {
  if(OS == null) { OS = System.getProperty("os.name"); }
  return OS;
 }
 public static boolean isWindows()
 {
  return getOsName().startsWith("Windows");
 }

 public void goToPurchaseRequisitionPage(int requisitionNumber)
 {
  if(isWindows())
  {
   workListRow =  driver.findElement(By.xpath("//*[@id=\"NtfWorklist:Content\"]/tbody/tr[1]/td[3]"));
   System.out.println(workListRow.getText());
   workListRow.click();
  }else
  {
   workListRow =  driver.findElement(By.xpath("//*[@id=\"N41:NtfSubject:0\"]"));
   System.out.println(workListRow.getText());
   workListRow.click();
  }

 }

}
