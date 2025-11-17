package launchBrowLocators;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class browser_launch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();
		driver.get("https://www.flipkart.com/");
		driver.manage().window().maximize();
		
		String title = driver.getTitle();
		System.out.println(driver.getTitle());
		
		if(title.equals("Online Shopping Site for Mobiles, Electronics, Furniture, Grocery, Lifestyle, Books & More. Best Offers!"))    
		{
			System.out.println("Title matched");
		}else
		{
			System.out.println("Title not matched");
		}
		
		driver.close();
		
	}

}
