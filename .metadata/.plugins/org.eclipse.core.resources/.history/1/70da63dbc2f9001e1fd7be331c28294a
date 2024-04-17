package Kd_Learning_POM.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckOutPage extends kd_Learning.AbstractComponents.AbstractComponents{

	
	WebDriver driver;
	public  CheckOutPage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(css=".form-group")
	WebElement country;
	
	@FindBy(css=".btnn")
	WebElement placeOrderBtn;
	
	@FindBy(css=".ta-item:nth-of-type(2)")
	WebElement selectCountry;
	
	By wait=By.cssSelector(".ta-results");
	
	public void SelectCountry()
	{
		Actions a =new Actions(driver);
		a.sendKeys(country, "india").build().perform();
		waitForElementToAppear(wait);
		selectCountry.click();
		
	}
	
	public ConfrimationPage submitOrder()
	{
		placeOrderBtn.click();
		return new ConfrimationPage(driver);
	}
}
