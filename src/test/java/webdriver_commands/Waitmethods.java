package webdriver_commands;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Waitmethods {

	public static void main(String[] args) {
		
//4.Wait Methods
		
		/* 
		IMPLICIT WAIT
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); //Implicit waits
				
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("Admin");
		
		driver.close(); 
		
		*/
		
		
		/*
		//EXPLCIT WAIT
		
		WebDriver driver = new ChromeDriver();
		WebDriverWait mywait = new WebDriverWait(driver,Duration.ofSeconds(10)); //declaration of explicit wait
				
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
		
		WebElement txtusername = mywait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Username']")));
		//returns WebElement once condition is true i.e, element is located
		txtusername.sendKeys("Admin");
				
		mywait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Password']"))).sendKeys("Admin");
			//or
		WebElement txtpassword = mywait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Password']")));
		txtpassword.sendKeys("admin123");
		
		WebElement lgnclick = mywait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[normalize-space()='Login']")));
		lgnclick.click();
		
		*/
		
		
		
		//FLUENT WAIT
		
		WebDriver driver = new ChromeDriver();
		Wait<WebDriver> mywait = new FluentWait<WebDriver>(driver) //Fixed Syntax - declaration
				.withTimeout(Duration.ofSeconds(30))  //normal time the maximum time
				.pollingEvery(Duration.ofSeconds(5))  //every 5 secs it will check the specified time. if true then proceed further
				.ignoring(NoSuchElementException.class);  //based on polling time
		
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
		
		 WebElement txtusername = mywait.until(new Function<WebDriver, WebElement>() { //usage
		     public WebElement apply(WebDriver driver) {
		       return driver.findElement(By.xpath("//input[@placeholder=\"Username\"]"));
		     }
		   });
		
		
		
		//Thread.sleep(3000) --> easy to use. pause the execution (its just a method provided by Java itself) and not a webdriver method
				//But if the element is within the mentioned seconds it will get success or exception raised
				//if the element is executed within 1 sec out of 3 secs, then it will wait till for other 2 secs, time wasted here
				//if it waited for each and every time, then it will delay the execution
		
		 
		//waits --> webdriver method provides only 2 waits
		//Implicit wait -- advantage of it is we can specify only one time after creating browser instance. this will solve synchronization issues
				//This is alive till you close your driver
				//Synchronization will take care of all steps
				//it will not wait as like thread.sleep. once webelement is available within 2 seconds, it will execute next steps
				//Problem - if harcoded time is exceeds, then exception may throws.
		
		//Explicit wait -- 	declaration - use - (until method)
				//This will work on the specific condition
				//Identification of WebElement is inclusive in this wait
				//Basically waiting for an element is visible, clickble, etc.. 
				//Problem - if exceeds specific time, may get exception
		
		//Fluent wait -- declaration - use
		 		//used for more unpredictable elements
		 		//it will work more effective than explicit wait
		 		//Problem - if exceeds specific time, may get exception
				
		 
		 
		

	}

}
