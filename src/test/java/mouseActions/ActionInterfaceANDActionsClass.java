package mouseActions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class ActionInterfaceANDActionsClass {

	public static void main(String[] args) {
		
		
//Action Interface and Actions Class
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://swisnl.github.io/jQuery-contextMenu/demo.html");
		driver.manage().window().maximize();

		//locate the element to Right CLick
		WebElement click = driver.findElement(By.xpath("//span[@class=\"context-menu-one btn btn-neutral\"]"));
		
		//create Action class and object and pass driver object
		Actions action = new Actions(driver);
		
		//This is building the action and performing action
		action.contextClick(click).build().perform();
		
		//This is directly performing the action
		action.contextClick(click).perform();
		
		
	//Implementing Action Interface
		
		Action myaction = action.contextClick(click).build(); //building or creating the action and store in a Action type of variable 
		myaction.perform(); //perform the action or completing the action
		
		
		
	//Actions VS Action
		/*
		 
		 Actions --> CLASS - will be used to perform mouse operation actions
		 Action --> INTERFACE - will be used to store the created action
		 
		 */
		
		
		
	
	}

}
