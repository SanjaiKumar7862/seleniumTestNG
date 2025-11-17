package iFrames;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FramesHandling {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://ui.vision/demo/webtest/frames/");
		driver.manage().window().maximize();
		
//Generally frame is called a multiple webpage embedded into a single webpage	
		
	//Frame 1
		WebElement frame1 = driver.findElement(By.xpath("//frame[@src=\"frame_1.html\"]"));
		driver.switchTo().frame(frame1); //Switch to frame and pass frame as a webelement
				
		driver.findElement(By.xpath("//input[@name=\"mytext1\"]")).sendKeys("Welcome"); //find WebElement and pass values
		
	//Frame 2
		driver.switchTo().defaultContent(); //this method is used to switch back to main page and then we need to do switch again to next frame
		
		WebElement frame2 = driver.findElement(By.xpath("//frame[@src=\"frame_2.html\"]"));
		driver.switchTo().frame(frame2); //Switch to 2nd frame and pass frame as a WebElement
		
		driver.findElement(By.xpath("//input[@name=\"mytext2\"]")).sendKeys("Welcome");
		
	//If ID and Name is available, then we can pass directly inside frame
//		driver.switchTo().frame("id"); 
//		driver.switchTo().frame("Name"); 
//		driver.switchTo().frame("WebElement");
//		driver.switchTo().frame("Index"); 
		
	//Frame 3
		driver.switchTo().defaultContent();
		
		WebElement frame3 = driver.findElement(By.xpath("//frame[@src=\"frame_3.html\"]"));
		driver.switchTo().frame(frame3);
		
		driver.findElement(By.xpath("//input[@name=\"mytext3\"]")).sendKeys("Admin");
				
	//Inner frame (part of Frame 3) - trying to interact with inner frame inside frame 3
		driver.switchTo().frame(0); //switch to inner frame using index 
		
		driver.findElement(By.xpath("//span[text()=\"Hi, I am the UI.Vision IDE\"]")).click();
		WebElement javas = driver.findElement(By.xpath("//span[text()=\"Web Testing\"]"));
		
		//Use JS executor also to click if get any exception (intercept exception or element not clickable, etc)
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click()", javas);
		
		driver.switchTo().defaultContent();
		

	}

}
