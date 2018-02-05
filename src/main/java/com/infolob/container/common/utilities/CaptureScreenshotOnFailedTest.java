package main.java.com.infolob.container.common.utilities;

import java.io.File;
import java.io.FileOutputStream;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;

public class CaptureScreenshotOnFailedTest {

	private WebDriver driver;
	public CaptureScreenshotOnFailedTest(WebDriver driver) {
		this.driver = driver;

	}

	public void captureScreenshotOnFailure(ITestResult result)
	{
		 String directory = "screenshots";
		
			try {
				new File(directory).mkdirs(); // Insure directory is there
				FileOutputStream out = new FileOutputStream(directory+"/"+ result.getName() + ".png");

				out.write(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES));
				out.close();

				System.out.println("Screenshot taken");
			} 
			catch (Exception e)
			{

				System.out.println("Exception while taking screenshot "+e.getMessage());
			} 


		}

	

}


