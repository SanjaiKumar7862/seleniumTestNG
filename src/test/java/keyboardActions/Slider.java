package keyboardActions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Slider {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		
//SLIDER -> minimum slider
		
		WebElement min_slider = driver.findElement(By.xpath("(//span[@class='ui-slider-handle ui-corner-all ui-state-default'])[1]"));
		//default location before moving
		System.out.println("Location of Min Slider: "+min_slider.getLocation()); //capture x and y axis (1167, 2019)
		
		Thread.sleep(2000);
		
//		min_slider.getLocation().getX(); //Return X axis only
//		min_slider.getLocation().getY(); //Return Y axis only
		
		//Actions class
		Actions act = new Actions(driver);
		act.dragAndDropBy(min_slider, 50, 0).perform(); // 1167 + 50 to right x axis
		
		//location after moving
		System.out.println("Location of Min Slider: "+min_slider.getLocation()); //capture new location after moving
		
		Thread.sleep(2000);
		
		
//SLIDER -> maximum slider
		
		WebElement max_slider = driver.findElement(By.xpath("(//span[@class='ui-slider-handle ui-corner-all ui-state-default'])[2]"));
		System.out.println("Location of Max slider: " + max_slider.getLocation()); //capture x and y axis (1296, 2019)
		Thread.sleep(2000);
		
		act.dragAndDropBy(max_slider, -100, 0).perform(); // 1296 - 100 to left x axis
		
		System.out.println("Location of Max slider: " + max_slider.getLocation());

	}

}
