package JavaStreams_LambdaExpressions;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

public class WebtableSorting_SelJavaStreams {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ChromeOptions options= new ChromeOptions();
		options.addArguments("start-maximized");
		options.addArguments("--remote-allow-origins=*"); 
		WebDriver driver = new ChromeDriver(options);
		driver.get("https://www.google.com/");
		driver.navigate().to("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		
		/**Design the Algorithm
		 * 1. Click on column heading
		 * 2. capture all values in list and do getText then we will know that what we captured
		 * 3. Capture text of all the webelements into a new list----original list
		 * 4. sort on the original list of step 3---> sorted list
		 * 5. compared original list vs sorted list
		 */
		//1. Click on column heading
		driver.findElement(By.xpath("//tr/th[1]")).click();
		
		//2. capture all values in list and do getText then we will know that what we captured
		List<WebElement>elementsList=driver.findElements(By.xpath("//tr/td[1]"));

		//3. Capture text of all the web elements into a new list----original list (for that we need to iterate)
		//this stream repeats this map methods five times to getText of the element
		List<String>originalList=elementsList.stream().map(s->s.getText()).collect(Collectors.toList());
		
		//4. sort on the original list of step 3---> sorted list
		List<String>sortedList=originalList.stream().sorted().collect(Collectors.toList());
		
		//5. compared original list vs sorted list
		Assert.assertTrue(originalList.equals(sortedList));//there is no error means test Succesfully passed because we havent log(syso) anything
		//you can see in debugging by putting negative case as well to fail the test
		
		/**Now we will see how to get the price of the items
		 * 
		 */
		//Scan the name column with getText upto thr Beans item bec we need to print Beans price and then print the Beans price in output
		//if you want apply some condition you have to use filter method
		List<WebElement>elementsList1=driver.findElements(By.xpath("//tr/td[1]"));//here we will create "custom method"
		//elementsList1.stream().filter(s->s.getText().contains("Beans")).map(s->getPriceVeggie)).collect(Collectors.toList());
		//this code is only to find name from 1st page of webtable
		List<String>price=elementsList1.stream().filter(s->s.getText().contains("Beans")).map(s-> getPriceVeggie(s)).collect(Collectors.toList());
		price.forEach(a->System.out.println(a));
		
		/**Now we see "Pagination" (if item is present on some other and we have to find the price and item of that page)
		 * Here we will use "do while" loop and if condition
		 */
		//Code for Pagination to click on next button until we meet our condition using "do while loop and java stream"
		List<String>priceRice;
		do {
			
		List<WebElement>elementsList2=driver.findElements(By.xpath("//tr/td[1]"));
		priceRice=elementsList2.stream().filter(s->s.getText().contains("Rice")).map(s-> getPriceVeggie(s)).collect(Collectors.toList());
		priceRice.forEach(a->System.out.println(a));
		if(priceRice.size()<1)
		{
			driver.findElement(By.cssSelector("a[aria-label='Next']")).click();
		}
		
		}while(priceRice.size()<1);

}
	private static String getPriceVeggie(WebElement s)
	{
		String pricevalue=s.findElement(By.xpath("following-sibling::td[1]")).getText();
		return pricevalue;
	}
	
	
}
