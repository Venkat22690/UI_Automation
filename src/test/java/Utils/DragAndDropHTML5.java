package Utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.Charset;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import ExtentReports.CaptureScreens;

public class DragAndDropHTML5 {
	
	WebDriver driver;
	public ExtentReports report;
	public ExtentTest test;
	CaptureScreens Shot;
	static Properties props = new Properties();
	static String propsFilepath = "/src/test/resources/Config.properties";
	
	public DragAndDropHTML5(WebDriver driver,ExtentReports report,ExtentTest test) throws IOException
	{
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + propsFilepath);
		props.load(fis);
		Shot = new CaptureScreens(driver);
		this.driver = driver;
		this.report = report;
		this.test = test;
		PageFactory.initElements(driver, this);
		
	}
		
		public void testDragAndDrop() throws InterruptedException, IOException{ 
        	try{
        	        String basePath = new File("").getAbsolutePath();
		            
		        	
			        //http://stackoverflow.com/questions/29381233/how-to-simulate-html5-drag-and-drop-in-selenium-webdriver
			        //https://gist.github.com/rcorreia/2362544
			        final String JQUERY_LOAD_SCRIPT = (basePath + "/src/test/resources/jquery_load_helper.js");
			        System.out.println(JQUERY_LOAD_SCRIPT);
			        String jQueryLoader = readFile(JQUERY_LOAD_SCRIPT);
			        
			        
			        JavascriptExecutor js = (JavascriptExecutor) driver;
			        js.executeAsyncScript(
			                jQueryLoader /* , http://localhost:8080/jquery-1.7.2.js */);
			
			        // ready to rock
			        js.executeScript("jQuery(function($) { " + " $('input[name=\"q\"]').val('bada-bing').closest('form').submit(); "
			                + " }); ");
			
			
			
			      //http://stackoverflow.com/questions/29381233/how-to-simulate-html5-drag-and-drop-in-selenium-webdriver
			      //"where jquery_load_helper.js contains:"  
			      String filePath = basePath + "/src/test/resources/drag_and_drop_helper.js";
			      System.out.println(filePath);
			      
			      //JQuery can ONLY work with id and css , xpath does NOT work with it.
			      //String source =  "//section[@id='wrapper']/article/ul/li[4]/a"; 
			      // String source = "section#wrapper article ul li:nth-child(4) a";
			      String source = "#__next > div > div > div > div.sc-fWKdJz.uaHII > div > div > div > div > div:nth-child(5) > div:nth-child(1) > div > div";
			      
			      String target =  "#__next > div > div > div > div.sc-fWKdJz.uaHII > div > div > div > div > div:nth-child(3)";
			      
			      StringBuffer buffer = new StringBuffer();
			      String line;
			      BufferedReader br = new BufferedReader(new FileReader(filePath));
			      while((line = br.readLine())!=null)
			          buffer.append(line);
			
			      String javaScript = buffer.toString();
			
			      javaScript = javaScript + "$('" + source + "').simulateDragDrop({ dropTarget: '" + target + "'});";
			      ((JavascriptExecutor)driver).executeScript(javaScript);
			      
			      
			      Thread.sleep(2000);
			      source = "#__next > div > div > div > div.sc-fWKdJz.uaHII > div > div > div > div > div:nth-child(5) > div:nth-child(2) > div > div";
			      javaScript = javaScript + "$('" + source + "').simulateDragDrop({ dropTarget: '" + target + "'});";
			      ((JavascriptExecutor)driver).executeScript(javaScript);
			      
			      Thread.sleep(2000);
			      source = "#__next > div > div > div > div.sc-fWKdJz.uaHII > div > div > div > div > div:nth-child(5) > div:nth-child(3) > div > div > div > div";
			      javaScript = javaScript + "$('" + source + "').simulateDragDrop({ dropTarget: '" + target + "'});";
			      ((JavascriptExecutor)driver).executeScript(javaScript);  
			      
			      Thread.sleep(1000);
        	}catch(Exception e){
        		e.printStackTrace();
        	}

}

    private static String readFile(String file) throws IOException {
        Charset cs = Charset.forName("UTF-8");
        FileInputStream stream = new FileInputStream(file);
        try {
            Reader reader = new BufferedReader(new InputStreamReader(stream, cs));
            StringBuilder builder = new StringBuilder();
            char[] buffer = new char[8192];
            int read;
            while ((read = reader.read(buffer, 0, buffer.length)) > 0) {
                builder.append(buffer, 0, read);
            }
            return builder.toString();
        } finally {
            stream.close();
        }
    }
    
}

