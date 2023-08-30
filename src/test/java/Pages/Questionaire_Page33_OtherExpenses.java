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


public class Questionaire_Page33_OtherExpenses {
	WebDriver driver;
	public ExtentReports report;
	public ExtentTest test;
	CaptureScreens Shot;
	static Properties props = new Properties();
	static String propsFilepath = "/src/test/resources/Config.properties";
	
	// Object Repositories 
		
		@FindBy(xpath = "//div[text()='ACCOUNTS']")
		WebElement AboutYouTitle;
		
		@FindBy(xpath = "//div[contains(text(),'How much do you guys spend every month?')]")
		WebElement SpendingEveryMonth_Label;
		
		@FindBy(xpath = "//div[contains(text(),'Estimates are okay!')]")
		WebElement SpendingEveryMonth_Sub_Label;
		
		@FindBy(xpath = "//p[contains(text(),'Like utilities, food, shopping, travel, etc')]")
		WebElement SpendingEveryMonth_Sub2_Label;
		
		@FindBy(xpath = "//input[@placeholder='Rent or mortgage']")
		WebElement RentUpdate;
		
		@FindBy(xpath = "//input[@placeholder='All other monthly expenses']")
		WebElement OtherExpenses;
		
		
		@FindBy(xpath = "//button//div[text()='Save and continue']")
		WebElement Save_Continue_Button;
		
		
		
		
	
	// End of Object Repositories 
	
	
	public Questionaire_Page33_OtherExpenses(WebDriver driver,ExtentReports report,ExtentTest test) throws IOException
	{
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + propsFilepath);
		props.load(fis);
		Shot = new CaptureScreens(driver);
		this.driver = driver;
		this.report = report;
		this.test = test;
		PageFactory.initElements(driver, this);
		
	}
	
	public void Questionaire_OtherExpenses() throws IOException, InterruptedException
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
		
		// Spendings Label
		if(SpendingEveryMonth_Label.isDisplayed())
		{
			test.log(LogStatus.PASS,test.addScreenCapture(Shot.CaptureScreen())+ "Spendings Every Month label is Available");
		}
		else
		{
			test.log(LogStatus.FAIL,test.addScreenCapture(Shot.CaptureScreen())+ "Spendings Every Month Label is NOT Available");
		}
		
		// Spendings Sub Label
		if(SpendingEveryMonth_Sub_Label.isDisplayed())
		{
			test.log(LogStatus.PASS,test.addScreenCapture(Shot.CaptureScreen())+ "Spendings Every Month Sub Label is Available");
		}
		else
		{
			test.log(LogStatus.FAIL,test.addScreenCapture(Shot.CaptureScreen())+ "Spendings Every Month Sub Label is NOT Available");
		}
		
		// Spendings second Sub Label
		if(SpendingEveryMonth_Sub2_Label.isDisplayed())
		{
			test.log(LogStatus.PASS,test.addScreenCapture(Shot.CaptureScreen())+ "Spendings Every Month Second Sub Label is Available");
		}
		else
		{
			test.log(LogStatus.FAIL,test.addScreenCapture(Shot.CaptureScreen())+ "Spendings Every Month Second Sub Label is NOT Available");
		}
		
		
		// Rent Update
		if(RentUpdate.isDisplayed())
		{
			test.log(LogStatus.PASS,test.addScreenCapture(Shot.CaptureScreen())+ "Rent Update Entry is Available");
			RentUpdate.sendKeys(props.getProperty("RentUpdate"));
		}
		else
		{
			test.log(LogStatus.FAIL,test.addScreenCapture(Shot.CaptureScreen())+ "Rent Update Entry is NOT Available");
		}
		
		// Other Expenses
		if(OtherExpenses.isDisplayed())
		{
			test.log(LogStatus.PASS,test.addScreenCapture(Shot.CaptureScreen())+ "Other Expenses Entry is Available");
			OtherExpenses.sendKeys(props.getProperty("OtherExpenses"));
		}
		else
		{
			test.log(LogStatus.FAIL,test.addScreenCapture(Shot.CaptureScreen())+ "Other Expenses Entry is NOT Available");
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
