package Pages;


import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.util.Date;
import java.util.Properties;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import ExtentReports.CaptureScreens;


public class PaymentPage_And_WelcomePage {
	WebDriver driver;
	public ExtentReports report;
	public ExtentTest test;
	CaptureScreens Shot;
	static Properties props = new Properties();
	static String propsFilepath = "/src/test/resources/Config.properties";
	
	// Object Repositories 
	
			@FindBy(xpath = "//div[text()='Choose your plan']")
			WebElement AboutYouTitle;
			
			@FindBy(xpath = "(//div[text()='MOST POPULAR']//following :: *[text()='$16']//following :: *[text()='All for $189/year']//following :: *[text()='Get started'])[1]")
			WebElement MostPopular_GetStarted;
			
			@FindBy(xpath = "(//div[text()='MOST POPULAR']//following :: *[text()='$16']//following :: *[contains(text(),'189')])[1]")
			WebElement MostPopular_PaymentAmount;
			
			@FindBy(xpath = "(//span[text()='Total due today']//following ::span)[1]")
			WebElement TotalAmount; // Check is this total amount
			
			@FindBy(xpath = "//input[@name='email']")
			WebElement PaymentEmail_Entry; 
			
			@FindBy(xpath = "//input[@name='cardNumber']")
			WebElement PaymentCardNumber_Entry; 
			
			@FindBy(xpath = "//input[@name='cardExpiry']")
			WebElement PaymentCardExpiry_Entry; 
			
			@FindBy(xpath = "//input[@name='cardCvc']")
			WebElement PaymentCVV_Entry; 
			
			@FindBy(xpath = "//input[@name='billingName']")
			WebElement PaymentBillingName_Entry; 
					
			@FindBy(xpath = "//button[@type='submit' and contains(@class,'SubmitButton')]")
			WebElement Subscribe_Button; 
			
			@FindBy(xpath = "//span[contains(text(),'Welcome to')]")
			WebElement Welcome_Message; 
			
			@FindBy(xpath = "//button[text()='Let’s keep going']")
			WebElement Welcome_Message_Btn; 
			
		
		
		// End of Object Repositories 
			
	String PaymentAmount;
	
	
	
