package session47_POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

//Page Object Class - without PageFactory

public class LoginPage {

	//Includes 3 main parts
	
	// -->Before writing locators we need to write constructor, this will initiate the driver automatically
	// --> Write all the locators (all xpath, ids, etc)
	// --> Actions methods (perform the actions)
	
	
	WebDriver driver;  //This driver is a class variable
	
	
	//Involke Constructor
	LoginPage(WebDriver driver)
	{
		this.driver=driver;		//this keyword is used to local variable reference
	}
	
	
	//Locators (Page elements) - in the below format
	By txt_username_loc = By.xpath("//input[@placeholder='username']");
	By txt_password_loc = By.xpath("//input[@placeholder='Password']");
	By btn_login_loc = By.xpath("//button[normalize-space()='Login']");
	
	
	//Action Methods
	public void setUsername(String user)
	{
		driver.findElement(txt_username_loc).sendKeys(user);
	}
	
	public void setPassword(String pwd)
	{
		driver.findElement(txt_password_loc).sendKeys(pwd);
	}
	
	public void clickLogin()
	{
		driver.findElement(btn_login_loc).click();
	}

}
