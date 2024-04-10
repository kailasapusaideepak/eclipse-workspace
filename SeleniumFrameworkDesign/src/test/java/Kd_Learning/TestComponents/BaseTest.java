package Kd_Learning.TestComponents;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;

import Kd_Learning_POM.pageobjects.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {

	public WebDriver driver;
	public LoginPage loginpage;

	public WebDriver initializedriver() throws IOException {

		// properties class --> declear in main java on resources package
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(
				System.getProperty("user.dir")+"//src//main//java//kd_Learning//resources//GlobalData.properties"); 
		//System.getProperty("user.dir") --> This will get the system location path for the project
		prop.load(fis);
		String browserName = prop.getProperty("browser");
		if (browserName.equalsIgnoreCase("chrome")) {

			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (browserName.equalsIgnoreCase("firefox")) {
			// firefox code
		}

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		return driver;
	}
	
	
	public String getScreenShot(String testCaseName, WebDriver driver) throws IOException
	{
		File src= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File dest=new File(System.getProperty("user.dir")+"// reports//"+ testCaseName+ ".png");
		FileUtils.copyFile(src, dest);
		return System.getProperty("user.dir")+"// reports//"+ testCaseName+ ".png";
	}
	
	
	@BeforeTest(alwaysRun=true)
	public LoginPage launchApplication() throws IOException
	{
		driver=initializedriver();
		loginpage=new LoginPage(driver);
		loginpage.Landingpage();
		return loginpage;
	}
	
	@AfterMethod(alwaysRun=true)
	public void teardown()
	{
		driver.close();
	}
}
