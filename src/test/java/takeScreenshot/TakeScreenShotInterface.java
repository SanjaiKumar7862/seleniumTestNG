package takeScreenshot;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TakeScreenShotInterface {

	public static void main(String[] args) {

//How to capture screenshot
	//1 - Full page screenshot 
	//2 - Specific area of the page
	//3 - Specific Web Element
		
	
		WebDriver driver = new ChromeDriver();		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://demo.nopcommerce.com/");
		driver.manage().window().maximize();	
		
	//1 - Full page screenshot
		TakesScreenshot ts = (TakesScreenshot) driver; //cast webdriver to take screenshot
		
		File sourcefile = ts.getScreenshotAs(OutputType.FILE); //capture screenshot into a temporary memory file. not yet saved where you want it.
							//(getScreenshotAs() calling from Takescreenshot interface)	
		
		File targetfile = new File(System.getProperty("user.dir") + "\\ScreenshotFolder\\fullpage.png"); //Define the target file path
								//(Get the current working project directory + and relative path to store screenshot)
		
		sourcefile.renameTo(targetfile); 
								//renameTo(targetfile) is used here to move the screenshot file from temp to target path.
		
		
	//2 - Specific area of the page
		WebElement featureproduct=driver.findElement(By.xpath("//div[@class=\"product-grid home-page-product-grid\"]"));
		File sourcefile1=featureproduct.getScreenshotAs(OutputType.FILE);
										//(getScreenshotAs() calling from WebElement interface)	
		
		File targetfile1=new File(System.getProperty("user.dir") + "\\ScreenshotFolder\\specificarea.png");
		
		sourcefile1.renameTo(targetfile1);
		
		
	//3 - Specific web element
		WebElement webelement = driver.findElement(By.xpath("//img[@alt=\"nopCommerce demo store\"]"));
		File sourcefile2=featureproduct.getScreenshotAs(OutputType.FILE);
										//(getScreenshotAs() calling from WebElement interface)	

		File targetfile2=new File(System.getProperty("user.dir") + "\\ScreenshotFolder\\specificWebElement.png");

		sourcefile2.renameTo(targetfile2);
		
		
	//4 - Screenshot with Timestamp
		 //TakeScreenshot ts = (takesscreenshot) driver;
	        File source = ts.getScreenshotAs(OutputType.FILE);
	        
	        String timestamp = "Screenshot_" + System.currentTimeMillis() + ".png";
	        File target = new File("./Screenshotfolder/" + timestamp);
	        
	        try {
				FileUtils.copyFile(source, target);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		

	}

}
