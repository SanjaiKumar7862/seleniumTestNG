package webdriver_commands;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Conditionalmethods {

	public static void main(String[] args) {
	
		
//2.CONDITIONAL METHODS --> access these commands through WebElements  //Returns boolean values (true or false)
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://demo.nopcommerce.com/");
		driver.manage().window().maximize();
		
		//isDisplayed() -> Elements is displayed or not Eg: image, logo, etc //cannot pass any value of this status
		boolean status = driver.findElement(By.xpath("//img[@alt='nopCommerce demo store']")).isDisplayed(); //return boolean
		System.out.println("Logo Status: " + status);
				//another
		WebElement logo = driver.findElement(By.xpath("//img[@alt='nopCommerce demo store']")); //use WebElement class
		System.out.println("Logo Status: " + logo.isDisplayed());
		
		
		//isEnabled() -> this method is used for input boxes and dropdown and radio buttons //can pass values or anything of this status
		//Check Elements is Enabled/Disabled status
		boolean status1 = driver.findElement(By.xpath("//*[@id=\"FirstName\"]")).isEnabled();
		System.out.println("Label Status: " + status1);
		
		
		//isSelected() -> to check the element is selected or not
		WebElement male = driver.findElement(By.xpath("//*[@id=\"gender-male\"]"));
		WebElement female = driver.findElement(By.xpath("//*[@id=\"gender-female\"]"));
		
		System.out.println("Before selection");
		System.out.println(male.isSelected()); //returns false
		System.out.println(female.isSelected()); //returns false
		
		System.out.println("After selection of male");
		male.click(); //select male radio button
		System.out.println(male.isSelected()); //returns true
		System.out.println(female.isSelected()); //returns false
		
		System.out.println("After selection of female");
		female.click(); //select female radio button
		System.out.println(male.isSelected()); //returns false
		System.out.println(female.isSelected()); //returns true
		
		boolean status2 = driver.findElement(By.xpath("//input[@id='Newsletter']")).isSelected(); //returns true
		System.out.println("Newsletter status: " + status2);
		
		
		
	}

}
