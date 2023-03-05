package seleniumi_intro;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Handling_AutoSuggestive_Dropdown {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		
		System.setProperty("webdriver.chrome.driver", "/Users/archanasawant/Documents/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.com/");//
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		driver.findElement(By.id("autosuggest")).sendKeys("Ind");
		Thread.sleep(3000);
		//this is generic css for all elements to search after any country
		List<WebElement>options = driver.findElements(By.cssSelector("li[class='ui-menu-item'] a"));
	
		//will right here "Enhanced for loop"
		for(WebElement option: options)
		{
			if(option.getText().equalsIgnoreCase("India"))
			{
				option.click();
				break;
			}	
		
			}
			//Autosuggestive dropdown : whenever you see autosuggestive dropdown without having any options, your first goal is to provide input
			//and then figure out the generic locator which extract all the elements and store it in "List" and then iterate over the list and thet get text 
			//to see if it matches with your real value and click on that break your loop
		
		//driver.close();
	}

}
