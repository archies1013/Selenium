package seleniumi_intro;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Actions_Demo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "/Users/archanasawant/Documents/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.com");
		Actions a=new Actions(driver);//we need to create the action class if we want to do some action
		WebElement move=(driver.findElement(By.xpath("//span[@id='nav-link-accountList-nav-line-1']")));
		//this action will type in search box hello in capital letters
		a.moveToElement(driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"))).click().keyDown(Keys.SHIFT).sendKeys("hello").doubleClick().build().perform();
		
		//this action used to move mouse to specific element
		a.moveToElement(driver.findElement(By.xpath("//span[@id='nav-link-accountList-nav-line-1']"))).contextClick().build().perform();
		
		//here .build = it just build the code and get ready for execute but not execute by build only for that we need to give .perform to execute the code
		//.perform = will execute the code
		//we are using this both .build and .perform to do composite actions 
		
		/*how to enter any capital string or letter in any search boxes using keydown shift 
		 * contextClick is for right click
		 * 
		 */
		
		driver.close();
		
		
		
		
	}

}
