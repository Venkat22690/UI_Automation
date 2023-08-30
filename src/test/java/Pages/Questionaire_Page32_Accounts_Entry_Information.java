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
import org.openqa.selenium.support.ui.Select;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import ExtentReports.CaptureScreens;


public class Questionaire_Page32_Accounts_Entry_Information {
	WebDriver driver;
	public ExtentReports report;
	public ExtentTest test;
	CaptureScreens Shot;
	static Properties props = new Properties();
	static String propsFilepath = "/src/test/resources/Config.properties";
	
	// Object Repositories 
		
		@FindBy(xpath = "//div[text()='ACCOUNTS']")
		WebElement AboutYouTitle;
		
		@FindBy(xpath = "//div[contains(text(),'Add your accounts')]")
		WebElement ÁccountsSelection_Label;
		
		@FindBy(xpath = "//div[contains(text(),'To know what to recommend we need to understand the details of your current situation.')]")
		WebElement ÁccountsSelection_Sub_Label;
		
		
		@FindBy(xpath = "//div[text()='Checking account(s)']")
		WebElement CheckingAccount_Label;
		
		@FindBy(xpath = "(//div[text()='Checking account(s)']//following :: *[text()='Add Manually'])[1]")
		WebElement CheckingAccount_Add;
		
		@FindBy(xpath = "//input[@label='Provider']")
		WebElement CheckingAccount_Provider;
		
		@FindBy(xpath = "//input[@placeholder='Account balance']")
		WebElement CheckingAccount_Balance;
		
		@FindBy(xpath = "//button[text()='Add Account']")
		WebElement CheckingAccount_Add_Account_Button;
		
		
		
		@FindBy(xpath = "//div[text()='Retirement account(s)']")
		WebElement RetirementAccount_Label;
		
		@FindBy(xpath = "(//div[text()='Retirement account(s)']//following :: *[text()='Add Manually'])[1]")
		WebElement RetirementAccount_Add;
		
		@FindBy(xpath = "//input[@label='Provider']")
		WebElement RetirementAccount_Provider;
		
		@FindBy(xpath = "//input[@label='Provider']//following :: select")
		WebElement RetirementAccount_AccountType;
		
		@FindBy(xpath = "//input[@label='Annual contribution']")
		WebElement RetirementAccount_AnnualContribution;
		
		@FindBy(xpath = "//input[@placeholder='Account balance']")
		WebElement RetirementAccount_Balance;
		
		@FindBy(xpath = "//button[text()='Add Account']")
		WebElement Retirement_Add_Account_Button;
		
		
		@FindBy(xpath = "//div[text()='Mortgage account(s)']")
		WebElement MortgageAccount_Label;
		
		@FindBy(xpath = "(//div[text()='Mortgage account(s)']//following :: *[text()='Add Manually'])[1]")
		WebElement MortgageAccount_Add;
		
		@FindBy(xpath = "//input[@label='Provider']")
		WebElement MortgageAccount_Provider;
		
		@FindBy(xpath = "//input[@placeholder='Interest rate']")
		WebElement MortgageAccount_InterestRate;
		
		@FindBy(xpath = "//input[@placeholder='Monthly payment']")
		WebElement MortgageAccount_Monthlypayment;
		
		@FindBy(xpath = "//input[@placeholder='Account balance']")
		WebElement MortgageAccount_Balance;
		
		@FindBy(xpath = "//input[@type='date']")
		WebElement MortgageAccount_EndDate;
		
		@FindBy(xpath = "//button[text()='Add Account']")
		WebElement Mortgage_Add_Account_Button;
		
		
		@FindBy(xpath = "//button//div[text()='Save and continue']")
		WebElement Save_Continue_Button;
		
		
		
		
	
