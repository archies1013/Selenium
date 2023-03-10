package seleniumi_intro;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.SystemMenuBar;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.chromium.ChromiumOptions;
import org.openqa.selenium.edge.EdgeDriver;

import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;


public class Links_Count {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		//give me th counts of the link on the page
		//*any link on the html page have a tag called "a" stands for anchor
		//System.setProperty("webdriver.chrome.driver", "/Users/archanasawant/Documents/chromedriver");//traditional way to invoke chromedriver
		//ChromeOptions chromeOptions = new ChromeOptions();
		//WebDriverManager.chromedriver().setup();//new syntax for webdrivermanager to start the chromedriver
		//WebDriverManager.chromedriver().driverVersion("110.0.5481").setup();
		//ChromeOptions chromeOptions = new ChromeOptions();
		//ChromeOptions options = new ChromeOptions();
		//options.addArguments("--remote-allow-origins=*"); 
		//WebDriver driver = new ChromeDriver();
		//
		
		System.setProperty("webdriver.edge.driver", "/Users/archanasawant/Documents/msedgedriver");
		WebDriver driver = new EdgeDriver();
	
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://www.google.com/");
		driver.navigate().to("https://rahulshettyacademy.com/AutomationPractice/");
		
		//1. Give me the count of links on this page with tag name "a"
		System.out.println(driver.findElements(By.tagName("a")).size());
		
		//2. get me the count of links in the footer section?
		//first you have to create minidriver for footer section with the help of webelement
		//Limiting WebDriver Scope
		WebElement footerdriver=driver.findElement(By.id("gf-BIG"));//this webelement for footer section
	System.out.println(footerdriver.findElements(By.tagName("a")).size());
	
	//3. I want only count of links for first column
	//Please Remember = when you try to single webelemet it "findelement" singular only
	WebElement columndriver=driver.findElement(By.xpath("//table/tbody/tr/td[1]/ul"));//we created webdriver scope which is limited to first column of footerdriver or footer
	System.out.println(columndriver.findElements(By.tagName("a")).size());
	
	//4. Check on each link and check if the pages are opening
	//if the count of links are small like 4 or 5 you can do with help of locators, but if tommorow  the links count is change to 100 links or dynamic thenwe cannot use every time locators
	//what if the links count is dynamic we will use for loop
	
	//this for loop opens all the tab
	for(int i=1; i<(columndriver.findElements(By.tagName("a")).size()); i++)//here we are gtting the coint of links
	{
		
		//columndriver.findElements(By.tagName("a")).get(i).click();//previous code jut to click each link fist link and others
		
		String clickonlinktab=Keys.chord(Keys.COMMAND,Keys.ENTER);//this is for clicking on each link from column driver
		columndriver.findElements(By.tagName("a")).get(i).sendKeys(clickonlinktab);
		Thread.sleep(5000L);
	}
		
		Set<String> abc=driver.getWindowHandles();//this is go all window to get the title
		Iterator<String> it=abc.iterator();//ietaror help us to move one tab to another tab
		//when we do abc.iterator this will give title of 0 index
		
		//this below code iterate each and evry tab and gives you the title
		//we used while loop to handling this child windows
		while(it.hasNext())//it.hasNext tell us that if there is other window present if present then move to next tab
		{
			driver.switchTo().window(it.next());//basically it.next prints window id
			//please remebr that there is diff betn hasNext and next
			//"hasNext" tell us whether next index or tab is present or not and when you say "it.next" it actually moves to next index
		System.out.println(driver.getTitle());
		}
		//basically "while loop" continuously executes the loop until the condition turns to false
		driver.close();
		
	}
	//here we are clicking on that each link and ietrating until the size of links
	//here the test is failed by stale exception bec we did not give back arrow elemt
		//instead of using back and forward arrow here we "will hold command btn and click on links"
		//then we write while loop window handle method and grab the tiltle of each page or link
		//this is optimized way of doing this instaed of going back and forth we will click on each link and opwn in new tab or window
		
	
	/**QUE:
	 * what special you have done in your automation?
	 * Ans: we have some thirty links and we have to validate all 30 links, so we have a scipt where we have to click each and every link
	 * and comeback and again click like we used to take five mins but there after you brought some concept like this and evrything is opening in sepate tabs
	 * on one single shot and that gradually decrease the time 15 mins to 1min and explain this concept
	 * --//this for loop opens all the tab
	 * --//we used while loop to handling this child windows
	 * --//this code iterate each and evry tab and gives you the title
	 * --basically "while loop" continuously executes the loop until the condition turns to false
	 * //basically it.next prints window id
	 * //please remebr that there is diff betn hasNext and next
	//"hasNext" tell us whether next index or tab is present or not and when you say "it.next" it actually moves to next index
	 * //here we are clicking on that each link and ietrating until the size of links
	 * //here the test is failed by stale exception bec we did not give back arrow elemt---this is for previous code 
	-instead of using back and forward arrow here we "will hold command btn and click on links"
	-then we write while loop window handle method and grab the tiltle of each page or link
	-when while loop return false then it will stop iteraring
		//this is optimized way of doing this instaed of going back and forth we will click on each link and open in new tab or window
		- we dividing the the links basically on anchor tab not from the title, if in future the link change code will be the same
		and there is no where we harcoded any link text here
		
	 */
	

}


