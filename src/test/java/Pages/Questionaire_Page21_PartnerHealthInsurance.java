package Pages;


import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
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


public class Questionaire_Page21_PartnerHealthInsurance {
	WebDriver driver;
	public ExtentReports report;
	public ExtentTest test;
	CaptureScreens Shot;
	static Properties props = new Properties();
	static String propsFilepath = "/src/test/resources/Config.properties";
	
	// Object Repositories 
		
		@FindBy(xpath = "//div[text()='INCOME']")
		WebElement AboutYouTitle;
		
		// @FindBy(xpath = "//div[contains(text(),'What health plan is PaarnterName on?')]")
		// WebElement HealthInsurance_Label;
		
		@FindBy(xpath = "//div[contains(text(),'Their employer')]//preceding:: img[1]")
		WebElement HealthInsurance_Option1;
		
		@FindBy(xpath = "//div[contains(text(),'Parent')]//preceding:: img[1]")
		WebElement HealthInsurance_Option2;
		
		@FindBy(xpath = "//input[@type='text']")
		WebElement HealthInsurance_PlanNameEntry;
		
		@FindBy(xpath = "//button//div[text()='Save and continue']")
		WebElement Save_Continue_Button;
		
		
	
	// End of Object Repositories 
	
	
	public Questionaire_Page21_PartnerHealthInsurance(WebDriver driver,ExtentReports report,ExtentTest test) throws IOException
	{
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + propsFilepath);
		props.load(fis);
		Shot = new CaptureScreens(driver);
		this.driver = driver;
		this.report = report;
		this.test = test;
		PageFactory.initElements(driver, this);
		
	}
		
	public void Questionaire_PartnerHealthInsurance() throws IOException, InterruptedException
	{
		Thread.sleep(4000);
		String PartnerInsuranceLabel ="//div[contains(text(),'What health plan is "+ props.getProperty("PartnerName")+"')]";
		
		// Page Title
		if(AboutYouTitle.isDisplayed())
		{
			test.log(LogStatus.PASS,test.addScreenCapture(Shot.CaptureScreen())+ "Page Title is Available");
		}
		else
		{
			test.log(LogStatus.FAIL,test.addScreenCapture(Shot.CaptureScreen())+ "Page Title is NOT Available");
		}
		
		// Health Insurance Title
		if(driver.findElement(By.xpath(PartnerInsuranceLabel)).isDisplayed())
		{
			test.log(LogStatus.PASS,test.addScreenCapture(Shot.CaptureScreen())+ "Partner Health Insurance Title is Available");
		}
		else
		{
			test.log(LogStatus.FAIL,test.addScreenCapture(Shot.CaptureScreen())+ "Partner Health Insurance Title is NOT Available");
		}
				
		// Insurance Plan Entries Check
		List<WebElement> TopicList = driver.findElements(By.xpath("//div[contains(text(),'What health plan')]//following:: img//following-sibling ::div"));
		if(TopicList.size() == 6)
		{
			for(int i =0;i<TopicList.size();i++)
			{
				String Entriescheck = TopicList.get(i).getText();
				System.out.println(Entriescheck);
				if(Entriescheck.isEmpty())
				{
					test.log(LogStatus.FAIL,test.addScreenCapture(Shot.CaptureScreen())+ "Insurance Plan Entries are missing");
				}
			}
		}
		else
		{
			test.log(LogStatus.FAIL,test.addScreenCapture(Shot.CaptureScreen())+ "Insurance Plan Count are missing");
		}
		
		
		// Health Insurance Plan Selection
		if(HealthInsurance_Option1.isDisplayed())
		{
			test.log(LogStatus.PASS,test.addScreenCapture(Shot.CaptureScreen())+ "Health Insurance Plan Selection is Available");
			HealthInsurance_Option1.click();
		}
		else
		{
			test.log(LogStatus.FAIL,test.addScreenCapture(Shot.CaptureScreen())+ "Health Insurance Plan Selection is NOT Available");
		}
		
		
		
		// Health Insurance Plan Selection
		if(HealthInsurance_PlanNameEntry.isDisplayed())
		{
			test.log(LogStatus.PASS,test.addScreenCapture(Shot.CaptureScreen())+ "Health Insurance Entry is Available");
			HealthInsurance_PlanNameEntry.sendKeys(props.getProperty("HealthInsuranceNamePartner"));
		}
		else
		{
			test.log(LogStatus.FAIL,test.addScreenCapture(Shot.CaptureScreen())+ "Health Insurance Entry is NOT Available");
		}
		
		
		// Health Insurance Plan Selection
		if(HealthInsurance_Option2.isDisplayed())
		{
			test.log(LogStatus.PASS,test.addScreenCapture(Shot.CaptureScreen())+ "Health Insurance Plan Selection is Available");
			HealthInsurance_Option2.click();
		}
		else
		{
			test.log(LogStatus.FAIL,test.addScreenCapture(Shot.CaptureScreen())+ "Health Insurance Plan Selection is NOT Available");
		}
		
		
		
		// Save and Continue 
		if(Save_Continue_Button.isDisplayed())
		{
			test.log(LogStatus.PASS,test.addScreenCapture(Shot.CaptureScreen())+ "Save and Continue is Available");
			Thread.sleep(2000);
			Save_Continue_Button.click();
		}
		else
		{
			test.log(LogStatus.FAIL,test.addScreenCapture(Shot.CaptureScreen())+ "Save and Continue is NOT Available");
		}
	}
	
}
