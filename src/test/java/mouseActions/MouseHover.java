package mouseActions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MouseHover {

	public static void main(String[] args) {
		
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		
	//MOUSE HOVER
		
		//capture webelement
		WebElement click = driver.findElement(By.xpath("//button[@class=\"dropbtn\"]"));	
		WebElement click1 = driver.findElement(By.xpath("//a[contains(text(),\"Laptops\")]"));
		
		//create actions class and involve the driver
		Actions action = new Actions(driver);
		
		//action.moveToElement(click).moveToElement(click1).build().perform();
		
		action.moveToElement(click).moveToElement(click1).perform();
		
		
		

	}

}
