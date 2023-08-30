package Pages;


import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.Properties;
import java.util.Random;
import java.util.Scanner;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import ExtentReports.CaptureScreens;
import Utils.DBConnection;


public class Launch {
	WebDriver driver;
	public ExtentReports report;
	public ExtentTest test;
	CaptureScreens Shot;
	static Properties props = new Properties();
	static String propsFilepath = "/src/test/resources/Config.properties";
	DBConnection db = new DBConnection();
	
	// Object Repositories 
	
	@FindBy(xpath = "//div[text()='Create an account']")
	WebElement SingUpHeader;
	
	@FindBy(xpath = "//input[@label='First and last name']")
	WebElement FirstNameLastName_Field;
	
	@FindBy(xpath = "//input[@label='Email']")
	WebElement Email_Field;
	
	@FindBy(xpath = "//input[@type='tel']")
	WebElement MobileNumber_Field;
	
	@FindBy(xpath = "//input[@type='password']")
	WebElement Password_Field;
	
	@FindBy(xpath = "//input[@label='How did you hear about us?']")
	WebElement HearUs_Field;
	
	@FindBy(xpath = "(//div[contains(text(),'I accept')]//preceding-sibling :: div)[1]")
	WebElement CheckBox_IAccept;
	
	@FindBy(xpath = "//button[text()='Sign Up']")
	WebElement SignUpButton;
	
	@FindBy(xpath = "//div[text()=' Log in']")
	WebElement Login_LinkfromSignUp;
	
	@FindBy(xpath = "//input[@name='email']")
	WebElement EmailId;
	
	@FindBy(xpath = "//input[@name='password']")
	WebElement Password;
	
	@FindBy(xpath = "//button[text()='Log in']")
	WebElement LoginBtn;
	
	@FindBy(xpath = "//input[@name='otp']")
	WebElement EmailCode;
	
	@FindBy(xpath = "//button[text()='Continue']")
	WebElement ContinueBtn;
	
