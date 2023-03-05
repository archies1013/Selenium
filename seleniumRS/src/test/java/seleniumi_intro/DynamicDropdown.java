package seleniumi_intro;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DynamicDropdown {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		//Dynamic Dropdown – we called dynamic dropdown because these dropdowns loaded when we or user do some selection or  
		//action on that dropdown after clicking, then only they appear or loaded on the same page, those dropdown called dynamic dropdown.
		System.setProperty("webdriver.chrome.driver", "/Users/archanasawant/Documents/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.com/");//
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		//this xpath for Chennai  --  //a[@value='MAA']
		//this xpath for chennai as per index if there are mulpiple elements---   (//a[@value='MAA'])[2]
		//this for Bengaluru ---- //a[@value='BLR']
		driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();//this id element is for departures
		driver.findElement(By.xpath("//a[@value='BLR']")).click();
		//System.out.println(driver.findElement(By.xpath("//a[@value='BLR']")).getText());
		Thread.sleep(2000);//this step is use to hold or pause your test
		//    ctl00_mainContent_ddl_destinationStation1_CTXT     --this id element for arrival
		//driver.findElement(By.id("ctl00_mainContent_ddl_destinationStation1_CTXT")).click();
		//driver.findElement(By.xpath("(//a[@value='MAA'])']")).click();//here we getting an error "element is not visible" bec two elements
		//are present with chennai (departure and arrival each one) we need to select second elemnt that send Index[2]
		//driver.findElement(By.xpath("(//a[@value='MAA'])[2]")).click();
		//System.out.println(driver.findElement(By.xpath("(//a[@value='MAA'])[2]")).getText());//some clients dont allow indexes in code
		
		//this is how you can do dynamic dropdown or any dynamic UI on the screen
		//driver.findElement(By.xpath("//div[@id = 'glsctl00_mainContent_ddl_originStation1_CTNR']")).click();
		//driver.findElement(By.xpath("//a[@value='BLR']")).click();
		//driver.findElement(By.xpath("//div[@id = 'glsctl00_mainContent_ddl_originStation1_CTNR'] //a[@value='BLR']")).click();
		//this is select calendar
		driver.findElement(By.xpath("//div[@id = 'glsctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='MAA']")).click();
		//above is parent child relationship concept  parent = //tagname[@attribute = 'value']space child //tagname[@attribute='value']
		
		driver.close();
		
		
		
	}

}
