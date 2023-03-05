package seleniumi_intro;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.lang.model.element.Element;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Implicit_Explicit_Fluent_ThreadSleep {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
//How to handle when you have to add multiple products in carts
		//How to write the code in generic so that it supports multiple datasets -- interview question from amazon
		//make list of array and pass that array into this block and whatever product you get that from 
		//for loop check if those product are present in arraylist if it is present then go and click
		
		System.setProperty("webdriver.chrome.driver", "/Users/archanasawant/Documents/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.com/");
		//driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);//this is depricated 
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));//declare implicit wait
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));//declare explicit wait
		String[]itemsNeeded= {"Cucumber", "Brocolli", "Beetroot"};//this is how you declare arrayList in Java
		int j=0;
		
		driver.navigate().to("https://rahulshettyacademy.com/seleniumPractise/");
		
		//have an array with list of vegetables you want select
		//**String name = "Cucumber"  **this how you declare string in Java
		
		//String[]itemsNeeded= {"Cucumber", "Brocolli", "Beetroot"};//this is how you declare arrayList in Java
		//int j=0;
		
		//use find elements to access all matching products bec we are using xpath or css for more products(elements)
		//List<WebElement> products=driver.findElements(By.cssSelector("h4.product-name"));
		Thread.sleep(3000);
		addItems(driver,itemsNeeded);//your are calling this method without creating a object of this class for that your method should be static
		driver.findElement(By.cssSelector("img[alt='Cart']")).click();
		//TEXT locator = if it is static text you can use for find element
		//but if it is a Dynamic text (keep changing) you cannot use it
		driver.findElement(By.xpath("//button[contains(text(),'PROCEED TO CHECKOUT')]")).click();//click checkout button
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='promoBtn']")));
		driver.findElement(By.cssSelector("input.promoCode")).sendKeys("rahulshettyacademy");
		driver.findElement(By.xpath("//button[@class='promoBtn']")).click();//click on apply btn
		//here if taking time to display the text then explicit wait help here to wait until that text will display
		//if you put explicit wait here that will not affect any othe line of code it will affect only after this line
		//WebDriverWait w= new WebDriverWait(driver, 5);//this syntax is depricated
		//WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));//give two arguments driver and second
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span.promoInfo")));//explicit wait syntax
		System.out.println(driver.findElement(By.cssSelector("span.promoInfo")).getText());
		
		
	
	
	
	}
	
	public static  void addItems(WebDriver driver,String[] itemsNeeded)//we need to give webdriver driver so driver will get knowledge of this classmethod
	{
		//in general return type of find elements is "WebElement"
		//whenever you found more size elements its time to use loops and conditions
		//iterates to every product and when matches to cucumber then you will get that index after getting 
		//the index then you can hit the add to cart button
		//let say if you have 30 elements in that xpath then this loop will iterate 30 time to get that product which we need to add in cart
		int j=0;
		List<WebElement> products=driver.findElements(By.cssSelector("h4.product-name"));
		for(int i=0; i<products.size(); i++)
		{
			//e.g = Cucumber 1 kg
			//String name=products.get(i).getText();//we are extracting 0th index value first and then it will keep iterating until reach to products size
			String[] name=products.get(i).getText().split("-");
			String formatedName=name[0].trim();
			//name 0 = Cucumber
			//name 1 = 1 Kg
			//if you want space after the word you can use trim mehod
			
			//format it to actual vagetable name
			//if you convert above array to array list then it well be easy search
			//hoe to convert array to arraylist
			//check whether the name you extracted are present in array or not
			
			//List <String>itemsNeededList= new ArrayList<>();
			List itemsNeededList= Arrays.asList(itemsNeeded);
			//List itemsNeededList=Arrays.asList(itemsNeeded);
			
			//List itemsNeededList = Arrays(itemsNeeded)); 
		
			if(itemsNeededList.contains(formatedName))
			{
				j++;
				//click or add to cart
				//driver.findElements(By.xpath("//button[text()='ADD TO CART']")).get(i).click();//never take the TEXT to find the elements
				//div[@class='product-action']/button
				driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
				//break;//for this arraylist concept you cannot use break bec until you finished iterating the lements you cannot come out
				//you cannot use break when you going with multiple bag of arrays
				//if(j==3)//before we gave if array size is changing dynamically then give array.length
					if(j==itemsNeeded.length)
				{
					break;
				}
				//amazon question:: everyday new products added to the amazon marketplace, so whenever they added new items they want make 
				//sure if they will able to add to cart or not
			}
		
		}
		
		/*if you want use any reusable method you have to write outside of the main method
		 * 
		 */
		
		
		
	}

}//not working at 71 72 73
//it worked when I import manually import java.util.Arrays;
