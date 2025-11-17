package javaScripExecutor;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class JavaScriptExe1 {

	public static void main(String[] args) throws InterruptedException {
		
//SCROLLING BAR WebPages
		//Its is not a webElement and can't be inspect or etc.
		//Possible only using JavaScript executor
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.worldometers.info/geography/flags-of-the-world/");
		driver.manage().window().maximize();
		
	//JS Executor variable creation
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		//1.Scroll down page by pixel
				js.executeScript("window.scrollBy(0,3000)", "");
				System.out.println(js.executeScript("return window.pageYOffset;"));  //get the value of Y Axis (use X for horizontal scroll bar
		
				Thread.sleep(2000);
				
				
		//2.Scroll page till element is visible
				WebElement germany=driver.findElement(By.xpath("//img[@alt=\"Germany\"]"));
				
				js.executeScript("arguments[0].scrollIntoView();", germany);
				System.out.println(js.executeScript("return window.pageYOffset;"));
				germany.click();
				
				Thread.sleep(2000);
				
				
		//3.Scroll to bottom of the page
				js.executeScript("window.scrollBy(0,document.body.scrollheight)");
				System.out.println(js.executeScript("return window.pageYOffset;"));
			
				Thread.sleep(2000);
				
				
		//4.Scroll to top of the page
				js.executeScript("window.scrollBy(0,-document.body.scrollheight)");
				System.out.println(js.executeScript("return window.pageYOffset;"));
				
				
				
	}

}
