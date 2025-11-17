package handleTables;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebTables1 {

	public static void main(String[] args) throws InterruptedException {
		
//DYNAMIC WEB TABLES with PAGINATION
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://www.opencart.com/index.php?route=account/login");
		driver.manage().window().maximize();
		
		WebElement username = driver.findElement(By.xpath("//input[@id='input-username]"));
		username.clear();
		username.sendKeys("Admin");
		
		WebElement password = driver.findElement(By.xpath("//input[@id='input-password]"));
		password.clear();
		password.sendKeys("Password");
		
		driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
		
		//click close if window popup appears
		if(driver.findElement(By.xpath("//button[@class='btn-close']")).isDisplayed())
		{
		driver.findElement(By.xpath("//button[@class='btn-close']")).click(); 
		}
		
		driver.findElement(By.xpath("//a[@class='parent']")).click(); //click on customer menu
		driver.findElement(By.xpath("//click on submenu customers")).click(); //click on customer sub menu
		
		
		
	//1.Counting number of pages
	//2.Click on particular page
	//3.Read data on the particular page
		
	//1.showing 1 to 10 of 19081 (1909 Pages)
		String pages = driver.findElement(By.xpath("//div[contains(text(),'Pages')]")).getText();
		int total_pages = Integer.parseInt(pages.substring(pages.indexOf("(")+1, pages.indexOf("Pages")-1)); //convert string to Integer
		
		//int no_pages = Integer.parseInt(total_pages);
		
		//repeating pages
		for(int p=1; p<=5; p++)
		{
		    if(p > 1)
		    {
		        //2.
		    	WebElement active_page = driver.findElement(By.xpath("//ul[@class='pagination']//*[text()=" + p + "]"));
		        active_page.click();
		        Thread.sleep(3000);
		    }
		    
		    //3.reading data from the page
		    int noOfRows = driver.findElements(By.xpath("//table[@class='table table-bordered table-hover']//tbody/tr")).size();
		    	
		    for(int r=1; r<=noOfRows; r++)
		    {
		    	//Read customername and email address
		    	String cus_name=driver.findElement(By.xpath("//table[@class='table table-bordered table-hover']//tbody//tr["+r+"]/td[2]")).getText(); //tr (all) ** //td(column)
		    	String email = driver.findElement(By.xpath("//table[@class='table table-bordered table-hover']//tbody//tr["+r+"]/td[3]")).getText();
		    	String status = driver.findElement(By.xpath("//table[@class='table table-bordered table-hover']//tbody//tr["+r+"]/td[5]")).getText();
		    
		    	System.out.println(cus_name + "\t" + email + "\t" + status);
		    }
		    
		}

		
		
		
	}

}
