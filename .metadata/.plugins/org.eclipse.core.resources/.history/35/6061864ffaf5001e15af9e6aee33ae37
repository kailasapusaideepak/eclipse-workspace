package Kd_Learning.TestComponents;

import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import kd_Learning.resources.ExtentReporterNG;

public class Listeners implements ITestListener{
	
	ExtentTest test;
	ExtentReports extent = ExtentReporterNG.getRepoObject();
	
	public void onTestStart(ITestResult result)
	{
		// here we are using the inbuilt methods to get the method name
		test= extent.createTest(result.getMethod().getMethodName());
	}
	
	
	public void onTestFailure(ITestResult result)
	{
		// here we are using the inbuilt methods to get the method name
		test.fail(result.getThrowable());
		
		// take screenshot and attach it to report
	}

}