	public PaymentPage_And_WelcomePage(WebDriver driver,ExtentReports report,ExtentTest test) throws IOException
	{
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + propsFilepath);
		props.load(fis);
		Shot = new CaptureScreens(driver);
		this.driver = driver;
		this.report = report;
		this.test = test;
		PageFactory.initElements(driver, this);
		
	}
	
	public void PaymentAndWelcome() throws IOException, InterruptedException, AWTException
	{
		
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));	
		Thread.sleep(4000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='Choose your plan']")));
		
		// page Title
		if(AboutYouTitle.isDisplayed())
		{
			test.log(LogStatus.PASS,test.addScreenCapture(Shot.CaptureScreen())+ "Page Title is Available");
		}
		else
		{
			test.log(LogStatus.FAIL,test.addScreenCapture(Shot.CaptureScreen())+ "Page Title is NOT Available");
		}
		
		PaymentAmount = MostPopular_PaymentAmount.getText();
		System.out.println(PaymentAmount);
		PaymentAmount = PaymentAmount.replaceAll("[^0-9]","");
		System.out.println(PaymentAmount);
		
		// Selecting the Payment Amount
		if(MostPopular_GetStarted.isDisplayed())
		{
			test.log(LogStatus.PASS,test.addScreenCapture(Shot.CaptureScreen())+ "Payment Button is Available");
			MostPopular_GetStarted.click();
		}
		else
		{
			test.log(LogStatus.FAIL,test.addScreenCapture(Shot.CaptureScreen())+ "Payment Button is NOT Available");
		}
		
		
		// Payment Gateway page  *************************
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(25));	
		// WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		Thread.sleep(9000);
		// wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//span[text()='Total due today']//following ::span)[1]")));
		
		String PaymentPageAmount = TotalAmount.getText();
		System.out.println(PaymentPageAmount);
		PaymentPageAmount = PaymentPageAmount.replaceAll("\\.0*$", "");
		PaymentPageAmount = PaymentPageAmount.replaceAll("[^0-9]", "");
		
		System.out.println(PaymentPageAmount);
		
		if(PaymentPageAmount.equals(PaymentAmount))
		{
			test.log(LogStatus.PASS,test.addScreenCapture(Shot.CaptureScreen())+ "Payment Amount are matching");
		}
		else
		{
			test.log(LogStatus.FAIL,test.addScreenCapture(Shot.CaptureScreen())+ "Payment Amount are NOT matching");
		}
		
		// Email Address
		if(PaymentEmail_Entry.isDisplayed())
		{
			test.log(LogStatus.PASS,test.addScreenCapture(Shot.CaptureScreen())+ "Payment Email Entry is Available");
			PaymentEmail_Entry.sendKeys(props.getProperty("EmailforPayment"));
		}
		else
		{
			test.log(LogStatus.FAIL,test.addScreenCapture(Shot.CaptureScreen())+ "Payment Email Entry is NOT Available");
		}
		
		// Card Number
		if(PaymentCardNumber_Entry.isDisplayed())
		{
			test.log(LogStatus.PASS,test.addScreenCapture(Shot.CaptureScreen())+ "Payment CardNumber Entry is Available");
			PaymentCardNumber_Entry.sendKeys(props.getProperty("CardNumber"));
		}
		else
		{
			test.log(LogStatus.FAIL,test.addScreenCapture(Shot.CaptureScreen())+ "Payment CardNumber Entry is NOT Available");
		}
		
		// Expiry Date
		if(PaymentCardExpiry_Entry.isDisplayed())
		{
			test.log(LogStatus.PASS,test.addScreenCapture(Shot.CaptureScreen())+ "Payment Card Expiry Entry is Available");
			PaymentCardExpiry_Entry.sendKeys(props.getProperty("ExpiryDate"));
		}
		else
		{
			test.log(LogStatus.FAIL,test.addScreenCapture(Shot.CaptureScreen())+ "Payment Card Expiry Entry is NOT Available");
		}
		
		// CVV Entry
		if(PaymentCVV_Entry.isDisplayed())
		{
			test.log(LogStatus.PASS,test.addScreenCapture(Shot.CaptureScreen())+ "Payment CVV Entry is Available");
			PaymentCVV_Entry.sendKeys(props.getProperty("CVV"));
		}
		else
		{
			test.log(LogStatus.FAIL,test.addScreenCapture(Shot.CaptureScreen())+ "Payment CVV Entry is NOT Available");
		}
		
		// Name
		if(PaymentBillingName_Entry.isDisplayed())
		{
			test.log(LogStatus.PASS,test.addScreenCapture(Shot.CaptureScreen())+ "PaymentBillingName Entry is Available");
			PaymentBillingName_Entry.sendKeys(props.getProperty("BillingName"));
		}
		else
		{
			test.log(LogStatus.FAIL,test.addScreenCapture(Shot.CaptureScreen())+ "PaymentBillingName Entry is NOT Available");
		}
		
		// Subscribe Button Click
		if(Subscribe_Button.isDisplayed())
		{
			test.log(LogStatus.PASS,test.addScreenCapture(Shot.CaptureScreen())+ "Subscribe Button Entry is Available");
			Thread.sleep(2000);
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
			Thread.sleep(2000);
			js.executeScript("arguments[0].click();", Subscribe_Button);
			// Subscribe_Button.click();
		}
		else
		{
			test.log(LogStatus.FAIL,test.addScreenCapture(Shot.CaptureScreen())+ "Subscribe Button Entry is NOT Available");
		}
		
		
		
		/// Welcome Page **************
		Thread.sleep(9000);
		Thread.sleep(4000);
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(25));	
		// WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Welcome to')]")));
				
		// Welcome Page
		if(Welcome_Message.isDisplayed())
		{
			test.log(LogStatus.PASS,test.addScreenCapture(Shot.CaptureScreen())+ "Welcome Page Landed Successfully");
		}
		else
		{
			test.log(LogStatus.FAIL,test.addScreenCapture(Shot.CaptureScreen())+ "Welcome Page NOT Available");
		}
		
		// Welcome Lets go Button
		if(Welcome_Message_Btn.isDisplayed())
		{
			test.log(LogStatus.PASS,test.addScreenCapture(Shot.CaptureScreen())+ "Welcome Lets go Button is available to click");
			Welcome_Message_Btn.click();
		}
		else
		{
			test.log(LogStatus.FAIL,test.addScreenCapture(Shot.CaptureScreen())+ "Welcome Lets go Button is NOT Available");
		}
		
	}
	
}
