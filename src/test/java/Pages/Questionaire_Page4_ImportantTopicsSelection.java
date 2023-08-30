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


public class Questionaire_Page4_ImportantTopicsSelection {
	WebDriver driver;
	public ExtentReports report;
	public ExtentTest test;
	CaptureScreens Shot;
	static Properties props = new Properties();
	static String propsFilepath = "/src/test/resources/Config.properties";
	
	// Object Repositories 
		
		@FindBy(xpath = "//div[text()='ABOUT YOU']")
		WebElement AboutYouTitle;
		
		@FindBy(xpath = "//div[text()='Are there other topics that are important to you?']")
		WebElement Questionaire_Page4_Title;
		
		@FindBy(xpath = "//div[contains(text(),'Select up to 3.')]")
		WebElement SelectionLimit_Label;
		
		//@FindBy(xpath = "//div[@class='sc-lfYzqA daajGJ']")
		// By TopicsList;

		@FindBy(xpath = "//div[contains(text(),'Building credit')]//preceding:: img[contains(@src,'check')]")
		WebElement BuildingCredit_CheckBox;
		
		@FindBy(xpath = "//div[contains(text(),'Paying down debt')]//preceding:: img[contains(@src,'check')][1]")
		WebElement PaymentdownDebt_CheckBox;
		
		@FindBy(xpath = "//div[contains(text(),'Travel rewards')]//preceding:: img[contains(@src,'check')][1]")
		WebElement TotalRewards_CheckBox;
		
		@FindBy(xpath = "//div[contains(text(),'Any specific questions about the above that you haven’t already mentioned?')]")
		WebElement Additional_Customized_Topic_Label;
		
		@FindBy(xpath = "//input[@type='text']")
		WebElement Additional_Customized_Topic_Entry;
		
		@FindBy(xpath = "//button//div[text()='Save and continue']")
		WebElement Save_Continue_Button;
		
		
	
	// End of Object Repositories 
	
	public Questionaire_Page4_ImportantTopicsSelection(WebDriver driver,ExtentReports report,ExtentTest test) throws IOException
	{
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + propsFilepath);
		props.load(fis);
		Shot = new CaptureScreens(driver);
		this.driver = driver;
		this.report = report;
		this.test = test;
		PageFactory.initElements(driver, this);
		
	}
	
	public void Questionaire_ImportantTopicsSelection() throws IOException, InterruptedException
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
		 
		// Topic Selection Page
		if(Questionaire_Page4_Title.isDisplayed())
		{
			test.log(LogStatus.PASS,test.addScreenCapture(Shot.CaptureScreen())+ "Topic Selection Page Title is Available");
		}
		else
		{
			test.log(LogStatus.FAIL,test.addScreenCapture(Shot.CaptureScreen())+ "Topic Selection Page Title is NOT Available");
		}
		
		// Topic Selection Page
		if(SelectionLimit_Label.isDisplayed())
		{
			test.log(LogStatus.PASS,test.addScreenCapture(Shot.CaptureScreen())+ "Selection Limit label is Available");
		}
		else
		{
			test.log(LogStatus.FAIL,test.addScreenCapture(Shot.CaptureScreen())+ "Selection Limit label is NOT Available");
		}
		
		// Important Entries Check
		/* List<WebElement> TopicList = driver.findElements(TopicsList);
		for(int i =0;i<TopicList.size();i++)
		{
			String Entriescheck = TopicList.get(i).getText();
			System.out.println(Entriescheck);
			if(Entriescheck.isEmpty())
			{
				test.log(LogStatus.FAIL,test.addScreenCapture(Shot.CaptureScreen())+ "Important Topic Entries are missing");
			}
		}
		*/
		
		// Building Credit Entry Select
		if(BuildingCredit_CheckBox.isDisplayed())
		{
			test.log(LogStatus.PASS,test.addScreenCapture(Shot.CaptureScreen())+ "Building Credit Checkbox is Available");
			BuildingCredit_CheckBox.click();
		}
		else
		{
			test.log(LogStatus.FAIL,test.addScreenCapture(Shot.CaptureScreen())+ "Building Credit Checkbox is NOT Available");
		}
		
		// Payment Down Debt Entry Select
		if(PaymentdownDebt_CheckBox.isDisplayed())
		{
			test.log(LogStatus.PASS,test.addScreenCapture(Shot.CaptureScreen())+ "PaymentdownDebt Checkbox is Available");
			PaymentdownDebt_CheckBox.click();
		}
		else
		{
			test.log(LogStatus.FAIL,test.addScreenCapture(Shot.CaptureScreen())+ "PaymentdownDebt Checkbox is NOT Available");
		}
		
		// Total Rewards Entry Select
		if(TotalRewards_CheckBox.isDisplayed())
		{
			test.log(LogStatus.PASS,test.addScreenCapture(Shot.CaptureScreen())+ "Total Rewards Checkbox is Available");
			TotalRewards_CheckBox.click();
		}
		else
		{
			test.log(LogStatus.FAIL,test.addScreenCapture(Shot.CaptureScreen())+ "Total Rewards Checkbox is NOT Available");
		}
		
		// Additional_Customized_Topic_Label & Additional_Customized_Topic_Entry
		if(Additional_Customized_Topic_Label.isDisplayed() && Additional_Customized_Topic_Entry.isDisplayed())
		{
			test.log(LogStatus.PASS,test.addScreenCapture(Shot.CaptureScreen())+ "Additional Customized Topic Label and Entry is Available");
			Additional_Customized_Topic_Entry.sendKeys(props.getProperty("AdditionalTopics"));
		}
		else
		{
			test.log(LogStatus.FAIL,test.addScreenCapture(Shot.CaptureScreen())+ "Additional Customized Topic Label and Entry is NOT Available");
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
