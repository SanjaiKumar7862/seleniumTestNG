package optionsClass;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class OptionsBrowserSettings {

	public static void main(String[] args) {
		
//Options class - used to control settings of the browser
	//Chrome Options, Edge Options, FireFox Options, etc
			
	
	//1.HeadLess testing - Run my test case which will execute in the backend without seeing any UI actions and will get only final output
		//Advantage - 1.We can do multiple task/times.  2.Faster execution
		//Disadvantage - 1.User cannot understand the flow of execution bcoz it is invisible.
		//Preferance - Not At the beginning of the developing test case. 
		
			ChromeOptions options = new ChromeOptions(); //create chromeoptions class and create an object using the class, for headless testing
			options.addArguments("--headless=new");	//setting for headless mode of execution
			
		WebDriver driver = new ChromeDriver(options); //Pass the object (options)
		
		driver.get("https://www.flipkart.com/");
		driver.manage().window().maximize();
		
		String title = driver.getTitle();
		System.out.println(driver.getTitle());
		
		if(title.equals("Online Shopping Site for Mobiles, Electronics, Furniture, Grocery, Lifestyle, Books & More. Best Offers!"))    
		{
			System.out.println("Title matched");
		}
		else
		{
			System.out.println("Title not matched");
		}
		
		driver.close();
		
		
	//2.SSL Handling (Secure Socket Layer) - 	SSL certificate type
		
			ChromeOptions options1 = new ChromeOptions();
			options1.setAcceptInsecureCerts(true); //accept SSL certificate in the webpage
		
		WebDriver driver1 = new ChromeDriver(options1);
		driver1.get("https://expired.badssl.com/");
		driver1.manage().window().maximize();
		
		System.out.println(driver1.getTitle());
		
	
	//3."Chrome is being controlled by automated test software" - Disable automated msg on screen 
		
			ChromeOptions options3 = new ChromeOptions();
			options3.setExperimentalOption("excludeSwitches", new String[] {"enable-automation"}); //disable automated msg
		
		WebDriver driver2 = new ChromeDriver(options3);
		driver2.get("https://expired.badssl.com/");
		driver2.manage().window().maximize();
			
		System.out.println(driver1.getTitle());	
			
	
	//4.Run test in incognito mode/privately
			
			ChromeOptions options4 = new ChromeOptions();
			options4.addArguments("--incognito");
		
		WebDriver driver3 = new ChromeDriver(options4);
		driver3.get("https://expired.badssl.com/");
		driver3.manage().window().maximize();
				
		System.out.println(driver1.getTitle());	
	
	//5.Enable extensions at Run time
		
			ChromeOptions options5 = new ChromeOptions();
			File file = new File("C:\\Users\\ssenapathy\\Downloads\\SelectorsHub-Chrome-Web-Store.crx"); //selector hub crx file location
			options5.addExtensions(file);
			
		WebDriver driver4 = new ChromeDriver(options5);
		driver4.get("https://www.flipkart.com/");	
		driver4.manage().window().maximize();
		
	//5.1. Ad blockers
		
			File file1 = new File("C:\\Users\\ssenapathy\\Downloads\\Ad-Blocker-Stands-AdBlocker-Chrome-Web-Store.crx");
			options5.addExtensions(file1);
			
		WebDriver driver5 = new ChromeDriver(options5);
		driver5.get("https://www.flipkart.com/");	
		driver5.manage().window().maximize();
		
		
		
			
	}

}
