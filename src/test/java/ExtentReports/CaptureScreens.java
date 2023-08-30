package ExtentReports;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class CaptureScreens 
{
	
	WebDriver driver;
	public CaptureScreens(WebDriver driver) 
	{
		this.driver = driver;

	}
	public String CaptureScreen() throws IOException
	{

		  String destpath =System.getProperty("user.dir")+"//Reports//Test-ScreenShots//Test-ScreenShots"+System.currentTimeMillis()+".png";
	    TakesScreenshot screen = (TakesScreenshot) driver;
	    File src = screen.getScreenshotAs(OutputType.FILE);
	    File DestinationFile = new File(destpath);
	    
		  String AbsolutePath_Screen = DestinationFile.getAbsolutePath(); // Without Absolutepath Images will not clear
			
	  //  File target = new File(dest);
		  FileUtils.copyFile(src, DestinationFile);
	    return AbsolutePath_Screen;
	}

}
