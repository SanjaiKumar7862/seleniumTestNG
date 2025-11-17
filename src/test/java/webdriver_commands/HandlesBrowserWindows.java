package webdriver_commands;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandlesBrowserWindows {

	public static void main(String[] args) {
		
//GET WindowHandle and GET WindowHandles
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//a[normalize-space()=\"OrangeHRM, Inc\"]")).click();
		
		
		Set<String> windowIDs = driver.getWindowHandles(); //store in Set collection
		
	//Approach 1 - only have a 2 or 3 browser windows
		List<String> windowList = new ArrayList(windowIDs); //convert Set to List. bcoz Set collection dont have Get method
		String parent = windowList.get(0);
		String child = windowList.get(1);
		
		
		
		System.out.println("Returns Parent window: " + driver.getCurrentUrl());
		
		driver.switchTo().window(child); //Switch to child window
		System.out.println("Returns child window: " + driver.getCurrentUrl());
		
		driver.switchTo().window(parent); //Switch to parent window
		System.out.println("Returns parent window: " + driver.getCurrentUrl());
		
		
	//Approach 2 - looping statement if we have more num of browser windows
		for(String winID : windowIDs)
		{
			String winIDs = driver.switchTo().window(winID).getTitle(); 
			System.out.println("All IDs: " + winIDs);
			
			if(winIDs.equals("OrangeHRM"))
			{
				System.out.println(driver.getCurrentUrl());
				//do some validations checks
			}
		
		}
		
	}

}
