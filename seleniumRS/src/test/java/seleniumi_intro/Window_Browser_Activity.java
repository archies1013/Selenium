package seleniumi_intro;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.v108.page.model.NavigatedWithinDocument;

public class Window_Browser_Activity {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//here we will how to run test cases on maximize mode and also how to use navigation like forward-back using selenium
		//below two lines of code is used for every selenium test (invoke the chrome browser)
		System.setProperty("webdriver.chrome.driver", "/Users/archanasawant/Documents/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.com/");// here in "get" method page is fully loading 
		driver.navigate().to("https://rahulshettyacademy.com/");//here in "navigate" method it just help you to move another website
		driver.navigate().back();//basically it clicking the back arrow(icon)from the main page
		driver.navigate().forward();
		driver.close();
		//this all steps you need for all your automation process
		
	}

}
