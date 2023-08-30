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


public class Questionaire_Page23_PartnerRetirementBenefits {
	WebDriver driver;
	public ExtentReports report;
	public ExtentTest test;
	CaptureScreens Shot;
	static Properties props = new Properties();
	static String propsFilepath = "/src/test/resources/Config.properties";
	
	// Object Repositories 
		
		@FindBy(xpath = "//div[text()='INCOME']")
		WebElement AboutYouTitle;
		
		// @FindBy(xpath = "//div[contains(text(),'What benefits does PaarnterName’s company offer?')]")
		// WebElement CompanyOffers_Label;
		
		@FindBy(xpath = "//div[text()='401(k)']//preceding:: img[1]")
		WebElement Benefit_1;
		
		@FindBy(xpath = "//div[text()='Employer 401(k) matching']//preceding:: img[1]")
		WebElement Benefit_2;
		
		@FindBy(xpath = "//div[text()='HSA']//preceding:: img[1]")
		WebElement Benefit_3;
		
		@FindBy(xpath = "//div[text()='Employer HSA contributions']//preceding:: img[1]")
		WebElement Benefit_4;
		
		@FindBy(xpath = "//div[text()='I don’t have any of these benefits']//preceding:: img[1]")
		WebElement Benefit_5;
		
		@FindBy(xpath = "//div[text()='I’m not sure']//preceding:: img[1]")
		WebElement Benefit_6;
		
		@FindBy(xpath = "//button//div[text()='Save and continue']")
		WebElement Save_Continue_Button;
		
		
	
	// End of Object Repositories 
	
	
	public Questionaire_Page23_PartnerRetirementBenefits(WebDriver driver,ExtentReports report,ExtentTest test) throws IOException
	{
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + propsFilepath);
		props.load(fis);
		Shot = new CaptureScreens(driver);
		this.driver = driver;
		this.report = report;
		this.test = test;
		PageFactory.initElements(driver, this);
		
	}
	
	public void Questionaire_PartnerRetirementBenefits() throws IOException, InterruptedException
	{
		Thread.sleep(4000);
		String CompanyOffers_Label ="//div[contains(text(),'What benefits does "+ props.getProperty("PartnerName")+"')]";	
		
		// Page Title
		if(AboutYouTitle.isDisplayed())
		{
			test.log(LogStatus.PASS,test.addScreenCapture(Shot.CaptureScreen())+ "Page Title is Available");
		}
		else
		{
			test.log(LogStatus.FAIL,test.addScreenCapture(Shot.CaptureScreen())+ "Page Title is NOT Available");
		}
		
		// Company Offers Title
		if(driver.findElement(By.xpath(CompanyOffers_Label)).isDisplayed())
		{
			test.log(LogStatus.PASS,test.addScreenCapture(Shot.CaptureScreen())+ "Company Offers Title is Available");
		}
		else
		{
			test.log(LogStatus.FAIL,test.addScreenCapture(Shot.CaptureScreen())+ "Company Offers Title is NOT Available");
		}
		
		/*// Company Offers Sub Title
		if(CompanyOffers_Sub_Label.isDisplayed())
		{
			test.log(LogStatus.PASS,test.addScreenCapture(Shot.CaptureScreen())+ "Company Offers Sub Title is Available");
		}
		else
		{
			test.log(LogStatus.FAIL,test.addScreenCapture(Shot.CaptureScreen())+ "Company Offers Sub Title is NOT Available");
		} */
		
		// Selecting all the benefits option
		if(Benefit_1.isDisplayed() && Benefit_2.isDisplayed() && Benefit_3.isDisplayed() && Benefit_4.isDisplayed() && Benefit_5.isDisplayed() && Benefit_6.isDisplayed())
		{
			test.log(LogStatus.PASS,test.addScreenCapture(Shot.CaptureScreen())+ "Company Benefits Entries is Available");
			Benefit_1.click();
			Benefit_2.click();
			Benefit_3.click();
			Benefit_4.click();
			Benefit_5.click();
			Benefit_6.click();
			Thread.sleep(2000);
		}
		else
		{
			test.log(LogStatus.FAIL,test.addScreenCapture(Shot.CaptureScreen())+ "Company Benefits Entries is NOT Available");
		}
		
		// Save and Continue 
		if(Save_Continue_Button.isDisplayed())
		{
			test.log(LogStatus.PASS,test.addScreenCapture(Shot.CaptureScreen())+ "Lets Go is Available");
			Save_Continue_Button.click();
		}
		else
		{
			test.log(LogStatus.FAIL,test.addScreenCapture(Shot.CaptureScreen())+ "Lets Go is NOT Available");
		}
	}
	
}
