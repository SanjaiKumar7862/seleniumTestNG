package session39_BrokenSVGShadow;

import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/*
 1. Link - href="https://xyz.com"
 2. "https://xyz.com" --> server --> status code
 3. Status code >= broken link
 	Status code < not broken link 
 */

public class BrokenLinks {

	public static void main(String[] args) {
		
//The link doesnt have any correspoding resource in server
//can find - We send the request to the server and server will send the resource with (error code with status)
			//If the status code >= that is broken link. If the status code <400 that is not a broken link
//The server not having any resource or not respond message
		
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("http://www.deadlinkcity.com/");
		driver.manage().window().maximize();
		
		//get all the links from website with tagname
		List<WebElement> links = driver.findElements(By.tagName("a"));
		System.out.println("No of size of the link: " + links.size());
		
		int NoOfBrokenLinks = 0;
		
		//Read all the url values
		for(WebElement linkElement:links) 
		{
			String HrefAttrValue=linkElement.getAttribute("href");  
			
			if(HrefAttrValue==null || HrefAttrValue.isEmpty())  //SKIP and CONTINUE if the href values is null/Empty
			{
				System.out.println("href attribute value is null and empty. So not possible to check");
				continue;
			}
			
		//hit url to the server. surround with try catch block
			try
			{
			
				URL linkURL = new URL(HrefAttrValue); //Convert from String to URL format
			
				HttpURLConnection conn = (HttpURLConnection) linkURL.openConnection(); //open connection to the server
			
				conn.connect(); //Connect to the server and sent request to the server
			
				if(conn.getResponseCode()>=400)
				{
					System.out.println(HrefAttrValue + "->It is Broken link");
					NoOfBrokenLinks++;
				}
				else
				{
					System.out.println(HrefAttrValue + "->It is not Broken link");
				}
			
			}
			catch(Exception e)
			{
				
			}
			
		}
		System.out.println("Count the links: " + NoOfBrokenLinks);
				
		
	}

}
