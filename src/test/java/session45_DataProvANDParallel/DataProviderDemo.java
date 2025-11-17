package session45_DataProvANDParallel;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderDemo {
	
	WebDriver driver;
	
	@BeforeClass
	void setup()
	{
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
	}
	
	@Test(dataProvider="dp")
	void testlogin(String email, String pwd) throws InterruptedException
	{
		
		driver.get("https://tutorialsninja.com/demo/index.php?route=account/login");
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys(email);
		driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys(pwd);
		driver.findElement(By.xpath("//input[@value='Login']")).click();
		Thread.sleep(2000);
		boolean status = driver.findElement(By.xpath("//h2[normalize-space()='My Account']")).isDisplayed();
		
		
		
		if(status==true)
		{
			driver.findElement(By.xpath("//span[normalize-space()='My Account']")).click();
			driver.findElement(By.xpath("//li//a[text()='Logout']")).click();
			Assert.assertTrue(true);
		}
		else
		{
			Assert.fail();
		}
		
	}
	
	@AfterClass
	void teardown()
	{
		driver.manage().deleteAllCookies();
		driver.close();
	}
	

//DataProvider logic
	
	//@DataProvider(name="dp", indices= {1,3})  ---> Pass indices to enter only specific data
	
	@DataProvider(name="dp")  
	Object[][] logindata()
	{
		//Create 2D array and hardcode the inputs. Object allows to store any type of data and returns 2D array with 2D Object type of array
		
		Object array[][] = { 
				
								{"abc@gmail.com", "test123"},
							    {"xyz@gmail.com", "test012"},
							    {"john@gmail.com", "test@123"},
							    {"demoninja@gmail.com", "test@123"},
							    {"johncanedy@gmail.com", "test"}					
							};
		
		return array;
	}
	
}

/*
 * Execute this login method mutliple time with diff set of data. that is using DataProvider
 * --> Hardcode the data by creating 2D array with Object type
 * 
 */


