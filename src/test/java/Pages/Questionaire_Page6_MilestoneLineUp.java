package Pages;


import java.awt.AWTException;
import java.awt.Desktop.Action;
import java.awt.Point;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
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
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import ExtentReports.CaptureScreens;
import Utils.DragAndDropHTML5;

public class Questionaire_Page6_MilestoneLineUp {
	WebDriver driver;
	public ExtentReports report;
	public ExtentTest test;
	CaptureScreens Shot;
	static Properties props = new Properties();
	static String propsFilepath = "/src/test/resources/Config.properties";
	
	// Object Repositories 
		
		@FindBy(xpath = "//div[text()='ABOUT YOU']")
		WebElement AboutYouTitle;
		
		@FindBy(xpath = "//div[text()='Which are most important to you?']")
		WebElement Questionaire_Page6_Title;
		
		@FindBy(xpath = "//div[contains(text(),'Drag your top milestones here')]")
		WebElement DragandDrop_Label;
		
		@FindBy(xpath = "//div[contains(text(),'Add up to 3')]")
		WebElement AddUpto_Label; 
		
		@FindBy(xpath = "(//div[contains(text(),'Drag your top milestones here')]//following :: div)[1]")
		WebElement droppoint1; 
		
		@FindBy(xpath = "(//div[contains(text(),'Drag your top milestones here')]//following :: div)[2]")
		WebElement droppoint2; 
		
		//@FindBy(xpath = "//div[contains(text(),'Getting a car')]")
		@FindBy(xpath = "(//div[@draggable])[1]")
		WebElement GettingCar_Entry;
		
		
		// @FindBy(xpath = "//div[contains(text(),'Buying a home')]")
		@FindBy(xpath = "(//div[@draggable])[2]")
		WebElement Buying_a_home_Entry;
		
		// @FindBy(xpath = "(//div[contains(text(),'Starting a company')]//following :: img)[1]")
		@FindBy(xpath = "(//div[@draggable])[5]")
		WebElement StartingCompany_Entry;
		
		@FindBy(xpath = "//button//div[text()='Save and continue']")
		WebElement Save_Continue_Button;
		
		
	
