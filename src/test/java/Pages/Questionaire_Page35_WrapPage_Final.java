package Pages;


import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.Properties;
import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import ExtentReports.CaptureScreens;


public class Questionaire_Page35_WrapPage_Final {
	WebDriver driver;
	public ExtentReports report;
	public ExtentTest test;
	CaptureScreens Shot;
	static Properties props = new Properties();
	static String propsFilepath = "/src/test/resources/Config.properties";
	
	// Object Repositories 
		
		@FindBy(xpath = "//div[text()='ACCOUNTS']")
		WebElement AboutYouTitle;
		
		@FindBy(xpath = "//div[contains(text(),'Anything else before we wrap up?')]")
		WebElement FinalScreenBeforeWrap_Label;
		
		@FindBy(xpath = "//div[contains(text(),'For example, moving or switching jobs soon, any additional questions.')]")
		WebElement FinalScreenBeforeWrap_Sub_Label;
		
		@FindBy(xpath = "//div[contains(text(),'For example, moving or switching jobs soon, any additional questions.')]//following :: textarea")
		WebElement FinalScreenBeforeWrap_TextArea;
		
		
		
		@FindBy(xpath = "//button//div[text()='Submit']")
		WebElement Submit_Button;
		
		
		
		
	
	// End of Object Repositories 
	
	
	public Questionaire_Page35_WrapPage_Final(WebDriver driver,ExtentReports report,ExtentTest test) throws IOException
	{
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + propsFilepath);
		props.load(fis);
		Shot = new CaptureScreens(driver);
		this.driver = driver;
		this.report = report;
		this.test = test;
		PageFactory.initElements(driver, this);
		
	}
	
	public void Questionaire_WrapPage_Final() throws IOException, InterruptedException
	{
		
		Thread.sleep(4000);
		// Page Title
		if(AboutYouTitle.isDisplayed())
		{
			test.log(LogStatus.PASS,test.addScreenCapture(Shot.CaptureScreen())+ "Page Title is Available");
		}
		else
		{
			test.log(LogStatus.FAIL,test.addScreenCapture(Shot.CaptureScreen())+ "Page Title is NOT Available");
		}
		
		// FinalScreen BeforeWrap Label
		if(FinalScreenBeforeWrap_Label.isDisplayed())
		{
			test.log(LogStatus.PASS,test.addScreenCapture(Shot.CaptureScreen())+ "FinalScreen BeforeWrap label is Available");
		}
		else
		{
			test.log(LogStatus.FAIL,test.addScreenCapture(Shot.CaptureScreen())+ "FinalScreen BeforeWrap Label is NOT Available");
		}
		
		// FinalScreen BeforeWrap Sub Label
		if(FinalScreenBeforeWrap_Sub_Label.isDisplayed())
		{
			test.log(LogStatus.PASS,test.addScreenCapture(Shot.CaptureScreen())+ "FinalScreen BeforeWrap Sub Label is Available");
		}
		else
		{
			test.log(LogStatus.FAIL,test.addScreenCapture(Shot.CaptureScreen())+ "FinalScreen BeforeWrap Sub Label is NOT Available");
		}
		
		// FinalScreen BeforeWrap text area
		if(FinalScreenBeforeWrap_TextArea.isDisplayed())
		{
			test.log(LogStatus.PASS,test.addScreenCapture(Shot.CaptureScreen())+ "FinalScreen BeforeWrap Text Area is Available");
			FinalScreenBeforeWrap_TextArea.sendKeys(props.getProperty("FinalScreenBeforeWrapTextArea"));
		}
		else
		{
			test.log(LogStatus.FAIL,test.addScreenCapture(Shot.CaptureScreen())+ "FinalScreen BeforeWrap Text Area is NOT Available");
		}
		
		// Submit Button 
		if(Submit_Button.isDisplayed())
		{
			test.log(LogStatus.PASS,test.addScreenCapture(Shot.CaptureScreen())+ "Submit Button is Available");
			// Submit_Button.click();
		}
		else
		{
			test.log(LogStatus.FAIL,test.addScreenCapture(Shot.CaptureScreen())+ "Submit Button is NOT Available");
		}
	}
	
}
