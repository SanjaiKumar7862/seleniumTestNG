package mouseActions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DragAndDrop {

	public static void main(String[] args) {
		

//DRAG and DROP
		
		//URL - http://www.dhtmlgoodies.com/scripts/drag-drop-custom/demo-drag-drop-3.html
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		
	//Locate the element
		WebElement source = driver.findElement(By.xpath("//div[@id=\"draggable\"]"));
		WebElement target = driver.findElement(By.xpath("//div[@id=\"droppable\"]"));
		
	//Actions class	
		Actions draganddrop = new Actions(driver);
		draganddrop.dragAndDrop(source, target).perform();
		
		//like wise use source and target element to drag and drop
		
		
		
	
	}

}
