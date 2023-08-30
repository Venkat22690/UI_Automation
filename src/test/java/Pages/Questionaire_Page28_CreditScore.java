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


public class Questionaire_Page28_CreditScore {
	WebDriver driver;
	public ExtentReports report;
	public ExtentTest test;
	CaptureScreens Shot;
	static Properties props = new Properties();
	static String propsFilepath = "/src/test/resources/Config.properties";
	
	// Object Repositories 
		
		@FindBy(xpath = "//div[text()='ACCOUNTS']")
		WebElement AboutYouTitle;
		
		@FindBy(xpath = "//div[contains(text(),'What is your credit score?')]")
		WebElement CreditScore_Label;
		
		@FindBy(xpath = "//div[contains(text(),'look for ways to improve your score, optimize your credit card and loan portfolio, and plan for big purchases.')]")
		WebElement CreditScore_Sub_Label;
		
		@FindBy(xpath = "//div[@class='sc-DWsrX jjDPAI']//div[@class='sc-iaJaUu gAbQcy']")
		By CreditScores;
		
		@FindBy(xpath = "(//div[text()='740-799']//preceding:: img[1])[1]")
		WebElement CreditScoreSelection_Owner;
		
		// @FindBy(xpath = "//div[contains(text(),'What about PaarnterName?')]")
		// WebElement CreditScore_Partner_Label;
		
		@FindBy(xpath = "(//div[text()='740-799']//preceding:: img[1])[2]")
		WebElement CreditScoreSelection_Parnter;
		
		@FindBy(xpath = "//button//div[text()='Save and continue']")
		WebElement Save_Continue_Button;
		
		
		
		
	
	// End of Object Repositories 
	
	
	public Questionaire_Page28_CreditScore(WebDriver driver,ExtentReports report,ExtentTest test) throws IOException
	{
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + propsFilepath);
		props.load(fis);
		Shot = new CaptureScreens(driver);
		this.driver = driver;
		this.report = report;
		this.test = test;
		PageFactory.initElements(driver, this);
		
	}
	
	public void Questionaire_CreditScore() throws IOException, InterruptedException
	{
		Thread.sleep(3000);
		
		String CreditScore_Partner_Label ="//div[contains(text(),'What about "+ props.getProperty("PartnerName")+"?')]";		
		
		
		// Page Title
		if(AboutYouTitle.isDisplayed())
		{
			test.log(LogStatus.PASS,test.addScreenCapture(Shot.CaptureScreen())+ "Page Title is Available");
		}
		else
		{
			test.log(LogStatus.FAIL,test.addScreenCapture(Shot.CaptureScreen())+ "Page Title is NOT Available");
		}
		
		// Credit Score Page Label
		if(CreditScore_Label.isDisplayed())
		{
			test.log(LogStatus.PASS,test.addScreenCapture(Shot.CaptureScreen())+ "Credit Score Page is Available");
		}
		else
		{
			test.log(LogStatus.FAIL,test.addScreenCapture(Shot.CaptureScreen())+ "Credit Score Page is NOT Available");
		}
		
		// Credit Score Sub Label
		if(CreditScore_Sub_Label.isDisplayed())
		{
			test.log(LogStatus.PASS,test.addScreenCapture(Shot.CaptureScreen())+ "Credit Score Sub Page is Available");
		}
		else
		{
			test.log(LogStatus.FAIL,test.addScreenCapture(Shot.CaptureScreen())+ "Credit Score Sub Page is NOT Available");
		}		
		
		// Important Entries Check
		List<WebElement> CreditScoresList = driver.findElements(By.xpath("//div[contains(text(),'big purchases.')]//following:: img //following-sibling:: div"));
		if(CreditScoresList.size() == 12)
		{
			for(int i =0;i<CreditScoresList.size();i++)
			{
				String Entriescheck = CreditScoresList.get(i).getText();
				System.out.println(Entriescheck);
				if(Entriescheck.isEmpty())
				{
					test.log(LogStatus.FAIL,test.addScreenCapture(Shot.CaptureScreen())+ "Credit Scores Entries are missing");
				}
			}
		}
		else
		{
			test.log(LogStatus.FAIL,test.addScreenCapture(Shot.CaptureScreen())+ "Credit Scores Count are missing");
		}
		
		
		// Credit Score Customer
		if(CreditScoreSelection_Owner.isDisplayed())
		{
			test.log(LogStatus.PASS,test.addScreenCapture(Shot.CaptureScreen())+ "Credit Score Selection Owner is Available");
			CreditScoreSelection_Owner.click();
		}
		else
		{
			test.log(LogStatus.FAIL,test.addScreenCapture(Shot.CaptureScreen())+ "Credit Score Selection Owner is NOT Available");
		}
		
		// Credit Score Partner Label
		if(driver.findElement(By.xpath(CreditScore_Partner_Label)).isDisplayed())
		{
			test.log(LogStatus.PASS,test.addScreenCapture(Shot.CaptureScreen())+ "Credit Score Partner Label is Available");
		}
		else
		{
			test.log(LogStatus.FAIL,test.addScreenCapture(Shot.CaptureScreen())+ "Credit Score Partner Page is NOT Available");
		}
		
		// Credit Score Partner
		if(CreditScoreSelection_Parnter.isDisplayed())
		{
			test.log(LogStatus.PASS,test.addScreenCapture(Shot.CaptureScreen())+ "Credit Score Selection Partner is Available");
			CreditScoreSelection_Parnter.click();
		}
		else
		{
			test.log(LogStatus.FAIL,test.addScreenCapture(Shot.CaptureScreen())+ "Credit Score Selection Partner is NOT Available");
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
