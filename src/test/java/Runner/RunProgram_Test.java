package Runner;

import java.awt.AWTException;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import ExtentReports.ExtentReportTestNG;
import Pages.AboutYou_DOB_Relationship;
import Pages.Finance_Questions;
import Pages.Launch;
import Pages.PaymentPage_And_WelcomePage;
import Pages.Questionaire_Page10_IncomeBenefits_LandingPage;
import Pages.Questionaire_Page11_DegreeDetails;
import Pages.Questionaire_Page12_Customer_CompanyDetails;
import Pages.Questionaire_Page13_CompanyOffer_Onstocks;
import Pages.Questionaire_Page14_CustomerHealthInsurance;
import Pages.Questionaire_Page15_Customer_CompanyBenefitsGuide;
import Pages.Questionaire_Page16_Customer_RetirementOffers;
import Pages.Questionaire_Page17_Customer401k;
import Pages.Questionaire_Page18_Customer_HSAOption;
import Pages.Questionaire_Page19_PartnerCompanyRole;
import Pages.Questionaire_Page1_ConfidencyLevel;
import Pages.Questionaire_Page20_PartnerStockOptions;
import Pages.Questionaire_Page21_PartnerHealthInsurance;
import Pages.Questionaire_Page22_PartnerCompanyBenefits;
import Pages.Questionaire_Page23_PartnerRetirementBenefits;
import Pages.Questionaire_Page24_Partner401k;
import Pages.Questionaire_Page25_Partner_HSAWork;
import Pages.Questionaire_Page26_AdditionalIncome;
import Pages.Questionaire_Page27_Savings_Spendings_LandingPage;
import Pages.Questionaire_Page28_CreditScore;
import Pages.Questionaire_Page29_LifeInsurance;
import Pages.Questionaire_Page2_Partner_personal_Details;
import Pages.Questionaire_Page30_WillInformation;
import Pages.Questionaire_Page31_AccountSelection;
import Pages.Questionaire_Page32_Accounts_Entry_Information;
import Pages.Questionaire_Page33_OtherExpenses;
import Pages.Questionaire_Page34_AdditionalExpensesCheck;
import Pages.Questionaire_Page35_WrapPage_Final;
import Pages.Questionaire_Page3_KidsInformation;
import Pages.Questionaire_Page4_ImportantTopicsSelection;
import Pages.Questionaire_Page5_MilestoneSelection;
import Pages.Questionaire_Page6_MilestoneLineUp;
import Pages.Questionaire_Page7_Milestone1_Details;
import Pages.Questionaire_Page8_Milestone2_Details;
import Pages.Questionaire_Page9_Milestone3_Details;
import Utils.DBConnection;
import io.github.bonigarcia.wdm.WebDriverManager;

public class RunProgram_Test {

	WebDriver driver;
	public ExtentReports report;
	public ExtentTest test;
	
	@BeforeMethod
	public void LoadBrowser()
	{
		ChromeOptions chromeoptions = new ChromeOptions();
		WebDriverManager.chromedriver().setup();
		// WebDriverManager.chromedriver().browserVersion("116.0.5845.111").setup();
		driver = new ChromeDriver(chromeoptions);
		report = ExtentReportTestNG.getInstance();
		 test = report.startTest("Uprise Customer UI");
	}
	
