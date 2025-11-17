package keyboardActions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class KeyboardActions {

	public static void main(String[] args) {
		
		
//KEYBOARD Actions
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://text-compare.com/");
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//textarea[@id=\"inputText1\"]")).sendKeys("Welcome to Selenium");
		
		Actions act = new Actions(driver);
		
		
	//CTRL + A - Select the text
		act.keyDown(Keys.CONTROL).sendKeys("A").keyUp(Keys.CONTROL).perform();
		
	
	//CTRL + C - Copy
		act.keyDown(Keys.CONTROL).sendKeys("C").keyUp(Keys.CONTROL).perform();
		
		
	//TAB Key - move to next input box
		act.keyDown(Keys.TAB).keyUp(Keys.TAB).perform();
		
		
	//CTRL + V - Paste the copied text
		act.keyDown(Keys.CONTROL).sendKeys("V").keyUp(Keys.CONTROL).perform();
		
	
		 
	//CTRL + SHIFT + A	
		act.keyDown(Keys.CONTROL).keyDown(Keys.SHIFT).sendKeys("A").keyUp(Keys.SHIFT).keyUp(Keys.CONTROL).perform();

	
	//ENTER Key
		act.keyDown(Keys.ENTER).keyUp(Keys.ENTER).perform();
		
	}

}