	@FindBy(xpath = "//button[contains(text(),'Get started')]")
	WebElement GetStarted;
	
	
	String EmailIdGenerate;
	
	
	
	
	// End of Object Repositories 
	
	
	public Launch(WebDriver driver,ExtentReports report,ExtentTest test) throws IOException
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
	   test.log(LogStatus.INFO, "Launch Application");
	   driver.manage().window().maximize();
	   driver.get(props.getProperty("URL")); 
	}
	
	public void SignUp() throws IOException, InterruptedException
	{
		EmailIdGenerate = EmailGeneration();
		System.out.println("******* SignUp *******");
		test.log(LogStatus.INFO, "******* SignUp *******");
		System.out.println(SingUpHeader.getText());
		
		// SignUp Page Launch Verification
		if(SingUpHeader.getText().equalsIgnoreCase("Create an account"))
		{
			test.log(LogStatus.PASS,test.addScreenCapture(Shot.CaptureScreen())+ "SignUp Page Launched Successfully");
		}
		else
		{
			test.log(LogStatus.FAIL,test.addScreenCapture(Shot.CaptureScreen())+ "SignUp Page NOT Launched Properly");
		}
		
		// FirstName and LastName
		if(FirstNameLastName_Field.isDisplayed())
		{
			test.log(LogStatus.PASS,test.addScreenCapture(Shot.CaptureScreen())+ "First and lastname Available");
			FirstNameLastName_Field.sendKeys(props.getProperty("FirstNameAndLastName"));
		}
		else
		{
			test.log(LogStatus.FAIL,test.addScreenCapture(Shot.CaptureScreen())+ "First and lastname Field NOT Available");
		}
		
		//Email 
		if(Email_Field.isDisplayed())
		{
			test.log(LogStatus.PASS,test.addScreenCapture(Shot.CaptureScreen())+ "Email Field Available");
			Email_Field.sendKeys(EmailIdGenerate);
		}
		else
		{
			test.log(LogStatus.FAIL,test.addScreenCapture(Shot.CaptureScreen())+ "Email Field NOT Available");
		}
		
		// Mobile
		if(MobileNumber_Field.isDisplayed())
		{
			test.log(LogStatus.PASS,test.addScreenCapture(Shot.CaptureScreen())+ "Mobile Field Available");
			MobileNumber_Field.sendKeys(props.getProperty("Mobile"));
		}
		else
		{
			test.log(LogStatus.FAIL,test.addScreenCapture(Shot.CaptureScreen())+ "Mobile Field NOT Available");
		}
		
		// Password
		if(Password_Field.isDisplayed())
		{
			test.log(LogStatus.PASS,test.addScreenCapture(Shot.CaptureScreen())+ "Password Field Available");
			Password_Field.sendKeys(props.getProperty("Password"));
		}
		else
		{
			test.log(LogStatus.FAIL,test.addScreenCapture(Shot.CaptureScreen())+ "Password Field NOT Available");
		}
		
		// HearUs
		if(HearUs_Field.isDisplayed())
		{
			test.log(LogStatus.PASS,test.addScreenCapture(Shot.CaptureScreen())+ "HearUs Field Aavailable");
		}
		else
		{
			test.log(LogStatus.FAIL,test.addScreenCapture(Shot.CaptureScreen())+ "HearUs Field NOT Available");
		}
		
		// CheckBox_IAccept
		if(CheckBox_IAccept.isDisplayed())
		{
			test.log(LogStatus.PASS,test.addScreenCapture(Shot.CaptureScreen())+ "Checkbox I Accept selected Successfully");
			CheckBox_IAccept.click();;
		}
		else
		{
			test.log(LogStatus.FAIL,test.addScreenCapture(Shot.CaptureScreen())+ "CheckBox I Accept CheckBox NOT Displayed");
		}
		
		Thread.sleep(4000);		
		
		// SignUp Button
		if(SignUpButton.isDisplayed())
		{
			test.log(LogStatus.PASS,test.addScreenCapture(Shot.CaptureScreen())+ "SignUp Button Displayed");
			SignUpButton.click();
			
			// Using this time to Enter the Email code
			Thread.sleep(6000);
		}
		else
		{
			test.log(LogStatus.FAIL,test.addScreenCapture(Shot.CaptureScreen())+ "SignUp Button NOT Displayed");
		}
	}
	
	public String EmailGeneration()
	{
		LocalDate currentdate = LocalDate.now();
		int currentDay = currentdate.getDayOfMonth();

		SimpleDateFormat simpleformat = new SimpleDateFormat("MMM");
	    String strMonth= simpleformat.format(new Date());
	      
		// creating an object of Random class   
		Random random = new Random();     
		
		// Generates random integers 0 to 999  
		int RandomNumber = random.nextInt(1000); 
		
		String emailAddress = "venkataraman+"+strMonth +"+"+currentDay+"+"+RandomNumber+"@uprise.us";
		System.out.println("Created Account is   ======>  "+emailAddress);
		
		return emailAddress;
	}
	
	
	
	///// ** Temp ***
	public void Login() throws InterruptedException
	{
		Thread.sleep(2000);
		Login_LinkfromSignUp.click();
		EmailId.sendKeys(props.getProperty("Email"));
		Password.sendKeys(props.getProperty("Password"));
		Thread.sleep(2000);
		LoginBtn.click();		
	}
	
	public void EmailCode() throws InterruptedException
	{
		// Scanner sc = new Scanner(System.in);
		System.out.println("Enter the Email Code : ");
		if(EmailIdGenerate== null)
		{
			EmailIdGenerate = props.getProperty("Email");
			// System.out.println(EmailIdGenerate);
		}
		else if(EmailIdGenerate.isBlank() || EmailIdGenerate.isEmpty())
		{
			EmailIdGenerate = props.getProperty("Email");
		}
		Thread.sleep(4000);
		// System.out.println(EmailIdGenerate);
		String OTP = db.database(EmailIdGenerate.toLowerCase());
		System.out.println("Email OTP "+OTP);
		// String Input =  sc.nextLine();
		//Thread.sleep(4000);
		EmailCode.sendKeys(OTP);
		ContinueBtn.click();
	}
	
	public void GetStarted() throws InterruptedException
	{
		Thread.sleep(9000);
		GetStarted.click();
	}
	
	
}
