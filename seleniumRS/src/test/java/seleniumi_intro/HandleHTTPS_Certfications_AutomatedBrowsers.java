package seleniumi_intro;

import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class HandleHTTPS_Certfications_AutomatedBrowsers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/**
		 * QUE: is there any you can you can twik your existing automation behaviour by setting up proxy or by setting up ssl
		 * Yes there is way there is class called ChromeOptions which can modify the behaviour  and explain the all process
		 */
		
		ChromeOptions options=new ChromeOptions();
		options.addArguments("start-maximized");
		options.addArguments("--remote-allow-origins=*");
		
		//this is code for expiredssl to bring it on HTTPS and starts working 
		options.setAcceptInsecureCerts(true);
		
		//How to download any file from browser and save on your computer
		//we can use this for how to download csv and excel file and and how to parse and save on specific directory
		Map<String, Object> prefs = new HashMap<String, Object>();
		prefs.put("download.default_directory", "/directory/path");
		options.setExperimentalOption("prefs", prefs);
		
		
		//how to handle pop window
		options.setExperimentalOption("excludeSwitches",
		Arrays.asList("disable-popup-blocking"));
		
		/**Proxy proxy = new Proxy();//gining some for this proxy thats why I comment it if you send as "proxy" send then Java can understand it
		*proxy.setHTTPProxy("ipaddress:4444")
		*options.setCapability("proxy", proxy`);//you cannot just pass proxy in a String. In Java there is as special class
		*/
		
		System.setProperty("webdriver.chrome.driver", "/Users/archanasawant/Documents/chromedriver");
		WebDriver driver=new ChromeDriver(options);
		driver.get("https://expired.badssl.com/");
		System.out.println(driver.getTitle());
		
	/**we can do this on Firefox and Edge and safari as well by using options class and repeating the same steps and passing that in webdriver as an argument
	 * We can add extensions option as well so whatever you have in your original browser you can select addextentions method
	 * How to set project for run time--by using .setCapabilities(proxy, value) so that is opening 
	 * 
	 */
		
		
		
		
	}

}
