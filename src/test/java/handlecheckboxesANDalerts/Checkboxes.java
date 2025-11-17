package handlecheckboxesANDalerts;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Checkboxes {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		
		
		
	//1.locate check boxes
		//	driver.findElement(By.id("sunday")).click();
		
	//2.select all the check boxes 1 by 1 which is complex. use looping statement
		//	driver.findElement(By.id("sunday")).click();
		//	driver.findElement(By.id("monday")).click();
		
		//--> for loop by locating all the elements in common and store in a variable using LIST collection (indexing)
		List<WebElement> checkboxs = driver.findElements(By.xpath("//input[@class=\"form-check-input\" and @type=\"checkbox\"]"));
		
		/*
		for(int i=0; i<checkboxs.size(); i++)
		{
			checkboxs.get(i).click();
		}
		*/
		
		/*
		for(WebElement checks:checkboxs)
		{
			checks.click();
		}
		*/
		
	//3.Select last 3 checkbox or else (formula - 7-3=4) which use index method
		
		/*
		for(int i=4; i<checkboxs.size(); i++)
		{
			checkboxs.get(i).click();
		}
		*/
		
	//Select 1st 3 checkbox (also use i<3/i<=2)
		
		/*
		for(int i=0; i<checkboxs.size()-4; i++)
		{
			checkboxs.get(i).click();
		}
		*/
		
	//4.Unselect checkboxes if it already selected, we need to verify and uncheck those checkboxes
		
		for(int i=0; i<checkboxs.size()-4; i++) //check first 3 checboxes
		{
			checkboxs.get(i).click();
		}
		
		Thread.sleep(3000);
		
		for(int i=0; i<checkboxs.size(); i++)//uncheck check boxes by verify condition
		{
			if(checkboxs.get(i).isSelected())
			{
				checkboxs.get(i).click();
			}
		}
	
	//
		
		
		
	}

}
