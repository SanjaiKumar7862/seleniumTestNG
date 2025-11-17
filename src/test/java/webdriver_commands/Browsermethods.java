package webdriver_commands;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Browsermethods {

	public static void main(String[] args) throws InterruptedException {
		
//3.Browser Methods
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		Thread.sleep(5000);
		
		driver.findElement(By.linkText("OrangeHRM, Inc")).click(); //this will open new broswer window
		Thread.sleep(5000);
		
		
		driver.close(); //close the 1st browser window or current window or single window wherever the driver is focused
		driver.quit(); //close all the browser windows
		
		
		
	}

}
