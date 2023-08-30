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
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import ExtentReports.CaptureScreens;


public class Questionaire_Page34_AdditionalExpensesCheck {
	WebDriver driver;
	public ExtentReports report;
	public ExtentTest test;
	CaptureScreens Shot;
	static Properties props = new Properties();
	static String propsFilepath = "/src/test/resources/Config.properties";
	
	// Object Repositories 
		
		@FindBy(xpath = "//div[text()='ACCOUNTS']")
		WebElement AboutYouTitle;
		
		// @FindBy(xpath = "//div[contains(text(),'Do you or PaarnterName have any individual expenses, accounts or goals?')]")
		// WebElement PendingCheck_Label;
		
		@FindBy(xpath = "//div[contains(text(),'We assume you share everything unless you tell us otherwise!')]")
		WebElement PendingCheck_Sub_Label;
		
		@FindBy(xpath = "//div[contains(text(),'We assume you share everything unless you tell us otherwise!')]//following :: textarea")
		WebElement PendingCheck_TextArea;
		
		
		
		@FindBy(xpath = "//button//div[text()='Save and continue']")
		WebElement Save_Continue_Button;
		
		
		
		
	
	// End of Object Repositories 
	
	
	public Questionaire_Page34_AdditionalExpensesCheck(WebDriver driver,ExtentReports report,ExtentTest test) throws IOException
	{
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + propsFilepath);
		props.load(fis);
		Shot = new CaptureScreens(driver);
		this.driver = driver;
		this.report = report;
		this.test = test;
		PageFactory.initElements(driver, this);
		
	}
	
	public void Questionaire_AdditionalExpensesCheck() throws IOException, InterruptedException
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
		
		String PendingCheck_Label = "//div[contains(text(),'Do you or "+props.getProperty("PartnerName")+" have any individual expenses, accounts or goals?')]";
				
		// Pending Check Label
		if(driver.findElement(By.xpath(PendingCheck_Label)).isDisplayed())
		{
			test.log(LogStatus.PASS,test.addScreenCapture(Shot.CaptureScreen())+ "Pending Check label is Available");
		}
		else
		{
			test.log(LogStatus.FAIL,test.addScreenCapture(Shot.CaptureScreen())+ "Pending Check Label is NOT Available");
		}
		
		// Pending Check Sub Label
		if(PendingCheck_Sub_Label.isDisplayed())
		{
			test.log(LogStatus.PASS,test.addScreenCapture(Shot.CaptureScreen())+ "Pending Check Sub Label is Available");
		}
		else
		{
			test.log(LogStatus.FAIL,test.addScreenCapture(Shot.CaptureScreen())+ "Pending Check Sub Label is NOT Available");
		}
		
		// Pending Check text area
		if(PendingCheck_TextArea.isDisplayed())
		{
			test.log(LogStatus.PASS,test.addScreenCapture(Shot.CaptureScreen())+ "Pending Check Text Area is Available");
			PendingCheck_TextArea.sendKeys(props.getProperty("PendingCheckTextArea"));
		}
		else
		{
			test.log(LogStatus.FAIL,test.addScreenCapture(Shot.CaptureScreen())+ "Pending Check Text Area is NOT Available");
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
