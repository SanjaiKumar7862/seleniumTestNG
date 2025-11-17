package dropdowns;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AutosuggestWebtable {

	public static void main(String[] args) throws InterruptedException {
		
		
	//Auto suggest dropdown Eg 1 - in searchbox, type something and you can see many suggesstion dropdown (dynamic dropdown)
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https:google.com/");
		driver.manage().window().maximize();
		
		driver.findElement(By.name("q")).sendKeys("selenium"); //search box
		Thread.sleep(5000);
		
		List<WebElement> options = driver.findElements(By.xpath("//ul[@role=\"listbox\"]//li//div[@role=\"option\"]"));	
		System.out.println("Size: " + options.size());
		
		
	//Enhanced loop
		/*
		for(WebElement e:options)
		{
			System.out.println(e.getText());
			
			if(e.getText().equals("selenium testing"))
			{
				e.click();
			}
		}
		*/
		
		
	//Trad for loop
		for(int i=0; i<options.size(); i++)
		{
			System.out.println(options.get(i).getText());
			
			if(options.get(i).getText().equals("selenium testing"))
			{
				options.get(i).click();
				break;
			}
			
		}
		
	
		
		
	}

}
