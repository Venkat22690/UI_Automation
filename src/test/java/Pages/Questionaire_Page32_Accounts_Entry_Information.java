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
		
		@FindBy(xpath = "//div[text()='Saving account(s)']")
		WebElement SavingAccount_Label;
		
		@FindBy(xpath = "//div[text()='Student loan account(s)']")
		WebElement StudentLoanAccount_Label;
		
		@FindBy(xpath = "//div[text()='Credit card(s)']")
		WebElement CreditCard_Label;
		
		@FindBy(xpath = "//div[text()='Mortgage account(s)']")
		WebElement MortgageAccount_Label;
		
		@FindBy(xpath = "//div[text()='Auto loan account(s)']")
		WebElement AutoLoanAccount_Label;
		
		@FindBy(xpath = "//div[text()='Other loan account(s)']")
		WebElement OtherLoanAccount_Label;
		
		@FindBy(xpath = "//div[text()='Retirement account(s)']")
		WebElement RetirementAccount_Label;
		
		@FindBy(xpath = "//div[text()='Investment account(s)']")
		WebElement InvestmentAccount_Label;
		
		@FindBy(xpath = "//div[text()='Cryptocurrency account(s)']")
		WebElement CryptoCurrencyAccount_Label;
		
		
		
		
		
		
		
		@FindBy(xpath = "(//div[text()='Checking account(s)']//following :: *[text()='Add Manually'])[1]")
		WebElement CheckingAccount_Add;
		
		@FindBy(xpath = "(//div[text()='Saving account(s)']//following :: *[text()='Add Manually'])[1]")
		WebElement SavingsAccount_Add;
		
		@FindBy(xpath = "(//div[text()='Student loan account(s)']//following :: *[text()='Add Manually'])[1]")
		WebElement StudentLoanAccount_Add;
		
		@FindBy(xpath = "(//div[text()='Credit card(s)']//following :: *[text()='Add Manually'])[1]")
		WebElement CreditCard_Add;
		
		@FindBy(xpath = "(//div[text()='Mortgage account(s)']//following :: *[text()='Add Manually'])[1]")
		WebElement MortgageAccount_Add;
		
		@FindBy(xpath = "(//div[text()='Auto loan account(s)']//following :: *[text()='Add Manually'])[1]")
		WebElement AutoLoanAccount_Add;
		
		@FindBy(xpath = "(//div[text()='Other loan account(s)']//following :: *[text()='Add Manually'])[1]")
		WebElement OtherLoanAccount_Add;
		
		@FindBy(xpath = "(//div[text()='Retirement account(s)']//following :: *[text()='Add Manually'])[1]")
		WebElement RetirementAccount_Add;
		
		@FindBy(xpath = "(//div[text()='Investment account(s)']//following :: *[text()='Add Manually'])[1]")
		WebElement InvestmentAccount_Add;
		
		@FindBy(xpath = "(//div[text()='Cryptocurrency account(s)']//following :: *[text()='Add Manually'])[1]")
		WebElement CryptoCurrencyAccount_Add;
		
		
		
		// Type 1
		@FindBy(xpath = "//input[@label='Provider']")
		WebElement Type1_Provider;
		
		@FindBy(xpath = "//input[@placeholder='Account balance']")
		WebElement Type1_AccountBalance;
		
		
		
		
		
		
		
		// Retirement 
		@FindBy(xpath = "//input[@label='Provider']")
		WebElement RetirementAccount_Provider;
		
		@FindBy(xpath = "//input[@label='Provider']//following :: select")
		WebElement RetirementAccount_AccountType;
		
		@FindBy(xpath = "//input[@label='Annual contribution']")
		WebElement RetirementAccount_AnnualContribution;
		
		@FindBy(xpath = "//input[@placeholder='Account balance']")
		WebElement RetirementAccount_Balance;
		
		
		
		// Type 2
		@FindBy(xpath = "//input[@label='Provider']")
		WebElement Account_Provider_Typ2;
		
		@FindBy(xpath = "//input[@placeholder='Interest rate']")
		WebElement Account_InterestRate;
		
		@FindBy(xpath = "//input[@placeholder='Monthly payment']")
		WebElement Account_Monthlypayment;
		
		@FindBy(xpath = "//input[@placeholder='Account balance']")
		WebElement Account_Balance_Typ2;
		
		@FindBy(xpath = "//input[@type='date']")
		WebElement  Account_EndDate;
		
		@FindBy(xpath = "//button[text()='Add Account']")
		WebElement Add_Account_Button_Type2;
		
		
		
		// Credit Card
		@FindBy(xpath = "//input[@label='Card name']")
		WebElement CreditCardName;
		
		@FindBy(xpath = "//input[@placeholder='Account balance']")
		WebElement CreditCardBalance;
		
		@FindBy(xpath = "//div[contains(text(),'Do you pay off this card in full every month?')]")
		WebElement CreditCardText;
		
		@FindBy(xpath = "//div[contains(text(),'Do you pay off this card in full every month?')]//following :: select")
		WebElement CreditCardSelectButton;
		
		
		@FindBy(xpath = "//input[@placeholder='Interest rate']")
		WebElement CreditCardInterestRate;
		
		@FindBy(xpath = "//input[@placeholder='Monthly payment']")
		WebElement CreditCardMonthlyPayment;
		
		
		// Common
		@FindBy(xpath = "//button[text()='Add Account']")
		WebElement Add_Account_Button;
		
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
		
		
		List<WebElement> AllAccounts = driver.findElements(By.xpath("//div[contains(text(),'Add your accounts')]//following :: *[contains(text(),'account(s)') or contains(text(),'card(s)')]"));
		
		for(int i=0;i<AllAccounts.size();i++)
		{
			String InputAccount = AllAccounts.get(i).getText();
			System.out.println(InputAccount);
			
			switch(InputAccount)
			{
					case "Checking account(s)":
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
							Thread.sleep(2000);
							Type1();
							
						}
						
						else
						{
							test.log(LogStatus.FAIL,test.addScreenCapture(Shot.CaptureScreen())+ "Checking Account Add Manually Option Selection is NOT Available");
						}
						
					break;
					
				case "Saving account(s)" :
					// Savings Account Label
					if(SavingAccount_Label.isDisplayed())
					{
						test.log(LogStatus.PASS,test.addScreenCapture(Shot.CaptureScreen())+ "Savings Account Label is Available");
					}
					else
					{
						test.log(LogStatus.FAIL,test.addScreenCapture(Shot.CaptureScreen())+ "Savings Account Label is NOT Available");
					}
					
					// Savings Account Add Manually Option Selection
					if(SavingsAccount_Add.isDisplayed())
					{
						test.log(LogStatus.PASS,test.addScreenCapture(Shot.CaptureScreen())+ "Savings Account Add Manually Option Selection is Available");
						SavingsAccount_Add.click();
						Thread.sleep(2000);
						Type1();
						
					}
					else
					{
						test.log(LogStatus.FAIL,test.addScreenCapture(Shot.CaptureScreen())+ "Savings Account Add Manually Option Selection is NOT Available");
					}
					
					break;	
					
				case "Student loan account(s)" :
					// Savings Account Label
					if(StudentLoanAccount_Label.isDisplayed())
					{
						test.log(LogStatus.PASS,test.addScreenCapture(Shot.CaptureScreen())+ "Student Loan Account Label is Available");
					}
					else
					{
						test.log(LogStatus.FAIL,test.addScreenCapture(Shot.CaptureScreen())+ "Student Loan Account Label is NOT Available");
					}
					
					// Student Loan Add Manually Option Selection
					if(StudentLoanAccount_Add.isDisplayed())
					{
						test.log(LogStatus.PASS,test.addScreenCapture(Shot.CaptureScreen())+ "Student Loan Account Add Manually Option Selection is Available");
						StudentLoanAccount_Add.click();
						Thread.sleep(2000);
						Type2();
						
					}
					else
					{
						test.log(LogStatus.FAIL,test.addScreenCapture(Shot.CaptureScreen())+ "Student Loan Account Add Manually Option Selection is NOT Available");
					}
					
					break;	
					
				case "Credit card(s)" :
					// Credit Card Label
					if(CreditCard_Label.isDisplayed())
					{
						test.log(LogStatus.PASS,test.addScreenCapture(Shot.CaptureScreen())+ "Credit card Label is Available");
					}
					else
					{
						test.log(LogStatus.FAIL,test.addScreenCapture(Shot.CaptureScreen())+ "Credit card Label is NOT Available");
					}
					
					// Credit Card Add Manually Option Selection
					if(CreditCard_Add.isDisplayed())
					{
						test.log(LogStatus.PASS,test.addScreenCapture(Shot.CaptureScreen())+ "Credit card Add Manually Option Selection is Available");
						CreditCard_Add.click();
						Thread.sleep(2000);
						CreditCardEntries();
						
					}
					else
					{
						test.log(LogStatus.FAIL,test.addScreenCapture(Shot.CaptureScreen())+ "Credit card Add Manually Option Selection is NOT Available");
					}
					
					break;	
					
				case "Mortgage account(s)" :
					// Mortgage account Label
					if(MortgageAccount_Label.isDisplayed())
					{
						test.log(LogStatus.PASS,test.addScreenCapture(Shot.CaptureScreen())+ "Mortgage account Label is Available");
					}
					else
					{
						test.log(LogStatus.FAIL,test.addScreenCapture(Shot.CaptureScreen())+ "Mortgage account Label is NOT Available");
					}
					
					// Mortgage account Add Manually Option Selection
					if(MortgageAccount_Add.isDisplayed())
					{
						test.log(LogStatus.PASS,test.addScreenCapture(Shot.CaptureScreen())+ "Mortgage account Add Manually Option Selection is Available");
						MortgageAccount_Add.click();
						Thread.sleep(2000);
						Type2();
						
					}
					else
					{
						test.log(LogStatus.FAIL,test.addScreenCapture(Shot.CaptureScreen())+ "Mortgage Account Add Manually Option Selection is NOT Available");
					}
					
					break;	
					
				case "Auto loan account(s)" :
					// Auto loan account Label
					if(AutoLoanAccount_Label.isDisplayed())
					{
						test.log(LogStatus.PASS,test.addScreenCapture(Shot.CaptureScreen())+ "Auto loan account Label is Available");
					}
					else
					{
						test.log(LogStatus.FAIL,test.addScreenCapture(Shot.CaptureScreen())+ "Auto loan account Label is NOT Available");
					}
					
					// Auto loan account Add Manually Option Selection
					if(AutoLoanAccount_Add.isDisplayed())
					{
						test.log(LogStatus.PASS,test.addScreenCapture(Shot.CaptureScreen())+ "Auto loan account Add Manually Option Selection is Available");
						AutoLoanAccount_Add.click();
						Thread.sleep(2000);
						Type2();
						
					}
					else
					{
						test.log(LogStatus.FAIL,test.addScreenCapture(Shot.CaptureScreen())+ "Auto loan Account Add Manually Option Selection is NOT Available");
					}
					
					break;
					
					
				case "Other loan account(s)" :
					// Other loan account Label
					if(OtherLoanAccount_Label.isDisplayed())
					{
						test.log(LogStatus.PASS,test.addScreenCapture(Shot.CaptureScreen())+ "Other loan account Label is Available");
					}
					else
					{
						test.log(LogStatus.FAIL,test.addScreenCapture(Shot.CaptureScreen())+ "Other loan account Label is NOT Available");
					}
					
					// Other loan account Add Manually Option Selection
					if(OtherLoanAccount_Add.isDisplayed())
					{
						test.log(LogStatus.PASS,test.addScreenCapture(Shot.CaptureScreen())+ "Other loan account Add Manually Option Selection is Available");
						OtherLoanAccount_Add.click();
						Thread.sleep(2000);
						Type2();
						
					}
					else
					{
						test.log(LogStatus.FAIL,test.addScreenCapture(Shot.CaptureScreen())+ "Other loan Account Add Manually Option Selection is NOT Available");
					}
					
					break;	
					
				case "Retirement account(s)" :
					// Retirement account Label
					if(RetirementAccount_Label.isDisplayed())
					{
						test.log(LogStatus.PASS,test.addScreenCapture(Shot.CaptureScreen())+ "Retirement account Label is Available");
					}
					else
					{
						test.log(LogStatus.FAIL,test.addScreenCapture(Shot.CaptureScreen())+ "Retirement account Label is NOT Available");
					}
					
					// Retirement account Add Manually Option Selection
					if(RetirementAccount_Add.isDisplayed())
					{
						test.log(LogStatus.PASS,test.addScreenCapture(Shot.CaptureScreen())+ "Retirement account Add Manually Option Selection is Available");
						RetirementAccount_Add.click();
						Thread.sleep(2000);
						RetirementAccountEntries();
						
					}
					else
					{
						test.log(LogStatus.FAIL,test.addScreenCapture(Shot.CaptureScreen())+ "Retirement Account Add Manually Option Selection is NOT Available");
					}
					
					break;	
					
				case "Investment account(s)" :
					// Investment account Label
					if(InvestmentAccount_Label.isDisplayed())
					{
						test.log(LogStatus.PASS,test.addScreenCapture(Shot.CaptureScreen())+ "Investment account Label is Available");
					}
					else
					{
						test.log(LogStatus.FAIL,test.addScreenCapture(Shot.CaptureScreen())+ "Investment account Label is NOT Available");
					}
					
					// Investment account Add Manually Option Selection
					if(InvestmentAccount_Add.isDisplayed())
					{
						test.log(LogStatus.PASS,test.addScreenCapture(Shot.CaptureScreen())+ "Investment account Add Manually Option Selection is Available");
						InvestmentAccount_Add.click();
						Thread.sleep(2000);
						Type1();
						
					}
					else
					{
						test.log(LogStatus.FAIL,test.addScreenCapture(Shot.CaptureScreen())+ "Investment Account Add Manually Option Selection is NOT Available");
					}
					
					break;	
					
				case "Cryptocurrency account(s)" :
					// Cryptocurrency account Label
					if(CryptoCurrencyAccount_Label.isDisplayed())
					{
						test.log(LogStatus.PASS,test.addScreenCapture(Shot.CaptureScreen())+ "Cryptocurrency account Label is Available");
					}
					else
					{
						test.log(LogStatus.FAIL,test.addScreenCapture(Shot.CaptureScreen())+ "Cryptocurrency account Label is NOT Available");
					}
					
					// Cryptocurrency account Add Manually Option Selection
					if(CryptoCurrencyAccount_Add.isDisplayed())
					{
						test.log(LogStatus.PASS,test.addScreenCapture(Shot.CaptureScreen())+ "Cryptocurrency account Add Manually Option Selection is Available");
						CryptoCurrencyAccount_Add.click();
						Thread.sleep(2000);
						Type1();
						
					}
					else
					{
						test.log(LogStatus.FAIL,test.addScreenCapture(Shot.CaptureScreen())+ "Cryptocurrency Account Add Manually Option Selection is NOT Available");
					}
					
					
					break;	
		  }
		}
		
	
		// Save and Continue 
		if(Save_Continue_Button.isDisplayed())
		{
			test.log(LogStatus.PASS,test.addScreenCapture(Shot.CaptureScreen())+ "Lets Go is Available");
			Thread.sleep(2000);		
			Save_Continue_Button.click();
		}
		else
		{
			test.log(LogStatus.FAIL,test.addScreenCapture(Shot.CaptureScreen())+ "Lets Go is NOT Available");
		}
	}
	

 
	public void Type1() throws IOException
	{
		// Account Entries
		if(Type1_Provider.isDisplayed()  && Type1_AccountBalance.isDisplayed())
		{
			test.log(LogStatus.PASS,test.addScreenCapture(Shot.CaptureScreen())+ "Account Entries is Available");
			Type1_Provider.sendKeys(props.getProperty("AccountProvider"));
			Type1_AccountBalance.sendKeys(props.getProperty("AccountAmount"));
			
		}
		else
		{
			test.log(LogStatus.FAIL,test.addScreenCapture(Shot.CaptureScreen())+ "Account Entries NOT Available");
		}
		
		// Account Add Account Button
		if(Add_Account_Button.isDisplayed())
		{
			test.log(LogStatus.PASS,test.addScreenCapture(Shot.CaptureScreen())+ "Account Add Account Button after Update the amount  is Available");
			Add_Account_Button.click();
		}
		else
		{
			test.log(LogStatus.FAIL,test.addScreenCapture(Shot.CaptureScreen())+ "Account Add Account Button after Update the amount  is NOT Available");
		}
		

	}
	
	public void Type2() throws InterruptedException, IOException
	{
		// Account Entries
		if(Account_Provider_Typ2.isDisplayed()  && Account_Balance_Typ2.isDisplayed() && Account_InterestRate.isDisplayed() && Account_Monthlypayment.isDisplayed() && Account_EndDate.isDisplayed())
		{
			Thread.sleep(2000);
			test.log(LogStatus.PASS,test.addScreenCapture(Shot.CaptureScreen())+ "Retirement Account Entries is Available");
			Account_Provider_Typ2.sendKeys(props.getProperty("AccountProvider"));
			Account_InterestRate.sendKeys(props.getProperty("AccountInterestRate")); 
			Account_Balance_Typ2.sendKeys(props.getProperty("AccountBalance")); 
			Account_Monthlypayment.sendKeys(props.getProperty("AccountMonthlypayment")); 
			Account_EndDate.sendKeys("22"); 
			Account_EndDate.sendKeys("12"); 
			Account_EndDate.sendKeys("2045"); 
			
		}
		else
		{
			test.log(LogStatus.FAIL,test.addScreenCapture(Shot.CaptureScreen())+ "Account Entries NOT Available");
		}
		
		// Account Add Account Button
		if(Add_Account_Button.isDisplayed())
		{
			test.log(LogStatus.PASS,test.addScreenCapture(Shot.CaptureScreen())+ "Account Add Account Button after Update the amount  is Available");
			Add_Account_Button.click();
		}
		else
		{
			test.log(LogStatus.FAIL,test.addScreenCapture(Shot.CaptureScreen())+ "Account Add Account Button after Update the amount  is NOT Available");
		}
		
	}
	
	public void CreditCardEntries() throws InterruptedException, IOException
	{
		// Account Entries
			if(CreditCardBalance.isDisplayed()  && CreditCardName.isDisplayed() && CreditCardText.isDisplayed() && CreditCardInterestRate.isDisplayed() && CreditCardMonthlyPayment.isDisplayed())
			{
				Thread.sleep(2000);
				test.log(LogStatus.PASS,test.addScreenCapture(Shot.CaptureScreen())+ "Credit Card Entries is Available");
				CreditCardName.sendKeys(props.getProperty("AccountProvider"));
				CreditCardBalance.sendKeys(props.getProperty("AccountBalance")); 
				Select sc = new Select(CreditCardSelectButton);
				sc.selectByValue("true");
				
				CreditCardInterestRate.sendKeys(props.getProperty("AccountInterestRate")); 
				CreditCardMonthlyPayment.sendKeys(props.getProperty("AccountMonthlypayment")); 
				
			}
			else
			{
				test.log(LogStatus.FAIL,test.addScreenCapture(Shot.CaptureScreen())+ "Credit Card Entries NOT Available");
			}
			
			// Account Add Account Button
			if(Add_Account_Button.isDisplayed())
			{
				test.log(LogStatus.PASS,test.addScreenCapture(Shot.CaptureScreen())+ "Account Add Account Button after Update the amount  is Available");
				Add_Account_Button.click();
			}
			else
			{
				test.log(LogStatus.FAIL,test.addScreenCapture(Shot.CaptureScreen())+ "Account Add Account Button after Update the amount  is NOT Available");
			}
			
	}
	
	public void RetirementAccountEntries() throws InterruptedException, IOException
	{
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
			
			// Account Add Account Button
			if(Add_Account_Button.isDisplayed())
			{
				test.log(LogStatus.PASS,test.addScreenCapture(Shot.CaptureScreen())+ "Account Add Account Button after Update the amount  is Available");
				Add_Account_Button.click();
			}
			else
			{
				test.log(LogStatus.FAIL,test.addScreenCapture(Shot.CaptureScreen())+ "Account Add Account Button after Update the amount  is NOT Available");
			}
			
	}

}
