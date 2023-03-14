package seleniumi_intro;

import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;


public class SoftAsser_BrokenLinks_doesnotexistlink_JavaStream2 {

	public static void main(String[] args)throws MalformedURLException, IOException {
		// TODO Auto-generated method stub
/**A broken link, also often called a dead link, is one that does not work i.e. does not redirect to the webpage 
 * it is meant to. This usually occurs because the website or particular web page is down or does not exist. When someone clicks on 
 * a broken link, an error message is displayed.
 * 
 */
		//System.setProperty("webdriver.chrome.driver", "/Users/archanasawant/Documents/chromedriver");
				//WebDriverManager.chromedriver().setup();
				ChromeOptions options = new ChromeOptions();
				options.addArguments("start-maximized");
				options.addArguments("--remote-allow-origins=*"); 
				WebDriver driver = new ChromeDriver(options);
				driver.get("https:www.google.com");
				/**1. get all urls which is tied up to the link using selenium, you get attribute of "href" that will give all url
				 * 2. Java methods which call's the url and get you the status code, Selenium will not help you find broken links we need to relie 
				 * on some Java methods 
				 * 3. if status code are greater than > 400then that url is now working(which means link which is tied up that url is broken)
				 * 
				 */
				
				driver.get("https://rahulshettyacademy.com/AutomationPractice/");
				
				List<WebElement>Links=driver.findElements(By.cssSelector("li[class='gf-li'] a"));//css=tagname[class='']space childtagnem
				SoftAssert sfa=new SoftAssert();
				/**this soft assertion will not stop the execution completly, it will continue after finds brokenlink and continue to find other 
				 * broken if there is any available
				 */
				
				
				/**we are using enhanced for loop
				 * 
				 */
				for(WebElement link:Links)
				{
					String url=link.getAttribute("href");
					HttpURLConnection conn = (HttpURLConnection) new URL(url).openConnection();
					conn.setRequestMethod("HEAD");
					conn.connect();
					int respCode=conn.getResponseCode();
					System.out.println(respCode);
					sfa.assertTrue(respCode<400, "The link with Text " + link.getText()+" is broken with code "+ respCode);
					
				}
					
				sfa.assertAll();
				/**this will stop all assertion and we get a output after all execution done 
				 * we optimized our code in such a way that it will check all the links instead of stopping in the middle from specific place we chose and finally 
				 * it will fail if there is any broken link 
				 */
				}
				
		
	}
	
	
	
	


