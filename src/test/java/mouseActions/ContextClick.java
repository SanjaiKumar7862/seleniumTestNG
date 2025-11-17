package mouseActions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ContextClick {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://swisnl.github.io/jQuery-contextMenu/demo.html");
		driver.manage().window().maximize();

	//CONTEXT CLICK (RIGHT CLICK)
		
		//locate the element
		WebElement click = driver.findElement(By.xpath("//span[@class=\"context-menu-one btn btn-neutral\"]"));
		
		//create Action class and object and pass driver object
		Actions action = new Actions(driver);
		
		action.contextClick(click).perform();
		
		//click on any options
		driver.findElement(By.xpath("//li//span[contains(text(),'Copy')]")).click();
		Thread.sleep(3000);
		
		//handle alert window
		driver.switchTo().alert().accept();
		
		
		
	}

}
