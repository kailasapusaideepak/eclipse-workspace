import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebElement;

public class AutosuggestiveDD {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		WebDriver driver=new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		
		driver.findElement(By.id("autosuggest")).sendKeys("ind");
		Thread.sleep(3000);
		
		// Here we are selecting all the options in the suggestions by CSS parent child traverse
		List<WebElement> options= driver.findElements(By.cssSelector("li[class='ui-menu-item'] a"));
		
		for( WebElement option :options)
		{
		  if(option.getText().equalsIgnoreCase("India"))
		  {
				  option.click();
		  }
		  

	    }

}
	
	
}	
	
