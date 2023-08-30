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


public class Questionaire_Page3_KidsInformation {
	WebDriver driver;
	public ExtentReports report;
	public ExtentTest test;
	CaptureScreens Shot;
	static Properties props = new Properties();
	static String propsFilepath = "/src/test/resources/Config.properties";
	
	// Object Repositories 
		
		@FindBy(xpath = "//div[text()='ABOUT YOU']")
		WebElement AboutYouTitle;
		
		@FindBy(xpath = "//div[text()='Tell us about your kid(s)']")
		WebElement Questionaire_Page3_Title;
		
		@FindBy(xpath = "//div[contains(text(),'How many do you have?')]")
		WebElement KidsNumbers_Label;
		
		@FindBy(xpath = "//input[@type='number']")
		WebElement KidsNumbers_Entry;
		
		@FindBy(xpath = "//div[contains(text(),'How old are they?')]")
		WebElement KidsAge_Label;
		
		@FindBy(xpath = "//input[@type='text']")
		WebElement KidsAge_Entry;
		
		@FindBy(xpath = "//button//div[text()='Save and continue']")
		WebElement Save_Continue_Button;
		
		
	
	// End of Object Repositories 
	
	
	public Questionaire_Page3_KidsInformation(WebDriver driver,ExtentReports report,ExtentTest test) throws IOException
	{
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + propsFilepath);
		props.load(fis);
		Shot = new CaptureScreens(driver);
		this.driver = driver;
		this.report = report;
		this.test = test;
		PageFactory.initElements(driver, this);
		
	}
	
	public void Questionaire_KidsInformation() throws IOException, InterruptedException
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
		
		// Page header Title
		if(Questionaire_Page3_Title.isDisplayed())
		{
			test.log(LogStatus.PASS,test.addScreenCapture(Shot.CaptureScreen())+ "Page header Title is Available");
		}
		else
		{
			test.log(LogStatus.FAIL,test.addScreenCapture(Shot.CaptureScreen())+ "Page header Title is NOT Available");
		}
		
		// Kids Numbers Label and Kids Numbers Entry
		if(KidsNumbers_Label.isDisplayed() && KidsNumbers_Entry.isDisplayed())
		{
			test.log(LogStatus.PASS,test.addScreenCapture(Shot.CaptureScreen())+ "Kids Entry Label and Field is Available");
			KidsNumbers_Entry.sendKeys(props.getProperty("KidsNumbers"));
		}
		else
		{
			test.log(LogStatus.FAIL,test.addScreenCapture(Shot.CaptureScreen())+ "Kids Entry Label and Field is NOT Available");
		}
		
		// Kids Age Label and Kids Ages Entry
		if(KidsAge_Label.isDisplayed() && KidsAge_Entry.isDisplayed())
		{
			test.log(LogStatus.PASS,test.addScreenCapture(Shot.CaptureScreen())+ "Kids Age Label and Entry Field is Available");
			KidsAge_Entry.sendKeys(props.getProperty("KidsAges"));
		}
		else
		{
			test.log(LogStatus.FAIL,test.addScreenCapture(Shot.CaptureScreen())+ "Kids Age Label and Entry Field is NOT Available");
		}
		
		// Save and Continue 
		if(Save_Continue_Button.isDisplayed())
		{
			test.log(LogStatus.PASS,test.addScreenCapture(Shot.CaptureScreen())+ "Save and Continue is Available");
			Thread.sleep(2000);
			Save_Continue_Button.click();
		}
		else
		{
			test.log(LogStatus.FAIL,test.addScreenCapture(Shot.CaptureScreen())+ "Save and Continue is NOT Available");
		}
		
	}
	
}
