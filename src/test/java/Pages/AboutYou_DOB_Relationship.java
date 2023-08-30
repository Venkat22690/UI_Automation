package Pages;


import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import ExtentReports.CaptureScreens;


public class AboutYou_DOB_Relationship {
	WebDriver driver;
	public ExtentReports report;
	public ExtentTest test;
	CaptureScreens Shot;
	static Properties props = new Properties();
	static String propsFilepath = "/src/test/resources/Config.properties";
	
	
	// Object Repositories 
	
		@FindBy(xpath = "//div[text()='ABOUT YOU']")
		WebElement AboutYouTitle;
		
		@FindBy(xpath = "//div[text()='First, we need the basics!']")
		WebElement Basics_PageTitle;
		
		@FindBy(xpath = "//div[contains(text(),'When is your birthday?')]")
		WebElement Birthdate_Label;
		
		@FindBy(xpath = "//input[@type='date']")
		WebElement BirthDate_Entry;
		
		@FindBy(xpath = "//div[contains(text(),'Where do you live?')]")
		WebElement ZipCode_Label;
		
		@FindBy(xpath = "//input[@type='number']")
		WebElement ZipCode_Entry;
		
		@FindBy(xpath = "//div[contains(text(),'Are you...')]")
		WebElement Marital_Label;
		
		@FindBy(xpath = "//div[text()='Married']//preceding-sibling :: img")
		WebElement Married_Entry;
		
		@FindBy(xpath = "//div[contains(text(),'Any kids?')]")
		WebElement Kids_Label;
		
		@FindBy(xpath = "//div[text()='Yes']//preceding-sibling :: img")
		WebElement Kids_Entry;
		
		@FindBy(xpath = "//div[contains(text(),'Roughly how much money do you have saved up? (cash, investments, retirement, etc.)')]")
		WebElement Money_Label;
		
		@FindBy(xpath = "//div[text()='$400k - $1M']//preceding-sibling :: img")
		WebElement Money_Entry;
		
		@FindBy(xpath = "//div[text()='over $1M']//preceding-sibling :: img")
		WebElement Money_Extra_Entry;
		
		@FindBy(xpath = "//button//div[text()='Save and continue']")
		WebElement Save_Continue_Btn;
	
	
	// End of Object Repositories 
	
	
	public AboutYou_DOB_Relationship(WebDriver driver,ExtentReports report,ExtentTest test) throws IOException
	{
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + propsFilepath);
		props.load(fis);
		Shot = new CaptureScreens(driver);
		this.driver = driver;
		this.report = report;
		this.test = test;
		PageFactory.initElements(driver, this);
		
	}
	
	public void AboutYouDetails() throws IOException, AWTException, InterruptedException
	{
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));	
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='ABOUT YOU']")));
		
		// Page Title Validation
		if(AboutYouTitle.isDisplayed())		
		{
			test.log(LogStatus.PASS,test.addScreenCapture(Shot.CaptureScreen())+ "Page Header Title is Available");
		}
		else
		{
			test.log(LogStatus.FAIL,test.addScreenCapture(Shot.CaptureScreen())+ "Page Header Title is NOT Available");
		}
		
		// Page Sub Title Validation
		if(Basics_PageTitle.isDisplayed())
		{
			test.log(LogStatus.PASS,test.addScreenCapture(Shot.CaptureScreen())+ "Page Sub Header Title is Available");
		}
		else
		{
			test.log(LogStatus.FAIL,test.addScreenCapture(Shot.CaptureScreen())+ "Page Sub Header Title is NOT Available");
		}
		
		// Birthday 
		if(Birthdate_Label.isDisplayed())
		{
			test.log(LogStatus.PASS,test.addScreenCapture(Shot.CaptureScreen())+ "Birthdate is Available");
			Thread.sleep(2000);
			Robot rb = new Robot();
			BirthDate_Entry.click();
			BirthDate_Entry.sendKeys("22");
			BirthDate_Entry.sendKeys("12");
			BirthDate_Entry.sendKeys("2001");
			Thread.sleep(2000);	
		}
		else
		{
			test.log(LogStatus.FAIL,test.addScreenCapture(Shot.CaptureScreen())+ "Birthdate is NOT Available");
		}
		
		// ZipCode 
		if(ZipCode_Label.isDisplayed())
		{
			test.log(LogStatus.PASS,test.addScreenCapture(Shot.CaptureScreen())+ "ZipCode is Available");
			ZipCode_Entry.sendKeys(props.getProperty("ZipCode"));
		}
		else
		{
			test.log(LogStatus.FAIL,test.addScreenCapture(Shot.CaptureScreen())+ "ZipCode is NOT Available");
		}
		
		// Marital 
		if(Marital_Label.isDisplayed())
		{
			test.log(LogStatus.PASS,test.addScreenCapture(Shot.CaptureScreen())+ "Marital is Available");
			Married_Entry.click();
		}
		else
		{
			test.log(LogStatus.FAIL,test.addScreenCapture(Shot.CaptureScreen())+ "Marital is NOT Available");
		}
		
		// Kids 
		if(Kids_Label.isDisplayed())
		{
			test.log(LogStatus.PASS,test.addScreenCapture(Shot.CaptureScreen())+ "Marital is Available");
			Kids_Entry.click();
		}
		else
		{
			test.log(LogStatus.FAIL,test.addScreenCapture(Shot.CaptureScreen())+ "Marital is NOT Available");
		}
		
		// Money 
		if(Money_Label.isDisplayed())
		{
			test.log(LogStatus.PASS,test.addScreenCapture(Shot.CaptureScreen())+ "Marital is Available");
			Money_Entry.click();
		}
		else
		{
			test.log(LogStatus.FAIL,test.addScreenCapture(Shot.CaptureScreen())+ "Marital is NOT Available");
		}
		
		
		// Save and Continue 
		if(Save_Continue_Btn.isDisplayed())
		{
			test.log(LogStatus.PASS,test.addScreenCapture(Shot.CaptureScreen())+ "Save and Continue is Available");
			Thread.sleep(4000);	
			Save_Continue_Btn.click();
		}
		else
		{
			test.log(LogStatus.FAIL,test.addScreenCapture(Shot.CaptureScreen())+ "Save and Continue is NOT Available");
		}
		
		
	}
	
}
