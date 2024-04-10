package Kd_Learning.TestComponents;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import kd_Learning.resources.ExtentReporterNG;

public class Listeners extends BaseTest implements ITestListener {

	ExtentTest test;
	ExtentReports extent = ExtentReporterNG.getRepoObject();

	public void onTestStart(ITestResult result) {
		// here we are using the inbuilt methods to get the method name
		test = extent.createTest(result.getMethod().getMethodName());
	}

	public void onTestFailure(ITestResult result) {
		// here we are using the inbuilt methods to get the method name
		String filePath = null;
		
		try {
			// Here we are getting the current driver of that class
			driver= (WebDriver)result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		test.fail(result.getThrowable());
		// take screenshot and attach it to report
		try {
			filePath = getScreenShot(result.getMethod().getMethodName(), driver);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		test.addScreenCaptureFromPath(filePath, result.getMethod().getMethodName());

	}

	public void onFinish(ITestContext context) {
		// here we are using the inbuilt methods to get the method name

		extent.flush();
	}

}
