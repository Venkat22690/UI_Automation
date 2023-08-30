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


public class Questionaire_Page10_IncomeBenefits_LandingPage {
	WebDriver driver;
	public ExtentReports report;
	public ExtentTest test;
	CaptureScreens Shot;
	static Properties props = new Properties();
	static String propsFilepath = "/src/test/resources/Config.properties";
	
	// Object Repositories 
		
		@FindBy(xpath = "//div[text()='BACKGROUND']")
		WebElement AboutYouTitle;
		
		@FindBy(xpath = "//div[contains(text(),'Income and benefits')]")
		WebElement IncomeBenefits_Label;
		
		@FindBy(xpath = "//div[contains(text(),'So we can find the right balance *for you* between enjoying your money today and saving toward big purchases and retirement.')]")
		WebElement IncomeBenefits_Label_Desscription; 
		
		@FindBy(xpath = "//button//div[text()='Let’s go']")
		WebElement LetsGo_Button;
		
		
	
	// End of Object Repositories 
	
	
	public Questionaire_Page10_IncomeBenefits_LandingPage(WebDriver driver,ExtentReports report,ExtentTest test) throws IOException
	{
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + propsFilepath);
		props.load(fis);
		Shot = new CaptureScreens(driver);
		this.driver = driver;
		this.report = report;
		this.test = test;
		PageFactory.initElements(driver, this);
		
	}
	

	public void Questionaire_IncomeBenefits_LandingPage() throws IOException, InterruptedException
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
		
		// Income Benefits Intro Page Title
		if(IncomeBenefits_Label.isDisplayed())
		{
			test.log(LogStatus.PASS,test.addScreenCapture(Shot.CaptureScreen())+ "Income Benefits Intro Page Title is Available");
		}
		else
		{
			test.log(LogStatus.FAIL,test.addScreenCapture(Shot.CaptureScreen())+ "Income Benefits Intro Page Title is NOT Available");
		}
		
		// Income Benefits Intro Page Description
		if(IncomeBenefits_Label_Desscription.isDisplayed())
		{
			test.log(LogStatus.PASS,test.addScreenCapture(Shot.CaptureScreen())+ "Income Benefits Intro Page Description is Available");
		}
		else
		{
			test.log(LogStatus.FAIL,test.addScreenCapture(Shot.CaptureScreen())+ "Income Benefits Intro Page Description is NOT Available");
		}
		
		
		// Lets Go
		if(LetsGo_Button.isDisplayed())
		{
			test.log(LogStatus.PASS,test.addScreenCapture(Shot.CaptureScreen())+ "Lets Go is Available");
			LetsGo_Button.click();
		}
		else
		{
			test.log(LogStatus.FAIL,test.addScreenCapture(Shot.CaptureScreen())+ "Lets Go is NOT Available");
		}
	}
	
}
