package keyboardActions;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class TabsAndWindows {

	public static void main(String[] args) {
		
		
//TABS and WINDOWS - using keyboard action
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://demo.nopcommerce.com/");
		driver.manage().window().maximize();
		
	//Open Register link in New Tab
		WebElement register = driver.findElement(By.xpath("//a[@href=\"/register?returnUrl=%2F\"]"));
		register.click();
		
		driver.navigate().back();
		
	//Actions class	
		Actions act = new Actions(driver);
		act.keyDown(Keys.CONTROL).click(register).keyUp(Keys.CONTROL).perform(); //CTRL + CLICK + RELEASE CTRL
		
		
	//Switching to Register page
		//Get window IDs
		//Set not allow the Index concept and get method
			Set<String> IDs = driver.getWindowHandles(); 
		
		//Because of that we are converting Set collection to List Array
			List<String> IDss = new ArrayList(IDs);
		
		//Switch to another page (Registration page) and do the actions
		driver.switchTo().window(IDss.get(1));
		
		
	//Switching back to home page	
		driver.switchTo().window(IDss.get(0));
		
		//Perform something on the home page
	
		
//WINDOWS NEW
		//This will open in one page at a time
		driver.get("https://www.opencart.com/index.php?route=account/login");
		driver.get("https://demo.nopcommerce.com/");
		
		//Use newwindow method
			driver.get("https://demo.nopcommerce.com/");
			
			driver.switchTo().newWindow(WindowType.TAB); //this will open new browser TAB
		
			driver.get("https://www.opencart.com/index.php?route=account/login");
		
			driver.switchTo().newWindow(WindowType.WINDOW); //this will open new browser Window 

	}

}
