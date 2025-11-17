package session47_POM;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

//Login test case

public class LoginTest {
	
	WebDriver driver;
	
	@BeforeClass
	void setup()
	{
		//creating a driver setup here and passing the to the construtor in Login page and using this driver instance everywhere
		
		driver=new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
	}
	
	
	@Test
	void Login()
	{
		//Call methods from Page Object Class by creating object
		
		LoginPage lp = new LoginPage(driver);
		lp.setUsername("Admin");
		lp.setPassword("admin123");
		lp.clickLogin();
		
		Assert.assertEquals(driver.getTitle(), "OrangeHRM");
		
	}
	
	
	@AfterClass
	void tearDown()
	{
		driver.quit();
	}
	

}
