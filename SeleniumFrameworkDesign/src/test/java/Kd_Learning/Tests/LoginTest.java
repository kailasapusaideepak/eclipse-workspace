package Kd_Learning.Tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.AssertJUnit;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import Kd_Learning.TestComponents.BaseTest;
import Kd_Learning_POM.pageobjects.CartPage;
import Kd_Learning_POM.pageobjects.CheckOutPage;
import Kd_Learning_POM.pageobjects.ConfrimationPage;
import Kd_Learning_POM.pageobjects.LoginPage;
import Kd_Learning_POM.pageobjects.OrderPage;
import Kd_Learning_POM.pageobjects.ProductCatalogue;
import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginTest extends BaseTest {
	String productName = "ZARA COAT 3";
	
	
	@Test (dataProvider = "getData", groups= {"purchase"})
	public void SubmitOrder(String email, String pwd, String productName) throws IOException {

	

		loginpage.LoginAction(email , pwd);

		ProductCatalogue productcatalogue = new ProductCatalogue(driver);
		List<WebElement> products = productcatalogue.getProducts();
		productcatalogue.addProductToCart(productName);
		productcatalogue.clickCartButton();

		CartPage cartpage = new CartPage(driver);
		Boolean match = cartpage.cartItemsComparission(productName);
		System.out.println(match);
		Assert.assertTrue(match);
		cartpage.goTocheckOutPage();

		CheckOutPage checkoutpage = new CheckOutPage(driver);
		checkoutpage.SelectCountry();

		ConfrimationPage confirmationpage = checkoutpage.submitOrder();
		String confirmMsg = confirmationpage.getCofirmMsg();
		Assert.assertTrue(confirmMsg.equalsIgnoreCase("THANKYOU FOR THE ORDER."));

		

	}
	
	// dependency test 
	// checking the orders tab that it matches with the product name
	
	@Test(dependsOnMethods= {"SubmitOrder"})
	public void OrderHistroyTest()
	{
		loginpage.LoginAction("kd1@gmail.com", "Qwerty@123");
		ProductCatalogue productcatalogue = new ProductCatalogue(driver);
		OrderPage orderpage=productcatalogue.clickOrderButton();
		Assert.assertTrue(orderpage.verifyOrderDisplay(productName));
		

	}
	
	@DataProvider
	 public Object[][] getData()
	 {
		return new Object [][] { {"sai2520@gmail.com", "Qwerty@123", "ADIDAS ORIGINAL"}, {"kd1@gmail.com", "Qwerty@123","ZARA COAT 3" }};
	 }

}
