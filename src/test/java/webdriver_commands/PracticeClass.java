package webdriver_commands;

import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class PracticeClass {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		
	//1.Provide some string search for it
		WebElement search = driver.findElement(By.id("Wikipedia1_wikipedia-search-input"));
		search.sendKeys("selenium");
		driver.findElement(By.xpath("//input[@type=\"submit\"]")).click();
	
		
	//2.count number of links
		List<WebElement> links = driver.findElements(By.xpath("//div[@class=\"wikipedia-search-results\"]"));
		System.out.println("Links size: " + links.size());
		
		
				
		driver.findElement(By.xpath("//a[normalize-space()=\"Selenium\"]")).click();
		driver.findElement(By.xpath("//a[normalize-space()=\"Selenium in biology\"]")).click();
		driver.findElement(By.xpath("//a[normalize-space()=\"Selenium (software)\"]")).click();
		driver.findElement(By.xpath("//a[normalize-space()=\"Selenium disulfide\"]")).click();
		driver.findElement(By.xpath("//a[normalize-space()=\"Selenium dioxide\"]")).click();
		driver.findElement(By.xpath("//a[normalize-space()='More »']")).click();
	
		
	//3.click on each link using for loop
//		driver.findElement(By.xpath("//div[@class=\"wikipedia-search-results\"]//a"));
		
		
	//4.get windowsID for every browser window
		
		Set<String> windowID = driver.getWindowHandles();
		System.out.println("window IDs: " + windowID);
		
	//5.close specific browser window
		
		
		
	}

}