	// End of Object Repositories 
	
	
	public Questionaire_Page32_Accounts_Entry_Information(WebDriver driver,ExtentReports report,ExtentTest test) throws IOException
	{
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + propsFilepath);
		props.load(fis);
		Shot = new CaptureScreens(driver);
		this.driver = driver;
		this.report = report;
		this.test = test;
		PageFactory.initElements(driver, this);
		
	}

	public void Questionaire_Accounts_Entry_Information() throws IOException, InterruptedException
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
		
		// Account Selection
		if(ÁccountsSelection_Label.isDisplayed())
		{
			test.log(LogStatus.PASS,test.addScreenCapture(Shot.CaptureScreen())+ "Account Selection label is Available");
		}
		else
		{
			test.log(LogStatus.FAIL,test.addScreenCapture(Shot.CaptureScreen())+ "Account Selection label is NOT Available");
		}
		
		// Account Selection Sub Label
		if(ÁccountsSelection_Sub_Label.isDisplayed())
		{
			test.log(LogStatus.PASS,test.addScreenCapture(Shot.CaptureScreen())+ "Account Selection Sub Label is Available");
		}
		else
		{
			test.log(LogStatus.FAIL,test.addScreenCapture(Shot.CaptureScreen())+ "Account Selection Sub Label is NOT Available");
		}
		
		// Checking Account Label
		if(CheckingAccount_Label.isDisplayed())
		{
			test.log(LogStatus.PASS,test.addScreenCapture(Shot.CaptureScreen())+ "Checking Account Label is Available");
		}
		else
		{
			test.log(LogStatus.FAIL,test.addScreenCapture(Shot.CaptureScreen())+ "Checking Account Label is NOT Available");
		}
		
		// Checking Account Add Manually Option Selection
		if(CheckingAccount_Add.isDisplayed())
		{
			test.log(LogStatus.PASS,test.addScreenCapture(Shot.CaptureScreen())+ "Checking Account Add Manually Option Selection is Available");
			CheckingAccount_Add.click();
		}
		else
		{
			test.log(LogStatus.FAIL,test.addScreenCapture(Shot.CaptureScreen())+ "Checking Account Add Manually Option Selection is NOT Available");
		}
		
		// Checking Account Entries
		if(CheckingAccount_Provider.isDisplayed()  && CheckingAccount_Balance.isDisplayed())
		{
			test.log(LogStatus.PASS,test.addScreenCapture(Shot.CaptureScreen())+ "Checking Account Entries is Available");
			CheckingAccount_Provider.sendKeys(props.getProperty("CheckingAccountProvider"));
			CheckingAccount_Balance.sendKeys(props.getProperty("CheckingAccountAmount"));
			
		}
		else
		{
			test.log(LogStatus.FAIL,test.addScreenCapture(Shot.CaptureScreen())+ "Checking Account Entries NOT Available");
		}
		
		
		// Checking Account Add Account Button
		if(CheckingAccount_Add_Account_Button.isDisplayed())
		{
			test.log(LogStatus.PASS,test.addScreenCapture(Shot.CaptureScreen())+ "Checking Account Add Account Button after Update the amount  is Available");
			CheckingAccount_Add_Account_Button.click();
		}
		else
		{
			test.log(LogStatus.FAIL,test.addScreenCapture(Shot.CaptureScreen())+ "Checking Account Add Account Button after Update the amount  is NOT Available");
		}
		
		
		
		
		// Mortgage Account Label
		if(MortgageAccount_Label.isDisplayed())
		{
			test.log(LogStatus.PASS,test.addScreenCapture(Shot.CaptureScreen())+ "Mortgage Account Label is Available");
		}
		else
		{
			test.log(LogStatus.FAIL,test.addScreenCapture(Shot.CaptureScreen())+ "Mortgage Account Label is NOT Available");
		}
		
		// Mortgage Account Add Click
		if(MortgageAccount_Add.isDisplayed())
		{
			test.log(LogStatus.PASS,test.addScreenCapture(Shot.CaptureScreen())+ "Mortgage Account Add Manually Option Selection is Available");
			MortgageAccount_Add.click();
		}
		else
		{
			test.log(LogStatus.FAIL,test.addScreenCapture(Shot.CaptureScreen())+ "Mortgage Account Add Manually Option Selection is NOT Available");
		}
		
		// Mortgage Account Entries
		if(MortgageAccount_Provider.isDisplayed()  && MortgageAccount_Balance.isDisplayed() && MortgageAccount_InterestRate.isDisplayed() && MortgageAccount_Monthlypayment.isDisplayed() && MortgageAccount_EndDate.isDisplayed())
		{
			Thread.sleep(2000);
			test.log(LogStatus.PASS,test.addScreenCapture(Shot.CaptureScreen())+ "Retirement Account Entries is Available");
			MortgageAccount_Provider.sendKeys(props.getProperty("MortgageAccountProvider"));
			MortgageAccount_InterestRate.sendKeys(props.getProperty("MortgageAccountInterestRate")); 
			MortgageAccount_Balance.sendKeys(props.getProperty("MortgageAccountBalance")); 
			MortgageAccount_Monthlypayment.sendKeys(props.getProperty("MortgageAccountMonthlypayment")); 
			MortgageAccount_EndDate.sendKeys("22"); 
			MortgageAccount_EndDate.sendKeys("12"); 
			MortgageAccount_EndDate.sendKeys("2045"); 
			
		}
		else
		{
			test.log(LogStatus.FAIL,test.addScreenCapture(Shot.CaptureScreen())+ "Retirement Account Entries NOT Available");
		}
		
		
		// Mortage Account Add Account Button
		if(Mortgage_Add_Account_Button.isDisplayed())
		{
			test.log(LogStatus.PASS,test.addScreenCapture(Shot.CaptureScreen())+ "Retirement Account Add Account Button after Update the amount  is Available");
			Mortgage_Add_Account_Button.click();
		}
		else
		{
			test.log(LogStatus.FAIL,test.addScreenCapture(Shot.CaptureScreen())+ "Retirement Account Add Account Button after Update the amount  is NOT Available");
		}
		
	
		
		// Retirement Account Label
		if(RetirementAccount_Label.isDisplayed())
		{
			test.log(LogStatus.PASS,test.addScreenCapture(Shot.CaptureScreen())+ "Retirement Account Label is Available");
		}
		else
		{
			test.log(LogStatus.FAIL,test.addScreenCapture(Shot.CaptureScreen())+ "Retirement Account Label is NOT Available");
		}
		
		// Retirement Account Add Click
		if(RetirementAccount_Add.isDisplayed())
		{
			test.log(LogStatus.PASS,test.addScreenCapture(Shot.CaptureScreen())+ "Retirement Account Add Manually Option Selection is Available");
			RetirementAccount_Add.click();
		}
		else
		{
			test.log(LogStatus.FAIL,test.addScreenCapture(Shot.CaptureScreen())+ "Retirement Account Add Manually Option Selection is NOT Available");
		}
		
		// Retirement Account Entries
		if(RetirementAccount_Provider.isDisplayed()  && RetirementAccount_AccountType.isDisplayed() && RetirementAccount_AnnualContribution.isDisplayed() && RetirementAccount_Balance.isDisplayed())
		{
			Thread.sleep(2000);
			test.log(LogStatus.PASS,test.addScreenCapture(Shot.CaptureScreen())+ "Retirement Account Entries is Available");
			RetirementAccount_Provider.sendKeys(props.getProperty("RetirementAccountProvider"));
			RetirementAccount_AccountType.click();
			Select sc = new Select(RetirementAccount_AccountType);
			sc.selectByValue(props.getProperty("RetirementAccountType"));
			
			RetirementAccount_AnnualContribution.sendKeys(props.getProperty("RetirementAccountAnnualContribution")); 
			RetirementAccount_Balance.sendKeys(props.getProperty("RetirementAccountBalance")); 
			
		}
		else
		{
			test.log(LogStatus.FAIL,test.addScreenCapture(Shot.CaptureScreen())+ "Retirement Account Entries NOT Available");
		}
		
		
		// Retirement Account Add Account Button
		if(Retirement_Add_Account_Button.isDisplayed())
		{
			test.log(LogStatus.PASS,test.addScreenCapture(Shot.CaptureScreen())+ "Retirement Account Add Account Button after Update the amount  is Available");
			Retirement_Add_Account_Button.click();
		}
		else
		{
			test.log(LogStatus.FAIL,test.addScreenCapture(Shot.CaptureScreen())+ "Retirement Account Add Account Button after Update the amount  is NOT Available");
		}
		
		
		// Save and Continue 
		if(Save_Continue_Button.isDisplayed())
		{
			test.log(LogStatus.PASS,test.addScreenCapture(Shot.CaptureScreen())+ "Lets Go is Available");
			Thread.sleep(2000);		Save_Continue_Button.click();
		}
		else
		{
			test.log(LogStatus.FAIL,test.addScreenCapture(Shot.CaptureScreen())+ "Lets Go is NOT Available");
		}
	}
	
}
