package seleniumi_intro;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandlingCalendarUITravel_copy {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		//System.setProperty("webdriver.edge.driver", "/Users/archanasawant/Documents/msedgedriver");
		//WebDriverManager.chromedriver().setup();
		WebDriverManager.edgedriver().setup();
		WebDriver driver = new EdgeDriver();
		driver.get("https://www.google.com/");
		driver.manage().window().maximize();
		driver.navigate().to("https://www.path2usa.com/travel-companion/");
		/**Lets do it step by step, do not jump to all
		 * -first grab date and then month 
		 * 
		 */
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1000)");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		//driver.findElement(By.cssSelector("input[id='form-field-travel_from']")).click();
		driver.findElement(By.xpath("//input[@placeholder='Date of travel']")).click();//clicking to select date
		
		//List<WebElement> dates=driver.findElements(By.className("flatpickr-day"));//created webemenet to see count of days
		
		//List<WebElement> dates=driver.findElements(By.className("day"));//creaclassname locator not working
		List<WebElement>dates=driver.findElements(By.xpath("//span[@class='flatpickr-day ']"));
		//int counts=driver.findElements(By.className("flatpickr-day")).size();classname locator not working
		int count=driver.findElements(By.xpath("//span[@class='flatpickr-day ']")).size();
		//int count=driver.findElements(By.className("day")).size();classname locator not working
		
		for(int i=0;i<count;i++)
		{
			String text=driver.findElements(By.xpath("//span[@class='flatpickr-day ']")).get(i).getText();
			//String text=driver.findElements(By.className("flatpickr-day")).get(i).getText();//classname locator not working
			//String text=driver.findElements(By.className("day")).get(i).getText();classname locator not working
			if (text.equalsIgnoreCase("23"));
			
			{
				driver.findElements(By.xpath("//span[@class='flatpickr-day ']")).get(i).click();
				//driver.findElements(By.className("flatpickr-day")).get(i).click();classname locator not working
				//driver.findElements(By.className("day")).get(i).click();classname locator not working
				break;
			}
		}	
		
	}

}
