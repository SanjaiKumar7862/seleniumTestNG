package launchBrowLocators;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

class Trycatch //try catch block
{
	public void trycatch() 
	{
	
		try {
		Thread.sleep(2000); //2 seconds wait
	} catch (InterruptedException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
		
	}
}

public class locators {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Trycatch obj = new Trycatch();
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://demoblaze.com/");
		driver.manage().window().maximize();
		
		//find total number of links and print them
		List<WebElement> links = driver.findElements(By.tagName("a"));
		System.out.println("Total no of links: "+ links.size());
		
		for(WebElement e:links)
		{
		    System.out.println("Printing values:" + e.getText());
		}
		
		
		//find total number of images
		List<WebElement> images = driver.findElements(By.tagName("img"));
		System.out.println("Total no of images: " + images.size());
		
		obj.trycatch(); //call from class obj 
				
		
		//Click on anyproduct using linktext/partialinktext
		WebElement text = driver.findElement(By.partialLinkText("Nokia lumia 1520"));
		text.click();
		
		obj.trycatch();
		
		WebElement text1 = driver.findElement(By.partialLinkText("STORE"));
		text1.click();
		
		obj.trycatch();
		
		WebElement leftarrow = driver.findElement(By.className("carousel-control-prev-icon"));
		leftarrow.click();
		
		obj.trycatch();
		
		
		//CSS Selector (using webpage: https://demo.nopcommerce.com/)
		//by tag + id (tag#id --> syntax)
		driver.findElement(By.cssSelector("input#small-searchterms")).sendKeys("mobile");
		driver.findElement(By.cssSelector("#small-searchterms")).sendKeys("mobile");
		
		//by tag + class (tag.classname --> syntax)
		driver.findElement(By.cssSelector("input.search-box-text")).sendKeys("mobile");
		driver.findElement(By.cssSelector(".search-box-text")).sendKeys("mobile");
				
		//by tag + attribute (tag[attribute=value] --> syntax)
		driver.findElement(By.cssSelector("input[placeholder='Search store']")).sendKeys("Values");
		driver.findElement(By.cssSelector("[placeholder=\"Search store\"]")).sendKeys("Values");
		
		//by tag class attribute (tag.classname[attribute=value] --> syntax)
		driver.findElement(By.cssSelector("input.search-box-text[name=\"q\"]")).sendKeys("Values");
		driver.findElement(By.cssSelector(".search-box-text[name='q']")).sendKeys("Values");
		
		
		//XPATH
		//xpath with single attribute
		driver.findElement(By.xpath("//input[@placeholder=\"Search store\"]")).sendKeys("Values");
		
		//xpath with multiple attribute
		driver.findElement(By.xpath("//input[@placeholder=\"Search store\"][@name=\"q\"]")).sendKeys("Values");
		
		//xpath with and or operators --> and (if both attribute should be correct) or (if any one attribute match)
		driver.findElement(By.xpath("//input[@placeholder=\"Search store\" and @name=\"q\"]"));
		driver.findElement(By.xpath("//input[@placeholder=\"Search store\" or @name=\"qaa\"]"));
		
		//xpath with inner text with link text and normal label text
		driver.findElement(By.xpath("//a[text()='Register']")).click();
		driver.findElement(By.xpath("//a[text()='Log in']")).click();
		boolean isdisplayed = driver.findElement(By.xpath("//h2[text()='Welcome to our store']")).isDisplayed();
		System.out.println(isdisplayed);
		String text2 = driver.findElement(By.xpath("//h2[text()='Welcome to our store']")).getText();
		System.out.println(text2);
		
		//xpath with contains method and starts with method --> whenever there is a dynamic web element i.e, keeps changing
		driver.findElement(By.xpath("//input[contains(@placeholder,\"Enter your email here...\")]")); //partial = //input[contains(@placeholder,"Enter your")]
		driver.findElement(By.xpath("//input[starts-with(@placeholder,\"Enter your\")]"));
		
		//write dynamic xpath
		driver.findElement(By.xpath("//input[contains(@id,'st')]")); // start and stop --> //*[@id='start' or @id='stop']	
		driver.findElement(By.xpath("//input[starts-with(@id,'st')]"));

		//chained xpath
		boolean status = driver.findElement(By.xpath("//div[@id='logo']/a/img")).isDisplayed();
		System.out.println(status);
		
		
		//XPATH AXES
		//webpage to locate all kind of xpath and xpath axes ("https://money.rediff.com/gainers/bse/daily/groupa")
		
		
		
		
		
	}

}