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


public class Questionaire_Page20_PartnerStockOptions {
	WebDriver driver;
	public ExtentReports report;
	public ExtentTest test;
	CaptureScreens Shot;
	static Properties props = new Properties();
	static String propsFilepath = "/src/test/resources/Config.properties";
	
	// Object Repositories 
		
		@FindBy(xpath = "//div[text()='INCOME']")
		WebElement AboutYouTitle;
		
		@FindBy(xpath = "//div[contains(text(),'Does their job offer any of the following?')]")
		WebElement CompanyStockOffers_Label;
		
		@FindBy(xpath = "//div[text()='Stock options']//preceding:: img[1]")
		WebElement CompanyStockOffers_CheckBox_Option1;
		
		@FindBy(xpath = "//div[text()='Stock options']//following:: img[1]")
		WebElement CompanyStockOffers_CheckBox_Option1_ToolTip;
		
		@FindBy(xpath = "//div[text()='Restricted stock units (RSUs)']//preceding:: img[1]")
		WebElement CompanyStockOffers_CheckBox_Option2;
		
		@FindBy(xpath = "//div[text()='Restricted stock units (RSUs)']//following:: img[1]")
		WebElement CompanyStockOffers_CheckBox_Option2_ToolTip;
		
		@FindBy(xpath = "//div[text()='Employee stock purchase program (ESPP)']//preceding:: img[1]")
		WebElement CompanyStockOffers_CheckBox_Option3;
		
		@FindBy(xpath = "//div[text()='Employee stock purchase program (ESPP)']//following:: img[1]")
		WebElement CompanyStockOffers_CheckBox_Option3_ToolTip;
		
		
		
		@FindBy(xpath = "//button//div[text()='Save and continue']")
		WebElement Save_Continue_Button;
		
		
	
	// End of Object Repositories 
	
	
	public Questionaire_Page20_PartnerStockOptions(WebDriver driver,ExtentReports report,ExtentTest test) throws IOException
	{
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + propsFilepath);
		props.load(fis);
		Shot = new CaptureScreens(driver);
		this.driver = driver;
		this.report = report;
		this.test = test;
		PageFactory.initElements(driver, this);
		
	}
	
	public void Questionaire_PartnerStockOptions() throws IOException, InterruptedException
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
		
		// Company Stock Offers Title
		if(CompanyStockOffers_Label.isDisplayed())
		{
			test.log(LogStatus.PASS,test.addScreenCapture(Shot.CaptureScreen())+ "Company Stock Offers Title is Available");
		}
		else
		{
			test.log(LogStatus.FAIL,test.addScreenCapture(Shot.CaptureScreen())+ "Company Stock Offers Title is NOT Available");
		}
		
		// Company Stock Offers - Stock Option Tool Tip check and Entry Selection Option
		if(CompanyStockOffers_CheckBox_Option1.isDisplayed() && CompanyStockOffers_CheckBox_Option1_ToolTip.isDisplayed())
		{
			test.log(LogStatus.PASS,test.addScreenCapture(Shot.CaptureScreen())+ "Company Stock Offers - Stock Option Tool Tip check and Entry Selection Option is Available");
			CompanyStockOffers_CheckBox_Option1.click();
		}
		else
		{
			test.log(LogStatus.FAIL,test.addScreenCapture(Shot.CaptureScreen())+ "Company Stock Offers - Stock Option Tool Tip check and Entry Selection Option is NOT Available");
		}
		
		// Company Stock Offers - Restricted stock units (RSUs) Tool Tip check and Entry Selection Option
		if(CompanyStockOffers_CheckBox_Option2.isDisplayed() && CompanyStockOffers_CheckBox_Option2_ToolTip.isDisplayed())
		{
			test.log(LogStatus.PASS,test.addScreenCapture(Shot.CaptureScreen())+ "Company Stock Offers - Restricted stock units (RSUs) Tool Tip check and Entry Selection Option is Available");
			CompanyStockOffers_CheckBox_Option2.click();
		}
		else
		{
			test.log(LogStatus.FAIL,test.addScreenCapture(Shot.CaptureScreen())+ "Company Stock Offers - Restricted stock units (RSUs) Tool Tip check and Entry Selection Option is NOT Available");
		}
		
		// Company Stock Offers - Employee stock purchase program (ESPP) Tool Tip check and Entry Selection Option
		if(CompanyStockOffers_CheckBox_Option3.isDisplayed() && CompanyStockOffers_CheckBox_Option3_ToolTip.isDisplayed())
		{
			test.log(LogStatus.PASS,test.addScreenCapture(Shot.CaptureScreen())+ "Company Stock Offers - Employee stock purchase program (ESPP) Tool Tip check and Entry Selection Option is Available");
			CompanyStockOffers_CheckBox_Option3.click();
		}
		else
		{
			test.log(LogStatus.FAIL,test.addScreenCapture(Shot.CaptureScreen())+ "Company Stock Offers - Employee stock purchase program (ESPP) Tool Tip check and Entry Selection Option is NOT Available");
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
