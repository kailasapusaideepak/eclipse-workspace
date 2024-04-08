package Kd_Learning_POM.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductCatalogue extends kd_Learning.AbstractComponents.AbstractComponents {

	 WebDriver driver;

	public ProductCatalogue(WebDriver driver) {
		// TODO Auto-generated constructor stub
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	// now here i'm using page factory
	// but pass the driver to pageFactory in the constructor with initElemenets() method 
	// so the pagefactory will be aware of the driver.
	
	
	
	// List<WebElement> products= driver.findElements(By.cssSelector(".mb-3"));
	// Now this one we can write as below
	
	@FindBy(css=".mb-3")
	List<WebElement> products;
	
	@FindBy(css="ng-animating")
	WebElement animation;
	
	@FindBy(xpath="/html/body/app-root/app-dashboard/ngx-spinner")
	WebElement animationxpath;
	
	
	
	By productsBy= By.cssSelector(".mb-3");
	By productName= By.cssSelector(".card-body button:last-of-type");
	By toastName= By.cssSelector(".toast-container");
	public List<WebElement> getProducts()
	{
		waitForElementToAppear(productsBy);
		return products;
	}
	
	
	public WebElement getProductName(String productName2)
	{
		WebElement prod=getProducts().stream().
				filter(x->x.findElement(By.cssSelector("b")).getText().equals(productName2)).findFirst().orElse(null);
		return prod;
		
	}
	
	public void addProductToCart(String productName2)
	{
		
		WebElement prod= getProductName(productName2);
		prod.findElement(productName).click();
		waitForElementToAppear(toastName);
		waitForElementToDisAppear(animationxpath);

	}
	
	


	
	

}
