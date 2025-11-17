package DatePickersANDCalenders;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DatePicker1 {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		
		//Input DOB
		String requiredYear = "2021";
		String requiredMonth = "June";
		String requiredday = "10";
		
		driver.switchTo().frame("");

	//Video Discontinued at Session 34 - 1:33:00
		
	}

}
