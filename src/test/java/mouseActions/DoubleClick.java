package mouseActions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DoubleClick {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		
//DOUBLE CLICK
		
	//Code 1			

	/*
		WebElement box1 = driver.findElement(By.xpath("//input[@id=\"field1\"]"));
		box1.clear();
		box1.sendKeys("Welcome");
		
		String text1 = box1.getText();
		System.out.println("Field1: " + text1);
		
	//Action class
		WebElement click = driver.findElement(By.xpath("//button[@ondblclick=\"myFunction1()\"]"));
		Actions action = new Actions(driver);
		action.doubleClick(click).perform();
		
		Thread.sleep(2000);
		
		WebElement box2 = driver.findElement(By.xpath("//input[@id=\"field2\"]"));
		
		String text2 = box2.getText();
		System.out.println("Field2: " + text2);
		
		
	//Validation of 2 field	value
		if(text2.equals("Welcome"))
		{
			System.out.println("Test Copied");
		}	
		else
		{		
			System.out.println("Test Not Copied");	
		}
	*/
		
	
	//IMPORTANT note::: The above gettext() method will not work, because there is no value
		//Gettext() - method will only capture innertext of the element
		//to get that use GetAttribute() method
		
		
	//Code 1 - Exact code
		WebElement box1 = driver.findElement(By.xpath("//input[@id=\"field1\"]"));
		box1.clear();
		box1.sendKeys("Welcome");
		
		String text1 = box1.getAttribute("value");
		System.out.println("Field1: " + text1);
		
	//Action class
		WebElement click = driver.findElement(By.xpath("//button[@ondblclick=\"myFunction1()\"]"));
		Actions action = new Actions(driver);
		action.doubleClick(click).perform();
		
		Thread.sleep(2000);
		
		WebElement box2 = driver.findElement(By.xpath("//input[@id=\"field2\"]"));
		
		String text2 = box2.getAttribute("value");
		System.out.println("Field2: " + text2);
		
		
	//Validation of 2 field	value
		if(text2.equals(text1))
		{
			System.out.println("Test Copied");
		}	
		else
		{		
			System.out.println("Test Not Copied");	
		}
		
	}

}
