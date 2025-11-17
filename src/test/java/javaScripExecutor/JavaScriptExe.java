package javaScripExecutor;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class JavaScriptExe {

	public static void main(String[] args) {
		
//JS Executor - for Click and SendKeys methods
//Whenever getting ElementInterceptedException use JS as a work around		
		
		WebDriver driver = new ChromeDriver();
		//ChromeDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		
		
		WebElement inputbox = driver.findElement(By.xpath("//input[@id=\"name\"]"));
				
		//JS Executor variable creation JS. WebDriver variable assigned to a JS executor
		JavascriptExecutor js = (JavascriptExecutor) driver; 
		//JavascriptExecutor js = driver;
		
		js.executeScript("arguments[0].setAttribute('value','Welcome')", inputbox);
		
		
		WebElement click = driver.findElement(By.xpath("//input[@id='male']"));
		js.executeScript("arguments[0].click()", click);
		
		
		
		
	}

}
