package session46_ListenersANDExtentReportGen;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


//@Listeners(session46_ListenersANDExtentReportGen.Listeners1.class)
public class ListenersDemo {
	
	
WebDriver driver;
	
	@BeforeClass
	void setup() throws InterruptedException
	{
		
		driver = new ChromeDriver();		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
		Thread.sleep(3000);
	}
	
	@Test(priority=1)
	void testlogo()
	{
		boolean status = driver.findElement(By.xpath("//img[@alt='company-branding']")).isDisplayed();
		Assert.assertEquals(status, true);
	}
	
	@Test(priority=2)
	void testURL()
	{
		Assert.assertEquals(driver.getCurrentUrl(), "https://opensource-demo.orangehrmlive.com/web/index.php/");
	}
		
	@Test(priority=3, dependsOnMethods= {"testURL"})
	void testTitle()
	{
		Assert.assertEquals(driver.getTitle(), "OrangeHRM");
	}
	
	@AfterClass
	void teardown()
	{
		driver.quit();
	}

}


/*
 * --> 1) Create tests (1 Pass, 1 Fail, 1 Skip)
 * --> 2) To perform some post action we have to create Listeners Class
 * --> 3) Create XML File and implement the class methods 
 */

