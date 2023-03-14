package seleniumi_intro;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import com.github.dockerjava.api.model.Driver;

public class DeleteCookies_MaximiseWindow {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//System.setProperty("webdriver.chrome.driver", "/Users/archanasawant/Documents/chromedriver");
				//WebDriverManager.chromedriver().setup();
				ChromeOptions options = new ChromeOptions();
				options.addArguments("start-maximized");
				options.addArguments("--remote-allow-origins=*"); 
				WebDriver driver = new ChromeDriver(options);
				driver.manage().window().maximize();;//to maximise the window after open 
				driver.manage().deleteAllCookies();//this will delete all cookies from your browser
				driver.manage().deleteCookieNamed("abcd");//if yoy want delet specicfic cookiethen give the name in argument
				//driver.manage().addCookie("abcd");//also you can add the cookies from the browser
				/**Scenario: If you delete in sessionkey cookies and if you click any other link or others that will be redirecting to the 
				 * login page verify login url....in this case you can use above code to delete specific key and the click somewhre else
				 * 
				 * 
				 * session logout error -valid automation scenario - if you delete any necessary cookie
				 */
				
		
		
		
		
		
		
	}
	
	
	
	

}