	// End of Object Repositories 
	
	
	public Questionaire_Page6_MilestoneLineUp(WebDriver driver,ExtentReports report,ExtentTest test) throws IOException
	{
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + propsFilepath);
		props.load(fis);
		Shot = new CaptureScreens(driver);
		this.driver = driver;
		this.report = report;
		this.test = test;
		PageFactory.initElements(driver, this);
		
	}
	
	@SuppressWarnings("deprecation")
	public void Questionaire_MilestoneLineUp() throws IOException, InterruptedException, AWTException
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
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView();", Questionaire_Page6_Title); 
		if(Questionaire_Page6_Title.isDisplayed())
		{
			test.log(LogStatus.PASS,test.addScreenCapture(Shot.CaptureScreen())+ "Important Milestone LineUp Page Title is Available");
		}
		else
		{
			test.log(LogStatus.FAIL,test.addScreenCapture(Shot.CaptureScreen())+ "Important Milestone LineUp Page Title is NOT Available");
		}
		
		// Drag and Drop Label
		if(DragandDrop_Label.isDisplayed())
		{
			test.log(LogStatus.PASS,test.addScreenCapture(Shot.CaptureScreen())+ "DragandDrop location label is Available");
		}
		else
		{
			test.log(LogStatus.FAIL,test.addScreenCapture(Shot.CaptureScreen())+ "DragandDrop location label is NOT Available");
		}
		
		// Selection Instruction Label
		if(AddUpto_Label.isDisplayed())
		{
			test.log(LogStatus.PASS,test.addScreenCapture(Shot.CaptureScreen())+ "Selection Instruction label is Available");
		}
		else
		{
			test.log(LogStatus.FAIL,test.addScreenCapture(Shot.CaptureScreen())+ "Selection Instruction label is NOT Available");
		}
		
		
		// Milestone Entries Check
		List<WebElement> MilestoneList = driver.findElements(By.xpath("//div[contains(text(),'Add up to 3')]//following :: img//following-sibling :: div"));
		if(MilestoneList.size() == 9)
		{
			for(int i =0;i<MilestoneList.size();i++)
			{
				String Entriescheck = MilestoneList.get(i).getText();
				System.out.println(Entriescheck);
				if(Entriescheck.isEmpty())
				{
					test.log(LogStatus.FAIL,test.addScreenCapture(Shot.CaptureScreen())+ "MilestoneList Entries are missing");
				}
			}
		}
		else
		{
			test.log(LogStatus.FAIL,test.addScreenCapture(Shot.CaptureScreen())+ "MilestoneList Count are missing");
		}
		
		
		
		Robot robot = new Robot();
		for(int i=0; i<2;i++)
		{
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_MINUS);
			robot.keyRelease(KeyEvent.VK_CONTROL);
			robot.keyRelease(KeyEvent.VK_MINUS);
			Thread.sleep(2000);
		}
		
		
		
		// ((JavascriptExecutor)driver).executeScript("document.body.style.zoom='50%';");
		
	//	WebElement a = driver.findElement(By.cssSelector("#__next > div > div > div > div.sc-fWKdJz.uaHII > div > div > div > div > div:nth-child(5) > div:nth-child(1) > div > div"));
     //   WebElement b = driver.findElement(By.cssSelector("#__next > div > div > div > div.sc-fWKdJz.uaHII > div > div > div > div > div:nth-child(3) > div"));
        
		/* 
        WebElement a = GettingCar_Entry;
        WebElement b = droppoint1;
        int x = b.getLocation().x;
        int y = b.getLocation().y;

        Actions actions = new Actions(driver);
        actions.moveToElement(a)
                .pause(Duration.ofSeconds(1))
                .clickAndHold(a)
                .pause(Duration.ofSeconds(1))
                .moveByOffset(x, y)
                .moveToElement(b)
                .moveByOffset(x,y)
                .pause(Duration.ofSeconds(1))
                .release().build().perform(); */
        
		Thread.sleep(2000);
        int x = droppoint1.getLocation().x;
        int y = droppoint1.getLocation().y;

        Actions actions = new Actions(driver);
        js.executeScript("arguments[0].scrollIntoView();", Questionaire_Page6_Title);
        actions.moveToElement(GettingCar_Entry)
                .pause(Duration.ofSeconds(1))
                .clickAndHold(GettingCar_Entry)
                .pause(Duration.ofSeconds(1))
                .moveByOffset(x, y)
                .moveToElement(droppoint2)
                .moveByOffset(x,y)
                .pause(Duration.ofSeconds(1))
                .release().build().perform();
       
        Thread.sleep(2000);
        
        for(int i=0; i<2;i++)
		{
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_MINUS);
			robot.keyRelease(KeyEvent.VK_CONTROL);
			robot.keyRelease(KeyEvent.VK_MINUS);
			Thread.sleep(2000);
		}
        
     //   js.executeScript("arguments[0].scrollIntoView();", StartingCompany_Entry);
        actions.moveToElement(Buying_a_home_Entry)
                .pause(Duration.ofSeconds(1))
                .clickAndHold(Buying_a_home_Entry)
                .pause(Duration.ofSeconds(1))
                .moveByOffset(x, y)
                .moveToElement(GettingCar_Entry)
                .moveByOffset(x,y)
                .pause(Duration.ofSeconds(1))
                .release().build().perform();
        
        Thread.sleep(2000);
        js.executeScript("arguments[0].scrollIntoView();", StartingCompany_Entry); 
         actions.moveToElement(StartingCompany_Entry)
                .pause(Duration.ofSeconds(1))
                .clickAndHold(StartingCompany_Entry)
                .pause(Duration.ofSeconds(1))
                .moveByOffset(x, y)
                .moveToElement(GettingCar_Entry)
                .moveByOffset(x,y)
                .pause(Duration.ofSeconds(1))
                .release().build().perform();
         
        
		
         Thread.sleep(2000); 
        
		/*
		// GettingCar_Entry.click();
		Thread.sleep(4000);
		DragAndDropHTML5 dd = new DragAndDropHTML5(driver, report, test);
		dd.testDragAndDrop();
		
		 Actions ac = new Actions(driver);
		 ac.clickAndHold(GettingCar_Entry);
		 Thread.sleep(2000);
		 org.openqa.selenium.Point coordinates1 = GettingCar_Entry.getLocation();
		 org.openqa.selenium.Point coordinates2 = droppoint1.getLocation();  
		 Robot robot = new Robot();           
		// robot.mouseMove(coordinates1.getX(), coordinates1.getY());
		 GettingCar_Entry.click();
		 Thread.sleep(2000);
		 // robot.mousePress(InputEvent.BUTTON1_MASK);
		 Thread.sleep(2000);
		 robot.mouseMove(coordinates2.getX(), coordinates2.getY());
		// js.executeScript("arguments[0].scrollIntoView();", droppoint1); 
		 Thread.sleep(2000);
		 robot.mouseRelease(InputEvent.BUTTON1_MASK);
		 Thread.sleep(2000);
		 */
		 
		
		/* 
		Thread.sleep(2000);
		GettingCar_Entry.click();
		Actions ac = new Actions(driver);
		/*
		int sourceWidth = GettingCar_Entry.getSize().getWidth();
		int SourceHeight = GettingCar_Entry.getSize().getHeight();
		int destinationWidth = DragandDrop_Label.getSize().getWidth();
		int destinationHeight = DragandDrop_Label.getSize().getHeight();
		Actions act = new Actions(driver);
		act.moveToElement(GettingCar_Entry, (sourceWidth / 2), SourceHeight / 2).clickAndHold().build().perform();
		act.moveToElement(DragandDrop_Label, (destinationWidth / 2) , (destinationHeight / 2)).release().build().perform();
		
		System.out.println("G**********");
		System.out.println(driver.findElement(By.xpath("//div[contains(@class,'sc-bLHCGa dFtQYE')]")).getText());
		System.out.println("G**********");
		ac.moveToElement(droppoint1).build().perform();
		Thread.sleep(5000);
		
		ac.clickAndHold(GettingCar_Entry)
		.pause(Duration.ofSeconds(2))
		.moveByOffset(0, -1)
		.moveToElement(droppoint1)
		.pause(Duration.ofSeconds(2))
		.release()
		.build()
		.perform();
		
		// ac.dragAndDrop(GettingCar_Entry,DragandDrop_Label).release().build().perform();
		
		 Robot robot = new Robot();
		    robot.keyPress(KeyEvent.VK_ESCAPE);
		    robot.keyRelease(KeyEvent.VK_ESCAPE); 
		    
		//ac.dragAndDrop(GettingCar_Entry,AddUpto_Label).build().perform();
		Thread.sleep(2000);
		ac.dragAndDrop(Buying_a_home_Entry,droppoint2).build().perform();
		Thread.sleep(2000);
		ac.dragAndDrop(StartingCompany_Entry,DragandDrop_Label).build().perform();
		Thread.sleep(6000);
		
		// JavascriptExecutor js = (JavascriptExecutor) driver;
	   // js.executeScript("function createEvent(typeOfEvent) {\n" +"var event =document.createEvent(\"CustomEvent\");\n" +"event.initCustomEvent(typeOfEvent,true, true, null);\n" +"event.dataTransfer = {\n" +"data: {},\n" +"setData: function (key, value) {\n" +"this.data[key] = value;\n" +"},\n" +"getData: function (key) {\n" +"return this.data[key];\n" +"}\n" +"};\n" +"return event;\n" +"}\n" +"\n" +"function dispatchEvent(element, event,transferData) {\n" +"if (transferData !== undefined) {\n" +"event.dataTransfer = transferData;\n" +"}\n" +"if (element.dispatchEvent) {\n" + "element.dispatchEvent(event);\n" +"} else if (element.fireEvent) {\n" +"element.fireEvent(\"on\" + event.type, event);\n" +"}\n" +"}\n" +"\n" +"function simulateHTML5DragAndDrop(element, destination) {\n" +"var dragStartEvent =createEvent('dragstart');\n" +"dispatchEvent(element, dragStartEvent);\n" +"var dropEvent = createEvent('drop');\n" +"dispatchEvent(destination, dropEvent,dragStartEvent.dataTransfer);\n" +"var dragEndEvent = createEvent('dragend');\n" +"dispatchEvent(element, dragEndEvent,dropEvent.dataTransfer);\n" +"}\n" +"\n" +"var source = arguments[0];\n" +"var destination = arguments[1];\n" +"simulateHTML5DragAndDrop(source,destination);",Buying_a_home_Entry, droppoint2);
	   // Thread.sleep(1500);
	    
		ac.moveByOffset(34, 603);
		
		
		// ac.moveToElement(droppoint1, 34, 603); */

         
		// Save and Continue 
		if(Save_Continue_Button.isDisplayed())
		{
			test.log(LogStatus.PASS,test.addScreenCapture(Shot.CaptureScreen())+ "Save and Continue is Available");
			Thread.sleep(3000);
			
			Save_Continue_Button.click();
		}
		else
		{
			test.log(LogStatus.FAIL,test.addScreenCapture(Shot.CaptureScreen())+ "Save and Continue is NOT Available");
		}
	}
	
}
