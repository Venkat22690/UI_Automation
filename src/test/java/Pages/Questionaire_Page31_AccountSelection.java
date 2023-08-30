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


public class Questionaire_Page31_AccountSelection {
	WebDriver driver;
	public ExtentReports report;
	public ExtentTest test;
	CaptureScreens Shot;
	static Properties props = new Properties();
	static String propsFilepath = "/src/test/resources/Config.properties";
	
	// Object Repositories 
		
		@FindBy(xpath = "//div[text()='ACCOUNTS']")
		WebElement AboutYouTitle;
		
		@FindBy(xpath = "//div[contains(text(),'Do you guys have any of the following?')]")
		WebElement ÁccountsSelection_Label;
		
		@FindBy(xpath = "//div[contains(text(),'In order to create a plan for the future, we need to understand where your finances are today.')]")
		WebElement ÁccountsSelection_Sub_Label;
		
		@FindBy(xpath = "//div[text()='Checking account']//preceding:: img[1]")
		WebElement CheckingAccount_Selection;
		
		@FindBy(xpath = "//div[text()='Mortgage loans']//preceding:: img[1]")
		WebElement MortageLoan_Selection;
		
		@FindBy(xpath = "//div[text()='Retirement accounts (401k, Roth IRA, HSA)']//preceding:: img[1]")
		WebElement RetirementAccount_Selection;
		
		@FindBy(xpath = "//div[text()='Anything else']")
		WebElement OtherAccountOption_Label;
		
		@FindBy(xpath = "//input[@placeholder='Enter any other financial accounts you have']")
		WebElement OtherAccountOption_Entry;
		
		
		@FindBy(xpath = "//button//div[text()='Save and continue']")
		WebElement Save_Continue_Button;
		
		
		
		
	
	// End of Object Repositories 
	
	
	public Questionaire_Page31_AccountSelection(WebDriver driver,ExtentReports report,ExtentTest test) throws IOException
	{
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + propsFilepath);
		props.load(fis);
		Shot = new CaptureScreens(driver);
		this.driver = driver;
		this.report = report;
		this.test = test;
		PageFactory.initElements(driver, this);
		
	}
	
	public void Questionaire_AccountSelection() throws IOException, InterruptedException
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
		
		// Account Selection
		if(ÁccountsSelection_Label.isDisplayed())
		{
			test.log(LogStatus.PASS,test.addScreenCapture(Shot.CaptureScreen())+ "Account Selection label is Available");
		}
		else
		{
			test.log(LogStatus.FAIL,test.addScreenCapture(Shot.CaptureScreen())+ "Account Selection label is NOT Available");
		}
		
		// Account Selection Sub Label
		if(ÁccountsSelection_Sub_Label.isDisplayed())
		{
			test.log(LogStatus.PASS,test.addScreenCapture(Shot.CaptureScreen())+ "Account Selection Sub Label is Available");
		}
		else
		{
			test.log(LogStatus.FAIL,test.addScreenCapture(Shot.CaptureScreen())+ "Account Selection Sub Label is NOT Available");
		}
		
		// Checking Account Selection
		if(CheckingAccount_Selection.isDisplayed())
		{
			test.log(LogStatus.PASS,test.addScreenCapture(Shot.CaptureScreen())+ "Checking Account Selection is Available");
			CheckingAccount_Selection.click();
		}
		else
		{
			test.log(LogStatus.FAIL,test.addScreenCapture(Shot.CaptureScreen())+ "Checking Account Selection is NOT Available");
		}
		
		// Mortage Loan Selection
		if(MortageLoan_Selection.isDisplayed())
		{
			test.log(LogStatus.PASS,test.addScreenCapture(Shot.CaptureScreen())+ "Mortage Loan Selection is Available");
			MortageLoan_Selection.click();
		}
		else
		{
			test.log(LogStatus.FAIL,test.addScreenCapture(Shot.CaptureScreen())+ "Mortage Loan Selection is NOT Available");
		}
		
		// Retirement Account Selection
		if(RetirementAccount_Selection.isDisplayed())
		{
			test.log(LogStatus.PASS,test.addScreenCapture(Shot.CaptureScreen())+ "Retirement Account Selection is Available");
			RetirementAccount_Selection.click();
		}
		else
		{
			test.log(LogStatus.FAIL,test.addScreenCapture(Shot.CaptureScreen())+ "Retirement Account Selection is NOT Available");
		}
		
		// Other Account Option Label
		if(OtherAccountOption_Label.isDisplayed())
		{
			test.log(LogStatus.PASS,test.addScreenCapture(Shot.CaptureScreen())+ "Other Account Label is Available");
		}
		else
		{
			test.log(LogStatus.FAIL,test.addScreenCapture(Shot.CaptureScreen())+ "Other Account Label is NOT Available");
		}
		
		// Other Account Option Label
		if(OtherAccountOption_Entry.isDisplayed())
		{
			test.log(LogStatus.PASS,test.addScreenCapture(Shot.CaptureScreen())+ "Other Account Entry is Available");
			OtherAccountOption_Entry.sendKeys(props.getProperty("OtherAccountName"));}
		else
		{
			test.log(LogStatus.FAIL,test.addScreenCapture(Shot.CaptureScreen())+ "Other Account Entry is NOT Available");
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