	@Test
	public void Running() throws IOException, InterruptedException, AWTException
	{
		System.out.println("************");
		
		// Class List
		Launch Lh =new Launch(driver, report, test);
		AboutYou_DOB_Relationship Ay = new AboutYou_DOB_Relationship(driver, report, test); 
		Finance_Questions Fq = new Finance_Questions(driver, report, test); 
		PaymentPage_And_WelcomePage pw = new PaymentPage_And_WelcomePage(driver, report, test); 
		Questionaire_Page1_ConfidencyLevel Q1 = new Questionaire_Page1_ConfidencyLevel(driver, report, test); 
		Questionaire_Page2_Partner_personal_Details Q2 = new Questionaire_Page2_Partner_personal_Details(driver, report, test); 
		Questionaire_Page3_KidsInformation Q3 = new Questionaire_Page3_KidsInformation(driver, report, test);
		Questionaire_Page4_ImportantTopicsSelection Q4 = new Questionaire_Page4_ImportantTopicsSelection(driver, report, test);
		Questionaire_Page5_MilestoneSelection Q5 = new Questionaire_Page5_MilestoneSelection(driver, report, test);
		Questionaire_Page6_MilestoneLineUp Q6 = new Questionaire_Page6_MilestoneLineUp(driver, report, test);
		Questionaire_Page7_Milestone1_Details Q7 = new Questionaire_Page7_Milestone1_Details(driver, report, test);
		Questionaire_Page8_Milestone2_Details Q8 = new Questionaire_Page8_Milestone2_Details(driver, report, test);
		Questionaire_Page9_Milestone3_Details Q9 = new Questionaire_Page9_Milestone3_Details(driver, report, test);
		Questionaire_Page10_IncomeBenefits_LandingPage Q10 =new Questionaire_Page10_IncomeBenefits_LandingPage(driver, report, test);
		
		Questionaire_Page11_DegreeDetails Q11 = new Questionaire_Page11_DegreeDetails(driver, report, test);
		Questionaire_Page12_Customer_CompanyDetails Q12 = new Questionaire_Page12_Customer_CompanyDetails(driver, report, test);
		Questionaire_Page13_CompanyOffer_Onstocks Q13 = new Questionaire_Page13_CompanyOffer_Onstocks(driver, report, test);
		Questionaire_Page14_CustomerHealthInsurance Q14 = new Questionaire_Page14_CustomerHealthInsurance(driver, report, test);
		Questionaire_Page15_Customer_CompanyBenefitsGuide Q15 = new Questionaire_Page15_Customer_CompanyBenefitsGuide(driver, report, test);
		
		Questionaire_Page16_Customer_RetirementOffers Q16 = new Questionaire_Page16_Customer_RetirementOffers(driver, report, test);
		Questionaire_Page17_Customer401k Q17 = new Questionaire_Page17_Customer401k(driver, report, test);
		Questionaire_Page18_Customer_HSAOption Q18 = new Questionaire_Page18_Customer_HSAOption(driver, report, test);
		Questionaire_Page19_PartnerCompanyRole Q19 = new Questionaire_Page19_PartnerCompanyRole(driver, report, test);
		Questionaire_Page20_PartnerStockOptions Q20 = new Questionaire_Page20_PartnerStockOptions(driver, report, test);
		
		Questionaire_Page21_PartnerHealthInsurance Q21 = new Questionaire_Page21_PartnerHealthInsurance(driver, report, test);
		Questionaire_Page22_PartnerCompanyBenefits Q22 = new Questionaire_Page22_PartnerCompanyBenefits(driver, report, test);
		Questionaire_Page23_PartnerRetirementBenefits Q23 = new Questionaire_Page23_PartnerRetirementBenefits(driver, report, test);
		Questionaire_Page24_Partner401k Q24 = new Questionaire_Page24_Partner401k(driver, report, test);
		Questionaire_Page25_Partner_HSAWork Q25 = new Questionaire_Page25_Partner_HSAWork(driver, report, test);
		
		Questionaire_Page26_AdditionalIncome Q26 = new Questionaire_Page26_AdditionalIncome(driver, report, test);
		Questionaire_Page27_Savings_Spendings_LandingPage Q27 = new Questionaire_Page27_Savings_Spendings_LandingPage(driver, report, test);
		Questionaire_Page28_CreditScore Q28 = new Questionaire_Page28_CreditScore(driver, report, test);
		Questionaire_Page29_LifeInsurance Q29 = new Questionaire_Page29_LifeInsurance(driver, report, test);
		Questionaire_Page30_WillInformation Q30 = new Questionaire_Page30_WillInformation(driver, report, test);
		
		Questionaire_Page31_AccountSelection Q31 = new Questionaire_Page31_AccountSelection(driver, report, test);
		Questionaire_Page32_Accounts_Entry_Information Q32 = new Questionaire_Page32_Accounts_Entry_Information(driver, report, test);
		Questionaire_Page33_OtherExpenses Q33 = new Questionaire_Page33_OtherExpenses(driver, report, test);
		Questionaire_Page34_AdditionalExpensesCheck Q34 = new Questionaire_Page34_AdditionalExpensesCheck(driver, report, test);
		Questionaire_Page35_WrapPage_Final Q35 = new Questionaire_Page35_WrapPage_Final(driver, report, test);
		 
		
		// Methods LineUp
		 Lh.LaunchApplication();
		 Lh.SignUp();
		// Lh.Login();  // Spl
		 Lh.EmailCode();
		
		 Ay.AboutYouDetails();
		 Fq.FinanceQuestionPage();
		 pw.PaymentAndWelcome();
		 
		//  Lh.GetStarted();  // Spl
		
		  Q1.Questionaire_ConfidencyLevel();
		  Q2.Questionaire_Partner_personal_Details();
		  Q3.Questionaire_KidsInformation();
		  Q4.Questionaire_ImportantTopicsSelection();
		  Q5.Questionaire_MilestoneSelection();
		  Q6.Questionaire_MilestoneLineUp();  // -- Not working Drag and Drop
		  Q7.Questionaire_Milestone1_Details();
		  Q8.Questionaire_Milestone2_Details();
		  Q9.Questionaire_Milestone3_Details();
		  Q10.Questionaire_IncomeBenefits_LandingPage();
		 
		 Q11.Questionaire_DegreeDetails();
		 Q12.Questionaire_Customer_CompanyDetails();
		 Q13. Questionaire_CompanyOffer_Onstocks();
		 Q14.Questionaire_CustomerHealthInsurance();
		 Q15.Questionaire_Customer_CompanyBenefitsGuide();
		 
		// Q16.Questionaire_Customer_RetirementOffers();  // - Not reflecting 
		// Q17.Questionaire_Customer401k();  // - Not reflecting 
		//  Q18.Questionaire_Customer_HSAOption();  // - Not reflecting 
		 Q19.Questionaire_PartnerCompanyRole();
		 Q20.Questionaire_PartnerStockOptions();
		 
		  Q21.Questionaire_PartnerHealthInsurance();
		 Q22.Questionaire_PartnerCompanyBenefits();
		// Q23.Questionaire_PartnerRetirementBenefits(); // - Not reflecting 
	    // Q24.Questionaire_Partner401k(); // - Not reflecting 
		// Q25.Questionaire_Partner_HSAWork(); // - Not reflecting 
		  
		 Q26.Questionaire_AdditionalIncome();
		 Q27.Questionaire_Savings_Spendings_LandingPage();
		 Q28.Questionaire_CreditScore();
		 Q29.Questionaire_LifeInsurance();
		 Q30.Questionaire_WillInformation();
			
		 Q31.Questionaire_AccountSelection();
		 Q32.Questionaire_Accounts_Entry_Information();
		 Q33.Questionaire_OtherExpenses();
		 Q34.Questionaire_AdditionalExpensesCheck();
		 Q35.Questionaire_WrapPage_Final(); 			
			
		 
		 
	}
	
	 @AfterClass
	  public void testDown()
	  {
		  report.endTest(test);
		  report.flush();
	  }
}
