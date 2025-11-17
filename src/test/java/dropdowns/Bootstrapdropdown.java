package dropdowns;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Bootstrapdropdown {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://www.jquery-az.com/boots/demo.php?ex=63.0_2"); //dropdown 
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//button[contains(@class,'multiselect')]")).click(); //open dropdown options
		
	//1.Select single option from dropdown
		driver.findElement(By.xpath("//input[@value='java']")).click();
		
	//2.capture all options and find size
		List<WebElement> options = driver.findElements(By.xpath("//ul[contains(@class,'multiselect')]//label")); //double slash skips the tag from ul to label
		options.size();
		
	//3.printing options from dropdown
		for(WebElement print : options)
		{
			System.out.println("Print all options: " + print.getText());
		}
		
	//4.select multiple options
		for(WebElement op : options)
		{
			String option = op.getText();
			
			if(option.equals("Java") || options.equals("MySQL") || options.equals("Python"))
			{
				op.click();
			}
			
		}
		
	//Bootstrap dropdown does not have any build in method. so it is fully based on XPATH
		
	//Unlike a standard <select> tag (which can be handled using Selenium’s Select class), a Bootstrap dropdown is built using HTML elements such as:<ul>, <li>, <a>, <div>
		

	}

}
