package seleniumi_intro;

import org.hamcrest.core.AnyOf;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandlingJavaAlertsUsingSeleniumWebdriver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*
		 * ALERT= Unfortunatly the window pop up is not HTML based so that means it is
		 * not tide to the web if it is not html you will not get any prpoerties to get
		 * xpath or css for these bec these pop up are not comming form html these are
		 * Java Script alert and Selenium can default cannot handle these so that the
		 * reason they have provided one mechanism where you can switch your driver to
		 * alerts and you can accept it
		 */

		String text = "Rahul";// we declare variable here so we can use whenever we want instead of using
								// string directly
		System.setProperty("webdriver.chrome.driver", "/Users/archanasawant/Documents/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.com/");
		driver.navigate().to("https://rahulshettyacademy.com/AutomationPractice/");
		driver.findElement(By.id("name")).sendKeys(text);
		driver.findElement(By.xpath("//input[@id='alertbtn']")).click();
		// driver.findElement(By.cssSelector("input[id='alertbtn']")).click();
		System.out.println(driver.switchTo().alert().getText());
		driver.switchTo().alert().accept();
		// to handle the alert you have to switch your driver to alert mode and then
		// accept it and then grab the text
		// now see confirm button
		driver.findElement(By.id("confirmbtn")).click();
		System.out.println(driver.findElement(By.id("confirmbtn")).getText());
		driver.switchTo().alert().dismiss();

		driver.close();
	}

}
