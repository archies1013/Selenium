package seleniumi_intro;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class CalendarUI_RSA {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ChromeOptions options = new ChromeOptions();
		options.addArguments("start-maximized");
		options.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(options);
		driver.get("https://www.path2usa.com/travel-companions");
//April 23
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1000)");
//driver.findElement(By.xpath(".//*[@id='travel_date']")).click();RSAcode
		driver.findElement(By.xpath("//input[@placeholder='Date.of.travel']")).click();

		// while(!driver.findElement(By.cssSelector("[class='datepicker-days'][class='datepicker-switch']")).getText().contains("May"))RSA
		while (!driver.findElement(By.xpath("//div[@class='flatpickr-current-month']")).getText().contains("May")) 
		{
			//driver.findElement(By.cssSelector("[class='datepicker-days'] th[class='next']")).click();RSA
			driver.findElement(By.xpath("//span[@class='flatpickr-next-month']")).click();
			
		}

		//List<WebElement> dates = driver.findElements(By.className("day"));
		List<WebElement>dates=driver.findElements(By.xpath("//div[@class='flatpickr-days']"));
//Grab common attribute//Put into list and iterate
		//int count = driver.findElements(By.className("day")).size();RSA
		int count=driver.findElements(By.xpath("//div[@class='flatpickr-days']")).size();

		for (int i = 0; i < count; i++) 
		{
			//String text = driver.findElements(By.className("day")).get(i).getText();
			String text=driver.findElements(By.xpath("//div[@class='flatpickr-days']")).get(i).getText();
			//if (text.equalsIgnoreCase("21")) 
			if (text.equalsIgnoreCase("20"))	
			{
				//driver.findElements(By.className("day")).get(i).click();
				driver.findElements(By.xpath("//div[@class='flatpickr-days']")).get(i).click();
				break;
			}

		}
	}

}
