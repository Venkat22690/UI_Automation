package Pages;


import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import ExtentReports.CaptureScreens;


public class Finance_Questions {
	WebDriver driver;
	public ExtentReports report;
	public ExtentTest test;
	CaptureScreens Shot;
	static Properties props = new Properties();
	static String propsFilepath = "/src/test/resources/Config.properties";
	
	// Object Repositories 
	
		@FindBy(xpath = "//div[text()='ABOUT YOU']")
		WebElement AboutYouTitle;
		
		@FindBy(xpath = "//div[text()='What questions do you have about your finances?']")
		WebElement Finance_PageTitle;
		
		@FindBy(xpath = "//div[contains(text(),'Your HUMAN advisor will read this and respond directly in your plan!')]")
		WebElement Finance_Another_PageTitle;
		
		@FindBy(xpath = "//div[contains(text(),'Popular questions')]")
		WebElement Finance_Popular_PageTitle;
		
		// @FindBy(xpath = "//div[contains(text(),'Popular questions')]//following :: div[contains(@class,'sc-dL')]")
		// By PopularQuestions_Entries;
		
		@FindBy(xpath = "//div[@id='ansInpoe_quest_on_finance']//textarea")
		WebElement PopularQuestions_Textarea;
		
		@FindBy(xpath = "//button//div[text()='Save and continue']")
		WebElement Save_Continue_Btn;	
	
	
	// End of Object Repositories 
	
	
	public Finance_Questions(WebDriver driver,ExtentReports report,ExtentTest test) throws IOException
	{
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + propsFilepath);
		props.load(fis);
		Shot = new CaptureScreens(driver);
		this.driver = driver;
		this.report = report;
		this.test = test;
		PageFactory.initElements(driver, this);
		
	}
	
	public void FinanceQuestionPage() throws IOException, InterruptedException
	{
		
		Thread.sleep(4000);
		
		// Page Title About You Verification
		if(AboutYouTitle.isDisplayed())
		{
			test.log(LogStatus.PASS,test.addScreenCapture(Shot.CaptureScreen())+ "AboutYou Title is Available");
		}
		else
		{
			test.log(LogStatus.FAIL,test.addScreenCapture(Shot.CaptureScreen())+ "AboutYou Title is NOT Available");
		}
		
		// Finance Question Header
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView();", Finance_PageTitle); 
		
		if(Finance_PageTitle.isDisplayed())
		{
			test.log(LogStatus.PASS,test.addScreenCapture(Shot.CaptureScreen())+ "Finance page Question Header is Available");
		}
		else
		{
			test.log(LogStatus.FAIL,test.addScreenCapture(Shot.CaptureScreen())+ "Finance page Question Header is NOT Available");
		}
		
		// Caroline Question
		if(Finance_Another_PageTitle.isDisplayed())
		{
			test.log(LogStatus.PASS,test.addScreenCapture(Shot.CaptureScreen())+ "Finance Question Page Caroline Question is Available");
		}
		else
		{
			test.log(LogStatus.FAIL,test.addScreenCapture(Shot.CaptureScreen())+ "Finance Question Page Caroline Question is NOT Available");
		}
		
		
		// Popular Questions header 
		if(Finance_Popular_PageTitle.isDisplayed())
		{
			test.log(LogStatus.PASS,test.addScreenCapture(Shot.CaptureScreen())+ "Popular Questions Header is Available");
		}
		else
		{
			test.log(LogStatus.FAIL,test.addScreenCapture(Shot.CaptureScreen())+ "Popular Questions Header is NOT Available");
		}
		
		// Popular Questions Entries Check
		List<WebElement> AllQuestions = driver.findElements(By.xpath("//div[contains(text(),'Popular questions')]//following :: div[contains(@class,'sc-dL')]"));
		System.out.println("Popular Questions Entries Total --->  "+AllQuestions.size());
		
		if(AllQuestions.size()==7)
		{
			for(int i =0;i<AllQuestions.size();i++)
			{
				String Entriescheck = AllQuestions.get(i).getText();
				System.out.println(Entriescheck);
				if(Entriescheck.isEmpty())
				{
					test.log(LogStatus.FAIL,test.addScreenCapture(Shot.CaptureScreen())+ "Popular Questions Content are missing");
				}
			}
		}
		else
		{
			test.log(LogStatus.FAIL,test.addScreenCapture(Shot.CaptureScreen())+ "Popular Questions Entries are missing");
		}
		
		
		// Financial Questions Entry
		if(PopularQuestions_Textarea.isDisplayed())
		{
			test.log(LogStatus.PASS,test.addScreenCapture(Shot.CaptureScreen())+ "PopularQuestions Textarea is Available");
			PopularQuestions_Textarea.sendKeys(props.getProperty("PopularQuestionsTextarea"));;
		}
		else
		{
			test.log(LogStatus.FAIL,test.addScreenCapture(Shot.CaptureScreen())+ "PopularQuestions Textarea is NOT Available");
		}
		
		// Save and Continue 
		if(Save_Continue_Btn.isDisplayed())
		{
			test.log(LogStatus.PASS,test.addScreenCapture(Shot.CaptureScreen())+ "Save and Continue is Available");
			Save_Continue_Btn.click();
		}
		else
		{
			test.log(LogStatus.FAIL,test.addScreenCapture(Shot.CaptureScreen())+ "Save and Continue is NOT Available");
		}
	}
	
}
