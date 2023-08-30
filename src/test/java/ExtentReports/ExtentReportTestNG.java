package ExtentReports;

import com.relevantcodes.extentreports.ExtentReports;

public class ExtentReportTestNG {

	public static ExtentReports getInstance()
	{
		  ExtentReports report;
		  report = new ExtentReports(System.getProperty("user.dir")+"/Reports/extentReport.html", false);
		  report.addSystemInfo("Blog Name", "Good Blog");
		  report.addSystemInfo("Author", "Venkat");
		  return report;
	}
}
