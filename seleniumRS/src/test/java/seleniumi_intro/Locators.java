package seleniumi_intro;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class Locators {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "/Users/archanasawant/Documents/chromedriver");
		WebDriver driver = new ChromeDriver();//above and this line will open the browser//basically 'driver' is object of ChromeDriver class which helping us to find every element
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		//if something is not showning in console as text we are giving 5sec wait and this globally applicable for every step
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		driver.findElement(By.id("inputUsername")).sendKeys("rahul");//if you want to type any text then you have to use sendkeys method
		driver.findElement(By.name("inputPassword")).sendKeys("abc123");//rahulshettyacademy
		driver.findElement(By.className("signInBtn")).click(); //(submit signInBtn) whenever there is space betn two words 
		//that means that element has two classes or two values you can choose one only
		System.out.println(driver.findElement(By.cssSelector("p.error")).getText());//getText method to get text
		//In java if you want see anything in console output you have to wrap that code in syso 
		//we got error msg in console with line 20 because of timeout session/synchronization
		//Implicit Wait - Basically it tells the code to wait till 1sec 0r 5sec bases upon number of sec timeout you provide here
		//Now we will see XPATh and LinkText locators
		//after inspect whenever you see anchor a that part is link and you can click any link by using linktext locator
		driver.findElement(By.linkText("Forgot your password?")).click();//you can any locator for any step
		//Thread.sleep(1000);//we have to this sleep whenever we get error
		//XPATh and CSSselector are generic locator you can construct the Xpathand CSsselector and find the element
		//syntax of CssSelector = Tagname[attribute = ‘value’]
		//syntax for Xpath = //Tagname[@attribute = ‘value’]
		//write xpath for this html code = <input type="text" placeholder="Name">
		//so xpath = //input[placeholder = 'Name']
		driver.findElement(By.xpath("//input[@placeholder = 'Name']")).sendKeys("John");
		driver.findElement(By.cssSelector("input[placeholder = 'Email']")).sendKeys("John@rsa.com");//"//input[@type= 'text'][2]" this XPATH by using type with index number
		//driver.findElement(By.cssSelector("input[placeholder = 'Email']")).clear();
		driver.findElement(By.xpath("//input[@type= 'text'][2]")).clear();
		driver.findElement(By.cssSelector("input[placeholder = 'Email']")).sendKeys("John@gmail.com");
		//for cssSelector you have to like this - "input[type= 'text']:nth-child[3]"
		driver.findElement(By.cssSelector("input[type= 'text']:nth-child(3)")).clear();
		//this xpath by using Parent-Child tagname -- "//form/input[3]"
		driver.findElement(By.xpath("//form/input[3]")).sendKeys("2345675555");
		//driver.findElement(By.cssSelector("button.reset-pwd-btn")).click();//here we did xpath by tagname.classname
		driver.findElement(By.cssSelector(".reset-pwd-btn")).click();//actuallu if you get error here"ElementClickIntercepted"
		System.out.println(driver.findElement(By.cssSelector("form p")).getText());//using parent child tagname for css (parenttagname space childtagname)
		//solution for Element click intercepted
		driver.findElement(By.xpath("//div[@class = 'forgot-pwd-btn-conainer']/button[1]")).click();
		driver.findElement(By.cssSelector("#inputUsername")).sendKeys("rahul");//(#idname) for cssSelector
		driver.findElement(By.cssSelector("input[type*='pass']")).sendKeys("rahulshettyacademy");
		driver.findElement(By.id("chkboxOne")).click();//no need to put #
		//driver.findElement(By.xpath("//button[@class='submit signInBtn']"));
		driver.findElement(By.xpath("//button[contains(@class,'submit')]")).click();
				
				
				
		
	}

}
