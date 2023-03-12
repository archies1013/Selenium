package seleniumi_intro;

import java.time.Duration;
import java.time.temporal.TemporalAmount;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandlingCalendarUITravel {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		//System.setProperty("webdriver.edge.driver", "/Users/archanasawant/Documents/msedgedriver");
		//WebDriverManager.chromedriver().setup();
//		WebDriverManager.edgedriver().setup();
//		WebDriver driver = new EdgeDriver();
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("start-maximized");
		options.addArguments("--remote-allow-origins=*"); 
		WebDriver driver = new ChromeDriver(options);
//		
		driver.get("https://www.google.com/");
	//driver.manage().window().maximize();
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
		
		//driver.findElement(By.xpath("//div[@class='flatpickr-current-month']")).getText().contains("April");
		
		//while loop except values true or false, if it is true it will go inside the blog and excecute it
		//if false it will skip that blog
		//!(nugation) is nothing if it false it becomes true, if its true and when you add ! (nugation) to it it will become false
		while(!driver.findElement(By.xpath("//div[@class='flatpickr-current-month']")).getText().contains("May"))
		{
			driver.findElement(By.xpath("//span[@class='flatpickr-next-month']")).click();
		}
		
		//List<WebElement>dates=driver.findElements(By.xpath("//div[@class='flatpickr-days']"));
		List<WebElement>dates=driver.findElements(By.xpath("//div[@class='dayContainer']"));
		//List<WebElement>dates=driver.findElements(By.xpath("//span[@class='flatpickr-day ']"));
		//int counts=driver.findElements(By.className("flatpickr-day")).size();classname locator not working
		//int count=driver.findElements(By.xpath("//div[@class='flatpickr-days']")).size();
		int count=driver.findElements(By.xpath("//div[@class='dayContainer']")).size();
		//int count=driver.findElements(By.xpath("//span[@class='flatpickr-day ']")).size();
		//int count=driver.findElements(By.className("day")).size();classname locator not working
		
		for(int i=0; i<count; i++)
		{
			//String text=driver.findElements(By.xpath("//div[@class='flatpickr-days']")).get(i).getText();
			String text=driver.findElements(By.xpath("//div[@class='dayContainer']")).get(i).getText();
			//String text=driver.findElements(By.xpath("//span[@class='flatpickr-day ']")).get(i).getText();
			//String text=driver.findElements(By.className("flatpickr-day")).get(i).getText();//classname locator not working
			//String text=driver.findElements(By.className("day")).get(i).getText();classname locator not working
			if (text.equalsIgnoreCase("25"))
			Thread.sleep(i);
			{
				//driver.findElements(By.xpath("//span[@class='flatpickr-days']")).get(i).click();
				driver.findElements(By.xpath("//div[@class='dayContainer']")).get(i).click();
				//driver.findElements(By.xpath("//span[@class='flatpickr-day ']")).get(i).click();
				//driver.findElements(By.className("flatpickr-day")).get(i).click();classname locator not working
				//driver.findElements(By.className("day")).get(i).click();classname locator not working
				break;
			}
		}	
		
		//driver.close();
		//Grab common attributes put it in the list and iterate
		
	}

}
