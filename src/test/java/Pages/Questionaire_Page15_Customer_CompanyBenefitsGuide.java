package Pages;


import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.Random;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import ExtentReports.CaptureScreens;


public class Questionaire_Page15_Customer_CompanyBenefitsGuide {
	WebDriver driver;
	public ExtentReports report;
	public ExtentTest test;
	CaptureScreens Shot;
	static Properties props = new Properties();
	static String propsFilepath = "/src/test/resources/Config.properties";
	
	// Object Repositories 
		
		@FindBy(xpath = "//div[text()='INCOME']")
		WebElement AboutYouTitle;
		
		@FindBy(xpath = "//div[contains(text(),'Please upload your company’s benefits guide')]")
		WebElement CompanyBenefits_Label;
		
		@FindBy(xpath = "//div[contains(text(),'This is important — many companies offer benefits that can add up to thousands of dollars per year!')]")
		WebElement CompanyBenefits_Sub_Label;
		
		@FindBy(xpath = "//div[contains(text(),'No benefits guide? You can enter your benefits manually on the next screen.')]")
		WebElement CompanyBenefits_Sub2_Label;
		
		@FindBy(xpath = "//div[contains(text(),'Where to find your benefits')]")
		WebElement CompanyBenefits_Side_Label;
		
		@FindBy(xpath = "//input[@type='file']")
		WebElement UploadFile;
		
		@FindBy(xpath = "//u[text()='Choose file']")
		WebElement UploadFile_Option;
		
		
		
		@FindBy(xpath = "//button//div[text()='Save and continue']")
		WebElement Save_Continue_Button;
		
		
	
	// End of Object Repositories 
	
	
	public Questionaire_Page15_Customer_CompanyBenefitsGuide(WebDriver driver,ExtentReports report,ExtentTest test) throws IOException
	{
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + propsFilepath);
		props.load(fis);
		Shot = new CaptureScreens(driver);
		this.driver = driver;
		this.report = report;
		this.test = test;
		PageFactory.initElements(driver, this);
		
	}
	
	
	public void Questionaire_Customer_CompanyBenefitsGuide() throws IOException, InterruptedException
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
		
		// Company Benefits Title
		if(CompanyBenefits_Label.isDisplayed())
		{
			test.log(LogStatus.PASS,test.addScreenCapture(Shot.CaptureScreen())+ "Company Benefits Title is Available");
		}
		else
		{
			test.log(LogStatus.FAIL,test.addScreenCapture(Shot.CaptureScreen())+ "Company Benefits Title is NOT Available");
		}
		
		// Company Benefits Sub Title
		if(CompanyBenefits_Sub_Label.isDisplayed())
		{
			test.log(LogStatus.PASS,test.addScreenCapture(Shot.CaptureScreen())+ "Company Benefits Sub Title is Available");
		}
		else
		{
			test.log(LogStatus.FAIL,test.addScreenCapture(Shot.CaptureScreen())+ "Company Benefits Sub Title is NOT Available");
		}
		
		// Company Benefits Another Sub Title
		if(CompanyBenefits_Sub2_Label.isDisplayed())
		{
			test.log(LogStatus.PASS,test.addScreenCapture(Shot.CaptureScreen())+ "Company Benefits Another Sub Title is Available");
		}
		else
		{
			test.log(LogStatus.FAIL,test.addScreenCapture(Shot.CaptureScreen())+ "Company Benefits Another Sub Title is NOT Available");
		}
		
		// Company Benefits Side Title
		if(CompanyBenefits_Side_Label.isDisplayed())
		{
			test.log(LogStatus.PASS,test.addScreenCapture(Shot.CaptureScreen())+ "Company Benefits Side Title is Available");
		}
		else
		{
			test.log(LogStatus.FAIL,test.addScreenCapture(Shot.CaptureScreen())+ "Company Benefits Side Title is NOT Available");
		}
		
		// Upload Option
		if(UploadFile_Option.isDisplayed())
		{
			test.log(LogStatus.PASS,test.addScreenCapture(Shot.CaptureScreen())+ "Company Benefits Upload Option is Available");
			String UploadFileNameWithExtn=props.getProperty("UploadFileNameWithExtn");
			String UploadPath = "/src/test/resources/"+UploadFileNameWithExtn;
			System.out.println(System.getProperty("user.dir") + UploadPath);
			
			 UploadPath = "C:/Users/user/eclipse-workspace/Uprise_UI_Automation/src/test/resources/test.txt";
			 UploadFile.sendKeys(UploadPath);
			 Thread.sleep(4000);
		}
		else
		{
			test.log(LogStatus.FAIL,test.addScreenCapture(Shot.CaptureScreen())+ "Company Benefits Upload Option is NOT Available");
		}
		
		
		// Save and Continue 
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)", "");
		
		if(Save_Continue_Button.isDisplayed())
		{
			test.log(LogStatus.PASS,test.addScreenCapture(Shot.CaptureScreen())+ "Lets Go is Available");
			Thread.sleep(2000);
			Save_Continue_Button.click();
		}
		else
		{
			test.log(LogStatus.FAIL,test.addScreenCapture(Shot.CaptureScreen())+ "Lets Go is NOT Available");
		}
	}
	
}
