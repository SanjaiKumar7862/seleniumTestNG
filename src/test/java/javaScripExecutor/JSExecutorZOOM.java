package javaScripExecutor;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class JSExecutorZOOM {

	public static void main(String[] args) throws InterruptedException {

		
//Zoom IN and Zoom OUT
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.worldometers.info/geography/flags-of-the-world/");
		Thread.sleep(2000);
		
		driver.manage().window().maximize();
		Thread.sleep(2000);
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("document.body.style.zoom='50%'"); //set zoom level 50%
		Thread.sleep(2000);
		
		js.executeScript("document.body.style.zoom='100%'"); //set zoom level 100%
		Thread.sleep(2000);
		
		
		
	}

}
