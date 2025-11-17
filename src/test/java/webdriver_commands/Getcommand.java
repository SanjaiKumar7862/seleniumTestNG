package webdriver_commands;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Getcommand {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		
//1.GET METHODS --> used to work on the WebPage level. access these methods through webdriver instance
		//get() -> open url
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
		
		//getTitle() -> get current page title
		System.out.println("Title: " + driver.getTitle());
		
		//getCUrrentURL() -> get current url
		System.out.println("Current URL: " + driver.getCurrentUrl());
		
		//getPageSource() -> to validate source code text, elements etc. Returns page source code
		System.out.println("View Pagesource: " + driver.getPageSource());
		
		
		//getWindowHandle() -> returns ID of the single browser window. This will change ID dynamically at the Run time
		String windowID = driver.getWindowHandle();
		System.out.println("WindowID: " + windowID);
		
		Thread.sleep(5000);
		
		//getWindowHandles() -> returns ID's of multiple browser windows. 
		driver.findElement(By.linkText("OrangeHRM, Inc")).click(); //it opens new browser window
		Set<String> windowsID = driver.getWindowHandles(); //used set because of it doesn't allows duplicates
		System.out.println("WindowIDs: " + windowsID);
		
		Thread.sleep(10000);
		

		
		
		
		//driver.close();
		driver.quit();
		
	}

}
