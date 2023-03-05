package seleniumi_intro;

public class Synchronization {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//we need to tell our script wait until the page is loaded, this is call synchronization
	//How we can achieve synchronization in webdriver
		//what is difference between Implicit Wait and Explicit wait
		//When to use and what to use
		//we have to use both Implicit wait and Explicit wait combine to synchronize the application smoothly
		/*Implicit Wait---wait for 5 sec before you throw exception, it will keep listening to DOM(document object model)
		 * and whenever the results loaded it quickly comeout of wait time
		 * Implicit wait you can apply globaly and affect every scenario while running
		 * Explicit wait--- used in Specific scenario to some of the test if its taking more time to load like 15sec as per developer point of view
		 * Thread.sleep----is apart java not Selenium, you are holding your java test for 5sec. if you give 5sec that will pause for 
		 * 5sec not for 3sec nomatter if the results are loaded still it will pause for 5sec
		 * Fluent wait---
		 */
		 /*If your test having some performance isuue then use implicit wait not more than 5sec
		  * Explicit wait - can be acieve in two ways- webdriver explicit wait and fluent wait
		  * we use explicit wait to target specific elemet 
		  * 
		  * 
		  * 
		  */
		
		
	}

}
