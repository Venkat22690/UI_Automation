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


public class Questionaire_Page11_DegreeDetails {
	WebDriver driver;
	public ExtentReports report;
	public ExtentTest test;
	CaptureScreens Shot;
	static Properties props = new Properties();
	static String propsFilepath = "/src/test/resources/Config.properties";
	
	// Object Repositories 
		
		@FindBy(xpath = "//div[text()='INCOME']")
		WebElement AboutYouTitle;
		
		@FindBy(xpath = "//div[contains(text(),'Tell us about your most recent degree')]")
		WebElement Degree_Label;
		
		@FindBy(xpath = "//input[@type='number']")
		WebElement Degree_Year;
		
		@FindBy(xpath = "//div[text()='Graduate']//preceding-sibling :: img")
		WebElement Degree_RadioSelection;
		
		@FindBy(xpath = "//button//div[text()='Save and continue']")
		WebElement Save_Continue_Button;
		
		
	
	// End of Object Repositories 
	
	
	public Questionaire_Page11_DegreeDetails(WebDriver driver,ExtentReports report,ExtentTest test) throws IOException
	{
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + propsFilepath);
		props.load(fis);
		Shot = new CaptureScreens(driver);
		this.driver = driver;
		this.report = report;
		this.test = test;
		PageFactory.initElements(driver, this);
		
	}
	
	public void Questionaire_DegreeDetails() throws IOException, InterruptedException
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
		
		// Degree Page Title
		if(Degree_Label.isDisplayed())
		{
			test.log(LogStatus.PASS,test.addScreenCapture(Shot.CaptureScreen())+ "Degree Page Title is Available");
		}
		else
		{
			test.log(LogStatus.FAIL,test.addScreenCapture(Shot.CaptureScreen())+ "Degree Page Title is NOT Available");
		}
		
		// Degree Year
		if(Degree_Year.isDisplayed())
		{
			test.log(LogStatus.PASS,test.addScreenCapture(Shot.CaptureScreen())+ "Degree Year Entry is Available");
			Degree_Year.sendKeys(props.getProperty("DegreeYear"));
		}
		else
		{
			test.log(LogStatus.FAIL,test.addScreenCapture(Shot.CaptureScreen())+ "Degree Year Entry is NOT Available");
		}
		
		// Degree Selection Radio Option
		if(Degree_RadioSelection.isDisplayed())
		{
			test.log(LogStatus.PASS,test.addScreenCapture(Shot.CaptureScreen())+ "Degree Selection Radio Option is Available");
			Degree_RadioSelection.click();
		}
		else
		{
			test.log(LogStatus.FAIL,test.addScreenCapture(Shot.CaptureScreen())+ "Degree Selection Radio Option is NOT Available");
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
