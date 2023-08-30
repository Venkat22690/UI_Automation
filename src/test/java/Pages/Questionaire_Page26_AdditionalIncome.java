package Pages;


import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.Properties;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import ExtentReports.CaptureScreens;


public class Questionaire_Page26_AdditionalIncome {
	WebDriver driver;
	public ExtentReports report;
	public ExtentTest test;
	CaptureScreens Shot;
	static Properties props = new Properties();
	static String propsFilepath = "/src/test/resources/Config.properties";
	
	// Object Repositories 
		
		@FindBy(xpath = "//div[text()='INCOME']")
		WebElement AboutYouTitle;
		
		@FindBy(xpath = "//div[contains(text(),'Do you guys have any additional income?')]")
		WebElement AdditionalIncome_Label;
		
		@FindBy(xpath = "//input[@placeholder='Extra income this year']")
		WebElement AdditionalIncome_Entry;
		
		@FindBy(xpath = "//input[@placeholder='Details']")
		WebElement AdditionalIncome_Details_Entry;
		
		@FindBy(xpath = "//div[contains(text(),'Do you guys have any additional income?')]//following :: select")
		WebElement IncomeTaxed_dropDown;
		
		@FindBy(xpath = "//button//div[text()='Save and continue']")
		WebElement Save_Continue_Button;
		
		
		
	
	// End of Object Repositories 
	
	
	public Questionaire_Page26_AdditionalIncome(WebDriver driver,ExtentReports report,ExtentTest test) throws IOException
	{
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + propsFilepath);
		props.load(fis);
		Shot = new CaptureScreens(driver);
		this.driver = driver;
		this.report = report;
		this.test = test;
		PageFactory.initElements(driver, this);
		
	}
	
	public void Questionaire_AdditionalIncome() throws IOException, InterruptedException
	{
		Thread.sleep(3000);
		// Page Title
		if(AboutYouTitle.isDisplayed())
		{
			test.log(LogStatus.PASS,test.addScreenCapture(Shot.CaptureScreen())+ "Page Title is Available");
		}
		else
		{
			test.log(LogStatus.FAIL,test.addScreenCapture(Shot.CaptureScreen())+ "Page Title is NOT Available");
		}
		
		// Additional Income Label
		if(AdditionalIncome_Label.isDisplayed())
		{
			test.log(LogStatus.PASS,test.addScreenCapture(Shot.CaptureScreen())+ "Additional Income label is Available");
		}
		else
		{
			test.log(LogStatus.FAIL,test.addScreenCapture(Shot.CaptureScreen())+ "Additional Income label is NOT Available");
		}
		
		// Additional Income Entry
		if(AdditionalIncome_Entry.isDisplayed())
		{
			test.log(LogStatus.PASS,test.addScreenCapture(Shot.CaptureScreen())+ "Additional Income Entry is Available");
			AdditionalIncome_Entry.sendKeys(props.getProperty("AdditionalIncomeAmount"));
		}
		else
		{
			test.log(LogStatus.FAIL,test.addScreenCapture(Shot.CaptureScreen())+ "Additional Income Entry is NOT Available");
		}
		
		// Additional Income Details 
		if(AdditionalIncome_Details_Entry.isDisplayed())
		{
			test.log(LogStatus.PASS,test.addScreenCapture(Shot.CaptureScreen())+ "Additional Income Details is Available");
			AdditionalIncome_Details_Entry.sendKeys(props.getProperty("AdditionalIncomeDetailsEntry"));
		}
		else
		{
			test.log(LogStatus.FAIL,test.addScreenCapture(Shot.CaptureScreen())+ "Additional Income Details is NOT Available");
		}
		
		// Additional Income Dropdown Entry
		if(IncomeTaxed_dropDown.isDisplayed())
		{
			test.log(LogStatus.PASS,test.addScreenCapture(Shot.CaptureScreen())+ "Income Taxed Dropdown is Available");
			Select sc = new Select(IncomeTaxed_dropDown);
			IncomeTaxed_dropDown.click();
			sc.selectByValue(props.getProperty("AdditionalIncome_TaxdropDown"));
			
		}
		else
		{
			test.log(LogStatus.FAIL,test.addScreenCapture(Shot.CaptureScreen())+ "Income Taxed Dropdown is NOT Available");
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
