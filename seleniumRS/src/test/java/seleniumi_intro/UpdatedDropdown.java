package seleniumi_intro;

import static org.testng.Assert.assertTrue;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class UpdatedDropdown {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "/Users/archanasawant/Documents/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.com/");//
		driver.navigate().to("https://rahulshettyacademy.com/dropdownsPractise/");	

		//Handling "+ and -" on website

		//Selecting checkbox "family and friends"
		//System.out.println(driver.findElement(By.cssSelector("input[id='ctl00_mainContent_chk_SeniorCitizenDiscount']")).isSelected());
		Assert.assertFalse(driver.findElement(By.cssSelector("input[id='ctl00_mainContent_chk_SeniorCitizenDiscount']")).isSelected());
		driver.findElement(By.cssSelector("input[id='ctl00_mainContent_chk_SeniorCitizenDiscount']")).click();
		//System.out.println(driver.findElement(By.cssSelector("input[id='ctl00_mainContent_chk_SeniorCitizenDiscount']")).isSelected());
		Assert.assertTrue(driver.findElement(By.cssSelector("input[id='ctl00_mainContent_chk_SeniorCitizenDiscount']")).isSelected());
		
		//for CALENDAR
		//***Validating if UI Elements are disabled or Enabled with Attributes 
		//will see radio button
		//System.out.println(driver.findElement(By.name("ctl00$mainContent$view_date1")).isEnabled());//here it will false
		System.out.println(driver.findElement(By.id("Div1")).getAttribute("style"));
		driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_1")).click();
		System.out.println(driver.findElement(By.id("Div1")).getAttribute("style"));
		
		//System.out.println(driver.findElement(By.name("ctl00$mainContent$view_date1")).isEnabled());//here it will true
		//if it is enabled it should return "true"
		//inthis case it works for few websites and not working for few
		//we will use use if condition to check the when the attribute "style" changes to 0.5.and 1 and it will enabled and disabled
		//if thelements stage is changing we have to validate with the help of assertion true or false with if condition 
		if(driver.findElement(By.id("Div1")).getAttribute("style").contains("1"))//here test will pass
		//if(driver.findElement(By.id("Div1")).getAttribute("style").contains("0.5"))//here test will fail
		{
			System.out.println("It's Enabled");
			Assert.assertTrue(true);
		}
		else 
		{
			Assert.assertTrue(false);//assertTrue always wants true to its argument
			//this selenium script only come into this else block only the condition is not met
			
		}
		
		//count the number of checkboxes code
		System.out.println(driver.findElements(By.cssSelector("input[type='checkbox']")).size());//basically we are finding here elements with same locators
		//when there are more elements with same attribute that time we used "findelements"

//asserting equals:: is used when you want to compare your actual value(coming from system) to expected value(what you want)

		driver.findElement(By.id("divpaxinfo")).click();
		Thread.sleep(2000);
		//whenever id is avilable use id only, which is more stable Xpath and Css
		//we need to write while loop to click on plus sign many times
		//this is basic syntax for while loop
		//remeber while looping (initialize, compare, condition and increment)
		System.out.println(driver.findElement(By.id("divpaxinfo")).getText());
	
		/*int i=1;
		while(i<5)
		{
			driver.findElement(By.id("hrefIncAdt")).click();
			i++;
		}*/
		//we can do the above step in for loop as well
		//difference betn while and for loop is (in for loop we are writing everything together and while loop we are writing in pieces)
		for(int i=1; i<5; i++)
		{
			driver.findElement(By.id("hrefIncAdt")).click();
		}

		driver.findElement(By.id("btnclosepaxoption")).click();
		Assert.assertEquals(driver.findElement(By.id("divpaxinfo")).getText(),"5 Adult");
		System.out.println(driver.findElement(By.id("divpaxinfo")).getText());
		
		driver.close();
		//Assertions:: assertions are one thing which one help us to validate our results which are being return by selenium with your expected result
	//whenever you put validation use assertion and match them
		//assert equals, asserFalse, assertTrue are main assertions
		//to write CSS for class you have to put dot . and then locator and remove any spaces if there are and for id #and then locator
	}

}
