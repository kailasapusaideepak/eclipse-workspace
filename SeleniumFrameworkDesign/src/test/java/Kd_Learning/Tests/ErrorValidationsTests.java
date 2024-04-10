package Kd_Learning.Tests;

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
import Kd_Learning_POM.pageobjects.ProductCatalogue;
import io.github.bonigarcia.wdm.WebDriverManager;

public class ErrorValidationsTests extends BaseTest {

	@Test (groups= {"ErrorHandling"})
	public void SubmitOrder() throws IOException {

		String productName = "ZARA COAT 3";

		loginpage.LoginAction("kd1@gmail.com", "Qwerty@143");
		Assert.assertEquals("Incorrect email or password", loginpage.ErrorMessage());

	}

}
