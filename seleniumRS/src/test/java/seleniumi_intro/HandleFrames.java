package seleniumi_intro;

import static org.testng.Assert.ARRAY_MISMATCH_TEMPLATE;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class HandleFrames {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "/Users/archanasawant/Documents/chromedriver");
		WebDriver driver = new ChromeDriver();
	
		driver.get("https://jqueryui.com/droppable/");
		/*Frame:
		 * frame() has multiple overloads.
driver.switchTo().frame(name_or_id) ...
driver.switchTo().frame(index) ...
driver.switchTo().frame(iframe_element)
		 * 
		 * 
		 */
		System.out.println(driver.findElements(By.tagName("iframe")).size());//also we can do drag drop with the help of index
		driver.switchTo().frame(0);//this is switch using index(like array frames also start with 0 ondex, as there is one count 
		//of frame so that comes on 0 index )
		
		//driver.switchTo().frame(driver.findElement(By.cssSelector("iframe.demo-frame")));//this is for switch using webelement
		
		//driver.findElement(By.id("draggable")).click();
		//here we are using Action Class
		Actions a=new Actions(driver);
		WebElement source= 	driver.findElement(By.id("draggable"));
		WebElement target= 	driver.findElement(By.id("droppable"));
		a.dragAndDrop(source, target).build().perform();
		driver.switchTo().defaultContent();
		
		
		
		driver.close();
		
		
		
	}

}
