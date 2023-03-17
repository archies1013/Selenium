package latestFeaturesSel4point0;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class InvokingMultipleWindowsTabs {

	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		ChromeOptions options = new ChromeOptions();
		options.addArguments("start-maximized");
		options.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(options);
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		//SWITCHING WINDOW
		// driver.switchTo().newWindow(WindowType.TAB);
		driver.switchTo().newWindow(WindowType.WINDOW);//this is to open new window tab
		Set<String> handles = driver.getWindowHandles();//this method to handle the windows 
		Iterator<String> it = handles.iterator();//this is to 
		String parentWindowId = it.next();
		String childWindowId = it.next();
		driver.switchTo().window(childWindowId);
		driver.get("https://rahulshettyacademy.com/");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0, 1000)");
		String courseName = driver.findElements(By.cssSelector("a[href*='https://courses.rahulshettyacademy.com/p']"))
				.get(1).getText();
		driver.switchTo().window(parentWindowId);
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		driver.findElement(By.cssSelector("[name='name']")).sendKeys(courseName);
		/**
		 * Now if you want to capture the webElement whre you enter the course name
		 * First save that WebElement into one variable and then use required methods on
		 * that
		 */
		WebElement csCourseName = driver.findElement(By.cssSelector("[name='name']"));
		csCourseName.sendKeys(courseName);
		//CAPTURE SCREENSHOT
		File srcfile=csCourseName.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(srcfile, new File("screenshot.png"));
		/**get only name element screenshot and get into file format, so create one variable for file class
		*so whatever screenshot taken and save into file variable
		*this is object of File Class, but to a physical file to saved in our system there is FileUtils jar you have to import apache common util 
		*this is how you capture the screenshot and saved it on your machine
		*/
		
		//CAPTURE HEIGHT AND WIDTH OF WEBELEMENT
		/**(.getRect) method gives all the subsequent child method
		 * UX include - all height,width, dimension
		 * you can use assertion and compare your value with your actual value which you will receive from your PO
		 */
		System.out.println(csCourseName.getRect().getDimension().getHeight());
		System.out.println(csCourseName.getRect().getDimension().getWidth());
		driver.quit();

	}

}
