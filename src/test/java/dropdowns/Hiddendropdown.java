package dropdowns;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Hiddendropdown {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login"); 
		driver.manage().window().maximize();
		
	//login steps
		driver.findElement(By.name("username")).sendKeys("Admin");
		driver.findElement(By.name("password")).sendKeys("admin123");
		driver.findElement(By.xpath("//button[@class=\"oxd-button oxd-button--medium oxd-button--main orangehrm-login-button\"]")).click();
		
	//click on PIM
		driver.findElement(By.xpath("//span[normalize-space()=\"PIM\"]")).click();
		
	//click on dropdown
		driver.findElement(By.xpath("(//div[contains(text(),'-- Select --')])[2]")).click();	
		
	//Select single option
		// 1. Turn on debugger and directly take an xpath and select
		
	//count no of options
		List<WebElement> options = driver.findElements(By.xpath("//div[@role='listbox']//span"));
		System.out.println("No of options: " + options.size()); //29
	
	//Print the options
		for(WebElement op:options)
		{
			System.out.println(op.getText());
		}
	
		
		
		
	//Hidden dropdown example is form: while selecting options in form they have a dropdown and that options are hidden in html
	//to handle these, selectorhub provides feature to handle it (Turn on debugger - 4th option and within 5 secs we need to click on inspect element and then we can inspect the element from dropdown)	

	//Other options for freeze is - go to devtools and select EVent listener. Expand Blur options and remove it. after that inspect the element
		
	}

}
