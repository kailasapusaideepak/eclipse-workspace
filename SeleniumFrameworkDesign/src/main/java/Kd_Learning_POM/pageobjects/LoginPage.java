package Kd_Learning_POM.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends kd_Learning.AbstractComponents.AbstractComponents {

	 WebDriver driver;

	public LoginPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	// now here i'm using page factory
	// but pass the driver to pageFactory in the constructor with initElemenets() method 
	// so the pagefactory will be aware of the driver.
	
	
	@FindBy(id="userEmail")
	WebElement userName;
	
	@FindBy(id="userPassword")
	WebElement password;
	
	@FindBy(id="login")
	WebElement login;
	
	@FindBy(xpath="/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]")
	WebElement errorMsg;
	
	
	public void LoginAction(String name, String pwd)
	{
		userName.sendKeys(name);
		password.sendKeys(pwd);
		login.submit();
	}
	
	public String ErrorMessage()
	{
		waitForWebElementToAppear(errorMsg);
		return errorMsg.getText();
	}
	public void Landingpage()
	{
		driver.get("https://rahulshettyacademy.com/client/");
	}

	

}
