package seleniumi_intro;

import java.io.Closeable;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class InvokingBrowser {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//Invoking browser
		//Chrome-ChromeDriver-Methods, close get etc
		//Firefox-FirefoxDriver-methods close get etc
		//WebDriver Close Get
		//WebDriver methods + class methods
		//Chromedriver.exe from CgromeBrowser
		//Selenium can with the help of 
		//webdriver.chrome.driver---->value of path (chromedriver path from system)
		
		//ChromeDriver driver=new ChromeDriver();
		//SeleniumManager(still Beta Phase) new package launch recently - no need to give syso (key, value)
		//if you give syso(key,value) while running thescript selenium manager will turn off 
		//-and when you don't give selenium manager will automatically turn on
		
		//Chrome Launch
		//System.setProperty("webdriver.chrome.driver", "/Users/archanasawant/Documents/chromedriver");
		//WebDriver driver = new ChromeDriver();
	
		
		//Firefox launch
		//You will get some JavaScript Errors but ignore it its related Firefox browser
		//System.setProperty("webdriver.gecko.driver", "/Users/archanasawant/Documents/geckodriver");
		//WebDriver driver = new FirefoxDriver();
		
		//MicroSoftEdge launch
		System.setProperty("webdriver.edge.driver", "/Users/archanasawant/Documents/msedgedriver");
		WebDriver driver = new EdgeDriver();
		
		
		driver.get("https://rahulshettyacademy.com/");
		System.out.println(driver.getTitle());//validate the Title of the url
		System.out.println(driver.getCurrentUrl());//to validate current url
		
		
		
		
		driver.close();//it closes the current window
		//driver.quit();//closing the driver, closing every associated window
		
		
	}

}
