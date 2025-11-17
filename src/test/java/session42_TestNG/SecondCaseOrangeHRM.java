package session42_TestNG;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

/*
 * Automate below Test cases by implemeting WebDriver code
 * 
 *  TC1 - Open OrangeHRM application (https://opensource-demo.orangehrmlive.com/web/index.php/auth/login)
 *  TC2 - Test logo presence check
 *  TC3 - Login
 *  TC4 - Logout
 */


public class SecondCaseOrangeHRM 
{
  
	WebDriver driver;   //Instance variable or Class variable/Object - to access this in all methods
	
	@Test(priority=1)
	void openapp()
	{
		//WebDriver driver = new ChromeDriver();
		driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
	}
	
	
	@Test(priority=2)
	void testlogo() throws InterruptedException
	{
		Thread.sleep(3000);
		
		boolean status = driver.findElement(By.xpath("//img[@alt='company-branding']")).isDisplayed();
		System.out.println("The logo is displayed: " + status);
		
		//Can also use If condition to verify the logo
	}
	
	
	@Test(priority=3)
	void login()
	{
		driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("Admin");
		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("admin123");
		driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
	}
	
	@Test(priority=4)
	void logout() throws InterruptedException
	{
		Thread.sleep(3000);
		
		driver.close();
	}
	
	
}


/*
 * --> Specify the driver instance inside method. The problem here is we can access driver only within that method and not outside of other methods
 * --> To overcome this, we need to make this as a Class level and now it become the Class level. Now it can be accessible allover the class
 * --> After that add validation to test cases
 * 
 * --> Note: To execute multiple test cases, it can be run through TestNG XML File. Also it generate test reports after execution
 * --> 
 * 
 */







