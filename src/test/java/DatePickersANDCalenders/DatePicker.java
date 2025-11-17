package DatePickersANDCalenders;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DatePicker {

//NORMAL DATE PICKER	
	
	//Select date
	static void selectFuturedate(WebDriver driver, String month, String year, String day)
	{
		//loop to check the condition
				while(true)
				{
					String currentmonth = driver.findElement(By.xpath("//span[@class=\"ui-datepicker-month\"]")).getText(); //actual month
					String currentyear = driver.findElement(By.xpath("//span[@class=\"ui-datepicker-year\"]")).getText(); //actual year
					
					if(currentmonth.equals(month) && currentyear.equals(year))
					{
						break;
					}
					
					driver.findElement(By.xpath("//span[@class=\"ui-icon ui-icon-circle-triangle-e\"]")).click(); //next
				}
				
						
				//get the table xpath and iterate through all dates and select the specified date
				List<WebElement> alldates = driver.findElements(By.xpath("//table[@class=\"ui-datepicker-calendar\"]//tbody/tr//td//a"));
				
				for(WebElement db : alldates)
				{
					if(db.getText().equals(day))
					{
						db.click();
						break;
					}
				}			
	}
	
	
	static void selectPastdate(WebDriver driver, String month, String year, String day)
	{
		//loop to check the condition
		while(true)
		{
			String currentmonth = driver.findElement(By.xpath("//span[@class=\"ui-datepicker-month\"]")).getText(); //actual month
			String currentyear = driver.findElement(By.xpath("//span[@class=\"ui-datepicker-year\"]")).getText(); //actual year
			
			if(currentmonth.equals(month) && currentyear.equals(year))
			{
				break;
			}
			
			driver.findElement(By.xpath("//span[@class=\"ui-icon ui-icon-circle-triangle-w\"]")).click(); //previous
		}
		
				
		//get the table xpath and iterate through all dates and select the specified date
		List<WebElement> alldates = driver.findElements(By.xpath("//table[@class=\"ui-datepicker-calendar\"]//tbody/tr//td//a"));
		
		for(WebElement db : alldates)
		{
			if(db.getText().equals(day))
			{
				db.click();
				break;
			}
		}
	}
	
	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://jqueryui.com/datepicker/");
		driver.manage().window().maximize();
		
	//switch to frame
		driver.switchTo().frame(0);
	
		
	//Method 1: use send keys
		//driver.findElement(By.xpath("//input[@id=\"datepicker\"]")).sendKeys("11/01/1998"); //mm/dd/yyyy
		
		
	//Method 2: using date picker
		
		//declare date here
		String month = "January";
		String year = "2025";
		String day = "15";
		
		//click on text box to get date picker
		driver.findElement(By.xpath("//input[@id=\"datepicker\"]")).click();
		
		
	//call the user defined method here to select date
		selectFuturedate(driver, month, year, day);
		selectPastdate(driver, month, year, day);
		
		
	}

}
