package session47_POM;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

//Page Object Class - with PageFactory

public class LoginPagePageFactory {

	//Includes 3 main parts
	
	// -->Before writing locators we need to write constructor, this will initiate the driver automatically
	// --> Write all the locators (all xpath, ids, etc)
	// --> Actions methods (perform the actions)
	
	
	WebDriver driver;  //This driver is a class variable
	
	
	//Constructor
	LoginPagePageFactory(WebDriver driver)
	{
		this.driver=driver;		//this keyword is used to local variable reference
		PageFactory.initElements(driver, this);    //initElement - When I use to findby element, we are not using driver. So This method will initiate all the methods using this driver 
	}
	
	
	//Locators - by using @FindBy annotations
	@FindBy(xpath="//input[@placeholder='username']") 
	WebElement txt_username_loc;
	
	@FindBy(xpath="//input[@placeholder='password']") 
	WebElement txt_password_loc;
	
	@FindBy(xpath="//button[normalize-space()='Login']") 
	WebElement btn_login_loc;
	
	
	@FindBy(tagName="a")
	List<WebElement> lists;
	
	
	//Action Methods
	public void setUsername(String user)
	{
		txt_username_loc.sendKeys(user);
	}
	
	public void setPassword(String pwd)
	{
		txt_password_loc.sendKeys(pwd);
	}
	
	public void clickLogin()
	{
		btn_login_loc.click();
	}
	

}
