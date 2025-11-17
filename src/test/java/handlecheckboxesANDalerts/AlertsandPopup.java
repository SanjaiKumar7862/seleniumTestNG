package handlecheckboxesANDalerts;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

public class AlertsandPopup {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.get("https://the-internet.herokuapp.com/javascript_alerts");
		driver.manage().window().maximize();
		
	//Normal alert with OK button - IMP: alert is not a webelement, we cant inspect alert windows
		/*
		driver.findElement(By.xpath("//button[normalize-space()=\"Click for JS Alert\"]")).click();
		
		driver.switchTo().alert().accept(); //it accepts the alert 
			//or
		Alert myalert = driver.switchTo().alert(); //handle alerts and store in variable and use for various oprations
		System.out.println(myalert.getText());
		myalert.accept();
		*/
		
		
	//Confirmation alert - having OK and CANCEL
		/*
		driver.findElement(By.xpath("//button[normalize-space()=\"Click for JS Confirm\"]")).click();
		Thread.sleep(3);
		driver.switchTo().alert().getText(); //get TEXT
		driver.switchTo().alert().accept(); //OK
		driver.switchTo().alert().dismiss(); //CANCEL
		*/
		
		
	//Prompt alert
		/*
		driver.findElement(By.xpath("//button[normalize-space()=\"Click for JS Prompt\"]")).click();
		Thread.sleep(3);
		driver.switchTo().alert().sendKeys("Admin");
		driver.switchTo().alert().accept();
		*/
		
		
	//Scenario - If I dont want to use Switching commands, how to get into alert and do operations	
	//in this case - use EXPLICIT WAIT	
		/*
		WebDriverWait mywait = new WebDriverWait(driver,Duration.ofSeconds(5)); //declaration
		Alert alerts = mywait.until(ExpectedConditions.alertIsPresent()); //check conditions
		alerts.getText();
		alerts.accept();
		*/
		
		
	//Authenticated popup - if popups asks to enter username or password
		
		driver.switchTo().newWindow(WindowType.TAB);
		//driver.get("https://the-internet.herokuapp.com/basic_auth"); //normal url
			//other syntax to pass
		driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");
		
		
		
		//driver.close();
		
	}

}
