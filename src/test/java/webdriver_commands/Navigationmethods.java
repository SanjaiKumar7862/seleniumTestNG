package webdriver_commands;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Navigationmethods {

	public static void main(String[] args) throws MalformedURLException {
		
//5.Navigational commands
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.opencart.com/index.php?route=cms/demo"); //using get command - we can pass only String format parameter
		
		driver.navigate().to("https://demo.nopcommerce.com/"); //using navigation command - we can pass in the form of String format and also in the form of URL object
		
		URL myurl = new URL("https://demo.nopcommerce.com/");
		driver.navigate().to(myurl); //accept as URL object format
				//Navigate method internally call Get method. Navigate method checks whether its a string or not. if string it will pass directly to get and if its an object, it will convert object to string and then pass it
		
		
		driver.navigate().to("https://demo.nopcommerce.com/");
		driver.navigate().to("https://www.opencart.com/index.php?route=cms/demo");
		
		driver.navigate().back(); //move backward
		System.out.println(driver.getCurrentUrl());
		
		driver.navigate().forward(); //move forward
		System.out.println(driver.getCurrentUrl());
		
		driver.navigate().refresh(); //page refresh
		
		
		
	}

}
