package kd_Learning.resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporterNG {
	
	ExtentReports extent;
	public void getRepoObject()
	{
		String path= System.getProperty("user.dir")+"// reports//index.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		reporter.config().setReportName("web Automation results");
		reporter.config().setDocumentTitle("Test results");
		
		 extent=new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester", "Kd learning");
	}

}
