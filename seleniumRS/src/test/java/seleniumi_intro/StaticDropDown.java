package seleniumi_intro;

import java.sql.Driver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class StaticDropDown {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		//Mostly "select" are in Static dropdown 
		System.setProperty("webdriver.chrome.driver", "/Users/archanasawant/Documents/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.com/");//
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		//dropdown with select tag
		//how we will know if the dropdown is static or not - just see if the tagname is select or not, 
		//if tagname is "select" definitly the dropdown is static
		WebElement StaticDropDown=driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
		Select dropdown= new Select(StaticDropDown);//first create an object for an select tag
		//now we can access all methods of dropdown by using object
		//but do rember all this methods comes in handy when you select tag in dropdown
		dropdown.selectByIndex(3);//this is one way to select dropdown with index
		System.out.println(dropdown.getFirstSelectedOption().getText());
		dropdown.selectByVisibleText("AED");//this is another way of selecting dropdown
		System.out.println(dropdown.getFirstSelectedOption().getText());	
		dropdown.selectByValue("INR");//this is third way of selecting dropdown by value
		System.out.println(dropdown.getFirstSelectedOption().getText());
		
		
		driver.close();
	}

}
