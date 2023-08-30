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


public class Questionaire_Page12_Customer_CompanyDetails {
	WebDriver driver;
	public ExtentReports report;
	public ExtentTest test;
	CaptureScreens Shot;
	static Properties props = new Properties();
	static String propsFilepath = "/src/test/resources/Config.properties";
	
	// Object Repositories 
		
		@FindBy(xpath = "//div[text()='INCOME']")
		WebElement AboutYouTitle;
		
		@FindBy(xpath = "//div[contains(text(),'Tell us about your current role')]")
		WebElement CurrentRole_Label;
		
		@FindBy(xpath = "//input[@label='Company name']")
		WebElement CompanyName;
		
		@FindBy(xpath = "//input[@label='Current title']")
		WebElement CurrentTitle;
		
		@FindBy(xpath = "//input[@placeholder='Annual salary']")
		WebElement AnnualSalary;
		
		@FindBy(xpath = "//input[@placeholder='Annual cash bonus']")
		WebElement AnnualBonus;
		
		@FindBy(xpath = "//div[text()='This is self-employment income']//preceding:: img[1]")
		WebElement SelfEmployementSelection;
		
		@FindBy(xpath = "//button//div[text()='Save and continue']")
		WebElement Save_Continue_Button;
		
		
	
	// End of Object Repositories 
	
	
	public Questionaire_Page12_Customer_CompanyDetails(WebDriver driver,ExtentReports report,ExtentTest test) throws IOException
	{
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + propsFilepath);
		props.load(fis);
		Shot = new CaptureScreens(driver);
		this.driver = driver;
		this.report = report;
		this.test = test;
		PageFactory.initElements(driver, this);
		
	}
	
	public void Questionaire_Customer_CompanyDetails() throws IOException, InterruptedException
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
		
		// Current Role Title
		if(CurrentRole_Label.isDisplayed())
		{
			test.log(LogStatus.PASS,test.addScreenCapture(Shot.CaptureScreen())+ "Current Role Title is Available");
		}
		else
		{
			test.log(LogStatus.FAIL,test.addScreenCapture(Shot.CaptureScreen())+ "Current Role Title is NOT Available");
		}
		
		// Company Name Entry
		if(CompanyName.isDisplayed())
		{
			test.log(LogStatus.PASS,test.addScreenCapture(Shot.CaptureScreen())+ "Company Name Entry is Available");
			CompanyName.sendKeys(props.getProperty("CompanyName"));
		}
		else
		{
			test.log(LogStatus.FAIL,test.addScreenCapture(Shot.CaptureScreen())+ "Company Name Entry is NOT Available");
		}
		
		// Company Title Entry
		if(CurrentTitle.isDisplayed())
		{
			test.log(LogStatus.PASS,test.addScreenCapture(Shot.CaptureScreen())+ "Company Title Entry is Available");
			CurrentTitle.sendKeys(props.getProperty("CompanyTitle"));
		}
		else
		{
			test.log(LogStatus.FAIL,test.addScreenCapture(Shot.CaptureScreen())+ "Company Title Entry is NOT Available");
		}
		
		// Annual Salary Entry
		if(AnnualSalary.isDisplayed())
		{
			test.log(LogStatus.PASS,test.addScreenCapture(Shot.CaptureScreen())+ "Annual Salary Entry is Available");
			AnnualSalary.sendKeys(props.getProperty("AnnualSalary"));
		}
		else
		{
			test.log(LogStatus.FAIL,test.addScreenCapture(Shot.CaptureScreen())+ "Annual Salary Entry is NOT Available");
		}
		
		// Annual Bonus Entry
		if(AnnualBonus.isDisplayed())
		{
			test.log(LogStatus.PASS,test.addScreenCapture(Shot.CaptureScreen())+ "Annual Bonus Entry is Available");
			AnnualBonus.sendKeys(props.getProperty("AnnualBonus"));
		}
		else
		{
			test.log(LogStatus.FAIL,test.addScreenCapture(Shot.CaptureScreen())+ "Annual Bonus Entry is NOT Available");
		}
		
		// SelfEmployement Selection Checkbox
		if(SelfEmployementSelection.isDisplayed())
		{
			test.log(LogStatus.PASS,test.addScreenCapture(Shot.CaptureScreen())+ "Self Employement Selection CheckBox is Available");
			// SelfEmployementSelection.click();
		}
		else
		{
			test.log(LogStatus.FAIL,test.addScreenCapture(Shot.CaptureScreen())+ "Self Employement Selection CheckBox is NOT Available");
		}
		
		// Save and Continue 
		if(Save_Continue_Button.isDisplayed())
		{
			test.log(LogStatus.PASS,test.addScreenCapture(Shot.CaptureScreen())+ "Save and Continue is Available");
			Save_Continue_Button.click();
		}
		else
		{
			test.log(LogStatus.FAIL,test.addScreenCapture(Shot.CaptureScreen())+ "Save and Continue is NOT Available");
		}
	}
	
}
