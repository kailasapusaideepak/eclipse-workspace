package Kd_Learning_POM.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ConfrimationPage extends kd_Learning.AbstractComponents.AbstractComponents{

	WebDriver driver;
	public ConfrimationPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);	
	}

	@FindBy(css=".hero-primary")
	WebElement confirmMsg;
	
	public String getCofirmMsg()
	{
		String confirmMessage=confirmMsg.getText();
		return confirmMessage;
	}
	
	
}
