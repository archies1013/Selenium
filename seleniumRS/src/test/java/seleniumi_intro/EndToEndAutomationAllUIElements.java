package seleniumi_intro;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class EndToEndAutomationAllUIElements {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "/Users/archanasawant/Documents/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.com/");//
		driver.navigate().to("https://rahulshettyacademy.com/dropdownsPractise/");	
		driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXTaction")).click();

		driver.findElement(By.xpath("//a[@value='DEL']")).click();
		Thread.sleep(2000);
		//driver.findElement(By.xpath("(//a[@value='MAA'])[2]"));
		driver.findElement(By.xpath("//div[@id = 'glsctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='MAA']")).click();
		//this xpath selected based on parent child locator
		//Thread.sleep(1000);
		//driver.findElement(By.id("ctl00_mainContent_view_date1")).click();//click on date bos
		driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_0")).click();
		//driver.findElement(By.cssSelector(".a[@class = 'ui-state-default.ui-state-highlight.ui-state-active']")).click();
		//here in css replace "any space with dot (.)"
		if(driver.findElement(By.id("Div1")).getAttribute("style").contains("0.5"))//here test will pass
			//if(driver.findElement(By.id("Div1")).getAttribute("style").contains("0.5"))//here test will fail
		{
			System.out.println("It's Disabled");
			Assert.assertTrue(true);
		}
		else 
		{
			Assert.assertTrue(false);//assertTrue always wants true to its argument
			//this selenium script only come into this else block only the condition is not met

		}
		//driver.findElement(By.id("ctl00_mainContent_view_date2")).click();
		//driver.findElement(By.xpath("//a[@class='ui-state-default']"));//to date we get too many xpath
		//System.out.println(driver.findElements(By.cssSelector("input[type='checkbox']")).size());
		driver.findElement(By.cssSelector("input[id ='ctl00_mainContent_chk_SeniorCitizenDiscount']")).click();

		//driver.findElement(By.id("divpaxinfo")).getText();
		driver.findElement(By.id("divpaxinfo")).click();
		Thread.sleep(2000);

		for(int i=1; i<5; i++)
		{
			driver.findElement(By.id("hrefIncAdt")).click();
		}
		driver.findElement(By.id("btnclosepaxoption")).click();

		//driver.findElement(By.id("btnclosepaxoption")).click();
		Assert.assertEquals(driver.findElement(By.id("divpaxinfo")).getText(),"5 Adult");
		System.out.println(driver.findElement(By.id("divpaxinfo")).getText());

		//driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));

		WebElement StaticDropDown=driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
		//dropdown we have to write down like this 
		Select dropdown= new Select(StaticDropDown);//first create an object for an select tag
		dropdown.selectByValue("INR");
		dropdown.getFirstSelectedOption().getText();

		driver.findElement(By.id("ctl00_mainContent_chk_friendsandfamily"));

		//driver.findElement(By.id("ctl00_mainContent_btn_FindFlights"));
		//driver.findElement(By.cssSelector("#ctl00_mainContent_btn_FindFlights")).click();
		driver.findElement(By.cssSelector("input[type='submit']")).click();
		//driver.findElement(By.xpath("//input[@type='submit']")).click();
		driver.close();




	}

}
