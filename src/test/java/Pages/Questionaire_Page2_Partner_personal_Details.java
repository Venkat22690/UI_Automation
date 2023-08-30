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


public class Questionaire_Page2_Partner_personal_Details {
	WebDriver driver;
	public ExtentReports report;
	public ExtentTest test;
	CaptureScreens Shot;
	static Properties props = new Properties();
	static String propsFilepath = "/src/test/resources/Config.properties";
	
	// Object Repositories 
	
			@FindBy(xpath = "//div[text()='ABOUT YOU']")
			WebElement AboutYouTitle;
			
			@FindBy(xpath = "//div[text()='Tell us about your partner']")
			WebElement Questionaire_Page2_Title;
			
			@FindBy(xpath = "//input[@label='Name']")
			WebElement PartnerName;
			
			@FindBy(xpath = "//input[@type='number']")
			WebElement PartnerYear;
			
			@FindBy(xpath = "//input[@label='Email']")
			WebElement EmailEntry;
			
			@FindBy(xpath = "//div[contains(text(),'If they want to be in the loop')]")
			WebElement Email_ExtraLabel;
			
			@FindBy(xpath = "//div[contains(text(),'Are they employed?')]")
			WebElement Employed_Label;
			
			@FindBy(xpath = "//div[text()='Yes']//preceding-sibling :: img")
			WebElement Employed_Entry;
			
			@FindBy(xpath = "//div[contains(text(),'How do you file taxes?')]")
			WebElement FileTaxes_Label;
			
			@FindBy(xpath = "//div[text()='Jointly']//preceding-sibling :: img")
			WebElement FileTaxes_Entry;
			
			@FindBy(xpath = "//button//div[text()='Save and continue']")
			WebElement Save_Continue_Button;

		
		// End of Object Repositories 
			
			
	
	
	
	public Questionaire_Page2_Partner_personal_Details(WebDriver driver,ExtentReports report,ExtentTest test) throws IOException
	{
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + propsFilepath);
		props.load(fis);
		Shot = new CaptureScreens(driver);
		this.driver = driver;
		this.report = report;
		this.test = test;
		PageFactory.initElements(driver, this);
		
	}
	
	public void Questionaire_Partner_personal_Details() throws IOException, InterruptedException
	{
		Thread.sleep(4000);
		// page Title
		if(AboutYouTitle.isDisplayed())
		{
			test.log(LogStatus.PASS,test.addScreenCapture(Shot.CaptureScreen())+ "Page Title is Available");
		}
		else
		{
			test.log(LogStatus.FAIL,test.addScreenCapture(Shot.CaptureScreen())+ "Page Title is NOT Available");
		}
		
		// Questionaire Title
		if(Questionaire_Page2_Title.isDisplayed())
		{
			test.log(LogStatus.PASS,test.addScreenCapture(Shot.CaptureScreen())+ "Questionaire Title is Available");
		}
		else
		{
			test.log(LogStatus.FAIL,test.addScreenCapture(Shot.CaptureScreen())+ "Questionaire Page Title is NOT Available");
		}
		
		// Partner Name
		if(PartnerName.isDisplayed())
		{
			test.log(LogStatus.PASS,test.addScreenCapture(Shot.CaptureScreen())+ "Partner Name is Available");
			PartnerName.sendKeys(props.getProperty("PartnerName"));
		}
		else
		{
			test.log(LogStatus.FAIL,test.addScreenCapture(Shot.CaptureScreen())+ "Questionaire Page Title is NOT Available");
		}
		
		// Partner Birth Year
		if(PartnerYear.isDisplayed())
		{
			test.log(LogStatus.PASS,test.addScreenCapture(Shot.CaptureScreen())+ "Partner Birth Year is Available");
			PartnerYear.sendKeys(props.getProperty("PartnerYearofBirth"));
		}
		else
		{
			test.log(LogStatus.FAIL,test.addScreenCapture(Shot.CaptureScreen())+ "Partner Birth Year is NOT Available");
		}
		
		// Email Entry
		if(EmailEntry.isDisplayed() && Email_ExtraLabel.isDisplayed())
		{
			test.log(LogStatus.PASS,test.addScreenCapture(Shot.CaptureScreen())+ "Email Entry is Available");
			EmailEntry.sendKeys(props.getProperty("PartnerEmail"));
		}
		else
		{
			test.log(LogStatus.FAIL,test.addScreenCapture(Shot.CaptureScreen())+ "Email Entry is NOT Available");
		}
		
		// Employed
		if(Employed_Label.isDisplayed() && Employed_Entry.isDisplayed())
		{
			test.log(LogStatus.PASS,test.addScreenCapture(Shot.CaptureScreen())+ "Employed Label and Radio Option are Available");
			Employed_Entry.click();
		}
		else
		{
			test.log(LogStatus.FAIL,test.addScreenCapture(Shot.CaptureScreen())+ "Employed Label and Radio Option are NOT Available");
		}
		
		
		// File Taxes
		if(FileTaxes_Label.isDisplayed() && FileTaxes_Entry.isDisplayed())
		{
			test.log(LogStatus.PASS,test.addScreenCapture(Shot.CaptureScreen())+ "File Taxes Label and Radio Option are Available");
			FileTaxes_Entry.click();
		}
		else
		{
			test.log(LogStatus.FAIL,test.addScreenCapture(Shot.CaptureScreen())+ "File Taxes Label and Radio Option are NOT Available");
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
