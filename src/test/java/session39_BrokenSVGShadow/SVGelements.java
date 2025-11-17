package session39_BrokenSVGShadow;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SVGelements {

	public static void main(String[] args) throws InterruptedException {
	
//SVG Elements - it is an image which has a small icons which contains the SVG tag in DOM while inspect
		//handle - Normal xpath wont work. by adding name method is the representation of svg element syntax while writing xpath. 
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();	
		
		driver.findElement(By.xpath("//input[@name=\"username\"]")).sendKeys("Admin");
		driver.findElement(By.xpath("//input[@name=\"password\"]")).sendKeys("admin123");
		driver.findElement(By.xpath("//button[@type=\"submit\"]")).click();
		
		Thread.sleep(2000);
		
		//Abs xpath - not work
		//driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/aside[1]/nav[1]/div[2]/ul[1]/li[4]/a[1]/*[name()='svg'][1]")).click();
		
		
		//Rel xpath - not work
		//driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/aside/nav/div[2]/ul/li[4]/a/svg")).click();
		
		
		//Identify Svg element xpath using name attribute
		driver.findElement(By.xpath("(//*[name()='svg'][@role='presentation'])[5]")).click();
		
		

	}

}
