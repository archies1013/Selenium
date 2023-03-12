package seleniumi_intro;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;

public class ParsingString_CovertToInt_Scrolling {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		/**
		 * Headless Browser- so that means Browser invocation will not be there. Test
		 * execution will run based upon chrome service Execution will faster in
		 * headless mode
		 * 
		 * QUE: How can you chroll your webpage or componant - we can do it with the
		 * help of javaScript Executor
		 */
		// System.setProperty("webdriver.chrome.driver",
		// "/Users/archanasawant/Documents/chromedriver");
		// WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("start-maximized");
		options.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(options);
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0, 500)");// use to scroll down webpage
		Thread.sleep(0, 500);
		js.executeScript("document.querySelector('.tableFixHead').scrollTop=5000");// this is to scroll down the inside
																					// component or table

		/**
		 * now we will add all amount from the fourth column we will store all elements
		 * in one list
		 */
		// then import packages like util and webelement
		List<WebElement> values = driver.findElements(By.cssSelector(".tableFixHead td:nth-child(4)"));
		/**
		 * To sum all integer Initiate one variable int=0;
		 * 
		 * 
		 */

		/**
		 * Now iterate each and every element and some them iterate them with size of
		 * the values then do get text(always return you in string format) and convert
		 * them into integer convert string to integer = Interger.parseInt
		 */
		int sum = 0;//
		for (int i = 0; i < values.size(); i++) {
			System.out.println(Integer.parseInt(values.get(i).getText()));// this will convert string into integer
			sum = sum + Integer.parseInt(values.get(i).getText());// this is for to sum the all values of table
			/**
			 * Here the sum = 0, when it go inside in for loop it will iterarting like 1st
			 * sum = 0+28 then 28 + next value them 52+next value 48.. this is how it will
			 * keep iterating until the last value and the last value is all total of all
			 * value
			 * 
			 */
		}

		System.out.println(sum);
		// next this compare the value which you got and what is there on website
		// alraedy posted
		driver.findElement(By.xpath("//div[@class='totalAmount']")).getText();
		int Total = Integer.parseInt(driver.findElement(By.xpath("//div[@class='totalAmount']")).getText().split(":")[1].trim());
		Assert.assertEquals(sum, Total);//assert to compare values actual and expected that is sum and total

	}

}
