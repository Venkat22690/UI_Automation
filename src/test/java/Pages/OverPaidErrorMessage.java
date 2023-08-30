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


public class OverPaidErrorMessage {
	WebDriver driver;
	public ExtentReports report;
	public ExtentTest test;
	CaptureScreens Shot;
	static Properties props = new Properties();
	static String propsFilepath = "/src/test/resources/Config.properties";
	
	// Object Repositories 
	
		@FindBy(xpath = "//div[text()='An important note']")
		WebElement OverPaidPage_Title;
		
		@FindBy(xpath = "//div//b[contains(text(),'Unfortunately, we don’t yet support people with that much in savings. As you know, financial optimization gets a lot more complex with more money in the bank.')]")
		WebElement OverEarningMessage;
		
		@FindBy(xpath = "(//div[text()='Invite friends']//following :: div)[1]")
		WebElement ProfileLink;
		
		@FindBy(xpath = "//div[text()='Log out']")
		WebElement LogOutLink;
		
			
			
	// End of Object Repositories 
	
	
	public OverPaidErrorMessage(WebDriver driver,ExtentReports report,ExtentTest test) throws IOException
	{
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + propsFilepath);
		props.load(fis);
		Shot = new CaptureScreens(driver);
		this.driver = driver;
		this.report = report;
		this.test = test;
		PageFactory.initElements(driver, this);
		
	}
	
	public void LaunchApplication()
	{
	   test.log(LogStatus.INFO, "Test Cases Validate Title is Started");
	   System.out.println(props.getProperty("URL"));
	   driver.get("https://www.google.com");
	   driver.get(props.getProperty("URL"));  
	}
	
	public void SignUp() throws IOException
	{
		System.out.println("******* SignUp *******");
	
		if(OverPaidPage_Title.isDisplayed())
		{
			test.log(LogStatus.PASS,test.addScreenCapture(Shot.CaptureScreen())+ "SummaPass");
		}
		else
		{
			test.log(LogStatus.FAIL,test.addScreenCapture(Shot.CaptureScreen())+ "SummaFailed");
		}
		
	}
	
}
