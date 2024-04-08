package kd_Learning.AbstractComponents;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Kd_Learning_POM.pageobjects.OrderPage;

public class AbstractComponents {
	protected WebDriver driver;
	public AbstractComponents(WebDriver driver)
	{
		super();
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(css="[routerlink*='cart']")
	WebElement cartButton;
	
	@FindBy(xpath="//button[@routerlink='/dashboard/myorders']")
	WebElement orderHistory;
	
	public void waitForElementToAppear(By findBy)
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
				
		
	}
	
	public void waitForWebElementToAppear(WebElement ele)
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(ele));
				
		
	}
	
	public void waitForElementToDisAppear(WebElement ele)
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.invisibilityOf(ele));
				
		
	}
	
	public void clickCartButton()
	{
		cartButton.click();
	}
	
	public OrderPage clickOrderButton()
	{
		orderHistory.click();
		OrderPage orderpage=new OrderPage(driver);
		return orderpage;
	}


}
