package seleniumi_intro;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


public class Screenshots {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
/***How to delete screenshot
 * How to kill the process which is running in Background
 * below driver know how to open the browser but we have to change the behaviour of driver for deleting the screenshot
 * You can change that by casting a driver to takes screenshot by using method "getScreenshotAs"
 * this method will visible only when you will cast your driver into"TakesScreenshot" save the output in a file 
 * and we are saving that output in src file
 * We have to copy file in our local machine with the help of "FileUtils" package
 */
		//System.setProperty("webdriver.chrome.driver", "/Users/archanasawant/Documents/chromedriver");
				//WebDriverManager.chromedriver().setup();
				ChromeOptions options = new ChromeOptions();
				options.addArguments("start-maximized");
				options.addArguments("--remote-allow-origins=*"); 
				WebDriver driver = new ChromeDriver(options);
				driver.manage().window().maximize();;//to maximise the window after open
				driver.get("https:www.google.com");
				File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
				FileUtils.copyFile(src, new File("/Users/archanasawant/Downloads/googlecreenshot.png"));
				/**What is IOException in Java? The IOException is simply an exception that is thrown when an I/O error occurs. It is also 
				 * the base class of such exceptions which occur while reading or accessing files, directories and streams.
				 * The IOException belongs to the class of checked exceptions.
				 *  
				 * 
				 */
				
		
		
		
		
		
		
	}
	
	
	
	

}
