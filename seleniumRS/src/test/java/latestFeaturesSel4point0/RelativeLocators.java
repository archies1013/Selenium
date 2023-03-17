package latestFeaturesSel4point0;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import static org.openqa.selenium.support.locators.RelativeLocator.*;

public class RelativeLocators {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ChromeOptions options = new ChromeOptions();
		options.addArguments("start-maximized");
		options.addArguments("--remote-allow-origins=*"); 
		WebDriver driver = new ChromeDriver(options);
		driver.get("https://www.google.com/");
		
		driver.navigate().to("https://rahulshettyacademy.com/angularpractice/");
		//Here we want to get title of "NameBox" element with the help of "Relative Locator"
		WebElement nameEditBox=driver.findElement(By.cssSelector("input[name='name']"));
		System.out.println(driver.findElement(with(By.tagName("label")).above(nameEditBox)).getText());
		/**Here you have to import one Static package of "Relative locator" manually bec sel will not autosuggest the import of "Static" package
		 * 
		 */
		//WebElement dateOfBirth=driver.findElement(By.className("form-control"));
		WebElement dateOfBirth=driver.findElement(By.cssSelector("[for='dateofBirth']"));
		driver.findElement(with(By.tagName("input")).below(dateOfBirth)).click();//we cannot use this bec below there is a flex element, we have to go down more
		
		//Now we want to click checkbox which is on left side of next to "Ckeck me out if you love ice creams"
		WebElement iceCreamlabel=driver.findElement(By.xpath("//label[text()='Check me out if you Love IceCreams!']"));//we will store in one webelement
		driver.findElement(with(By.tagName("input")).toLeftOf(iceCreamlabel)).click();
		
		//now we will get the label which is right of the "radio button"
		WebElement radioBtn=driver.findElement(By.id("exampleCheck1"));
		System.out.println(driver.findElement(with(By.tagName("label")).toRightOf(radioBtn)).getText());//this is how we build "RelativeLocator"
		
		/**Relative Locators :make sure you import the package manually of Relative Locator, and you can find only based upon "tagName"
		 * and "original locator" store into one variable and you can use it on the "right side" of the argument
		 * 1. above() -- element located "above" with respect to the specified element
		 * 2. below() -- element located "below" with respect to the specified element
		 * 3. toLeftOf()--element located "toLeftOf" with respect to the specified element
		 * 4. toRightOf()--element located "toRightOf" with respect to the specified element
		 * 
		 * Syntax: driver.findElement(with tagName("value")).above(saved relative WebElement))
		 */
	}

}
