package seleniumi_intro;

import java.sql.Driver;
import java.time.Duration;

import org.checkerframework.dataflow.qual.SideEffectFree;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Locators1 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		String name = "rahul";
		System.setProperty("webdriver.chrome.driver", "/Users/archanasawant/Documents/chromedriver");
		WebDriver driver = new ChromeDriver();
		//System.setProperty("webdriver.gecko.driver", "/Users/archanasawant/Documents/geckodriver");
		//WebDriver driver = new FirefoxDriver();
		//System.setProperty("webdriver.edge.driver", "/Users/archanasawant/Documents/msedgedriver");
		//WebDriver driver = new EdgeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		String password=getPassword(driver);
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		driver.findElement(By.id("inputUsername")).sendKeys(name);
		driver.findElement(By.name("inputPassword")).sendKeys(password);
		driver.findElement(By.className("signInBtn")).click();
		Thread.sleep(2000);
		System.out.println(driver.findElement(By.tagName("p")).getText());
		Assert.assertEquals(driver.findElement(By.tagName("p")).getText(),"You are successfully logged in.");
		//we are using assertions to validate expected value with actual value
		Assert.assertEquals(driver.findElement(By.cssSelector("div[class='login-container'] h2")).getText(),"Hello " + name+",");
		//for link locator it will be anchor "a"
		//there is no css syntax to identify based upon the text//this is fot xpath //button[text()='Log Out']
		//this locator is unique for xpath only
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[text()='Log Out']")).click();
		driver.close();
	}
	//here we will create one method for giving the password
	//here we will see how to grab the passcode without hardcoding
	//Here you are extracting and parsing dynmically your password from password string
	public static String getPassword(WebDriver driver) throws InterruptedException//whenever you said there is no return type
	{
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		//basically we have send as an input "webdriver driver" otheryou will error for driver
		driver.findElement(By.linkText("Forgot your password?")).click();
		Thread.sleep(1000);
		//driver.findElement(By.cssSelector(".reset-spwd-btn")).click();
		driver.findElement(By.cssSelector(".reset-pwd-btn")).click();//this is for firefox driver
		String passwordText=(driver.findElement(By.cssSelector("form p")).getText());//we will copy that text in one variable
		//now we have to split the text from above and extract only "rahulshettyacademy"
		//here we can split method with the help of variable "passwordText"
		//if we split this text that will split into two different pieces
		String[] passwordArray=passwordText.split("'");
		//this is string we have to split "Please use temporary password 'rahulshettyacademy' to Login."
		//in 0index left side of this character string get store - Please use temporary password
		//in 1stIndex right Side of this charachter string get store - 'rahulshettyacademy' to Login.
		//this method will return one array for us
	//	String[] passwordArray2=passwordArray[1].split("'");
	//   passwordArray2[0]
		String password=passwordArray[1].split("'")[0];//above two line are equal to this line
		//from this string now 
		//here 0 Index is = rahulshettyacademy
		//and 1st Index = to Login.
		//you can create new variable or use the 1st Index directly
		return password;//here you need to change return type to String
		//if you want call any method you need to create object of that class
		//when you change that method into static you can that method from main without creating the object
		
		
	}

}
