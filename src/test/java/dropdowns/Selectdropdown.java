package dropdowns;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Selectdropdown {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		
	//Select type of dropdown - we have to use SELECT Class
		WebElement drpcountryEle = driver.findElement(By.xpath("//select[@id=\"country\"]"));
		Select drpcountry = new Select(drpcountryEle); //pass the captured element in select object
		
		//use select methods to do operations on the select class object
		drpcountry.selectByVisibleText("United Kingdom");
		drpcountry.selectByValue("uk");
		drpcountry.selectByIndex(3);
		
		//Scenario - want to count total no.of options and want to compare numbers with my expected number
		//capture options from dropdown
		List<WebElement> droptions = drpcountry.getOptions(); //getoptions() - returns all the options from dropdown
		System.out.println("No of options: " + droptions.size());
		
		for(int i=0; i<droptions.size(); i++) //traditional loop
		{
			System.out.println(droptions.get(i).getText()); //using index - get the webelement and find the text
		}
		
		/*
		for( WebElement finaloption : droptions) //enhanced loop
		{
			System.out.println(finaloption.getText()); //direct use
		}
		*/
		
		
		
		
	}

}
