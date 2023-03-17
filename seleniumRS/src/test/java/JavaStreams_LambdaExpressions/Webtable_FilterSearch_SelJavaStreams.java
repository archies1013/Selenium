package JavaStreams_LambdaExpressions;

import static org.testng.Assert.assertEquals;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

public class Webtable_FilterSearch_SelJavaStreams {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ChromeOptions options= new ChromeOptions();
		options.addArguments("start-maximized");
		options.addArguments("--remote-allow-origins=*"); 
		WebDriver driver = new ChromeDriver(options);
		driver.get("https://www.google.com/");
		driver.navigate().to("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		driver.findElement(By.id("search-field")).sendKeys("Rice");//we are sending key to the search button
		List<WebElement>veggies=driver.findElements(By.xpath("//tr/td[1]"));//you get the list of all viggies present in list
		List<WebElement>filteredList=veggies.stream().filter(veggie->veggie.getText().contains("Rice")).collect(Collectors.toList());
		/**all the elements from this list will go this filter and whatever the element which match with send key
		 * we will collect that element into list again then you get two list(veggies and filteredlist)
		 * so this both list should be same (identical)
		 * and to compare this will use assert.assertequal and if both size matches then your tc will pass
		 */
			Assert.assertEquals(veggies.size(), filteredList.size());
	
	
	
	
	
	
	}
}
