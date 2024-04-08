package Kd_Learning_POM.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.google.common.cache.AbstractCache;

import kd_Learning.AbstractComponents.AbstractComponents;


public  class CartPage extends AbstractComponents {

	WebDriver driver;
	public CartPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	// 		List<WebElement> cartItems= driver.findElements(By.cssSelector(".cartSection h3"));

	@FindBy(css=".cartSection h3")
	List<WebElement> cartItems;
	
	@FindBy(css=".totalRow button")
	WebElement checkOutButton;
	
	
	By visibleElement= By.cssSelector(".totalRow button");
	
	
	public Boolean cartItemsComparission(String productName)
	{
		waitForElementToAppear(visibleElement);
		cartItems.stream().forEach(x->System.out.println(x.getText()));
		return cartItems.stream().anyMatch(x->x.getText().equalsIgnoreCase(productName));
		
	}
	
	public void goTocheckOutPage()
	{
		checkOutButton.click();
	}
	
	

}
