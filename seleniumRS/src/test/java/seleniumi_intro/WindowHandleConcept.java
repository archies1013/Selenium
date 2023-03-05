package seleniumi_intro;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowHandleConcept {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "/Users/archanasawant/Documents/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/loginpagePractise/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.cssSelector("a[class='blinkingText']")).click();
		Set<String>windows=driver.getWindowHandles();//now we have two "parentId, childId", which sitting on this object
		//this method getwindowhandles method will get windowhandlesid of all the windows which open by your automation
		//return type of this method is Set<String>
		Iterator<String>it=windows.iterator();//this method we are using the access the element from parentid window and childid window
		String parentid=it.next();//now this it object have the knowledge of parentid and childid and when you do it.next you will go to the next window
		String childid=it.next();//from this you you will go the child id
		driver.switchTo().window(childid);//now switching to child windows and pass in argument which window you want to switch
		System.out.println(driver.findElement(By.cssSelector(".im-para.red")).getText());
		driver.findElement(By.cssSelector(".im-para.red")).getText();
		//will see how parse our string "Please email us at mentor@rahulshettyacademy.com with below template to receive response"
		//	we need only "mentor@rahulshettyacademy.com" to enter in parent window
		System.out.println(driver.findElement(By.cssSelector(".im-para.red")).getText().split("at")[1].trim().split(" ")[0]);
		String emailId=driver.findElement(By.cssSelector(".im-para.red")).getText().split("at")[1].trim().split(" ")[0];
		//now we need to swirch to parentid
		driver.switchTo().window(parentid);
		driver.findElement(By.id("username")).sendKeys(emailId);//if we are gining variable in send do not give in variable
		
		//driver.close();
		
		
		
		
		
	}

}
