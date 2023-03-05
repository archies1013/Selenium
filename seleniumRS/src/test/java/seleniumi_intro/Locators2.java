package seleniumi_intro;

import java.net.URL;
import java.sql.Driver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Locators2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//here will see another way to find locatorss
		//This is called "Sibling - Sibling and Child to - Parent Traverse"
		//Absolute Xpath - You will start from the top that is from html to child that means you are writing Absolute Xpath
		//When you writing Absolute Xpath you can start with single /, it represent your are staring from the root of the html
		//if you go with Absolute Xpath it can be a so large with so many tags and if somthing break in middle of the hieraracy your xpath will go for a toss
		//this relative xpath for practice button "//header/div/button[1]" from "https://rahulshettyacademy.com/AutomationPractice/"
		//   //header/div/button[1]/following-sibling::button[1]    //this xpath is for parent to childs to sibling to other sibling
		
		//lets write the script to reach login page
		System.setProperty("webdriver.chrome.driver", "/Users/archanasawant/Documents/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		//driver.findElement(By.xpath("//header/div/button[1]/following-sibling::button[1]")).click();
		System.out.println(driver.findElement(By.xpath("//header/div/button[1]/following-sibling::button[1]")).getText());
		//we wrote this xpath (sibling child parent traverse)
		
		//***Now we see how to travel back from Child to Parent"
		//here is **child to parent xpath from the same above element
		//***//header/div/button[1]/following-sibling::button[1]    (sibling child parent traverse xpath)
		//***//header/div/button[1]/parent::div  (child to parent xpath)    (child to parent xpath)
		//****//header/div/button[1]/parent::div/parent::header/a[1]      (from parent to child and child to parent traverse xpath )
		//you cannot do all these in css
		System.out.println(driver.findElement(By.xpath("//header/div/button[1]/parent::div/button[2]")).getText());
		
		
		
		}

}
