package session39_BrokenSVGShadow;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ShadowDOM {

	public static void main(String[] args) throws InterruptedException {

//SHADOW DOM --> DOM contain another DOM/Sub DOM is called (Document - Webpage >> Shadow host >> Shadow root >> Shadow tree/elements)
		//Any element which present inside Xpath, that cannot be find using Shadow DOM.
		//for that elements, only we have to use CSSSELECTOR
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://dev.automationtesting.in/shadow-dom");
		driver.manage().window().maximize();	
		
	//1 - Shadow Element
		
		//This Element is inside single shadow DOM.
		String cssSelectorForHost1 = "#shadow-root";
		Thread.sleep(1000);
		
		//Shadow host >> Shadow root >> Shadow element
		SearchContext shadow = driver.findElement(By.cssSelector("#shadow-root")).getShadowRoot(); //searchcontext is an interface
		Thread.sleep(1000);
		
		shadow.findElement(By.cssSelector("#shadow-element"));
		
		
	//2 - Nested shadow element
		
		//This Element is inside 2 nested shadow DOM.
		String cssSelectorForHost2 = "#shadow-root";
		String cssSelectorForHost3 = "#inner-shadow-dom";
		Thread.sleep(1000);
		
		
		SearchContext shadow0 = driver.findElement(By.cssSelector("#shadow-root")).getShadowRoot();
		Thread.sleep(1000);
		SearchContext shadow1 = shadow0.findElement(By.cssSelector("#inner-shadow-dom")).getShadowRoot();
		Thread.sleep(1000);
		shadow1.findElement(By.cssSelector("#nested-shadow-element"));
		
		
	//3 - Multi nested shadow element
		
		//This Element is inside 3 nested shadow DOM.
		String cssSelectorForHost11 = "#shadow-root";
		String cssSelectorForHost21 = "#inner-shadow-dom";
		String cssSelectorForHost31 = "#nested-shadow-dom";
		Thread.sleep(1000);
		
		
		SearchContext shadow01 = driver.findElement(By.cssSelector("#shadow-root")).getShadowRoot();
		Thread.sleep(1000);
		SearchContext shadow11 = shadow01.findElement(By.cssSelector("#inner-shadow-dom")).getShadowRoot();
		Thread.sleep(1000);
		SearchContext shadow2 = shadow11.findElement(By.cssSelector("#nested-shadow-dom")).getShadowRoot();
		Thread.sleep(1000);
		shadow2.findElement(By.cssSelector("#multi-nested-shadow-element")).getText();
		
		
		
	}

}
