package session40_DataDriverTesting;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;

public class S41_ExcelUtilityFileDemo {

	public static void main(String[] args) throws IOException, InterruptedException {
		
//FD Calculator
		
		WebDriver driver = new EdgeDriver();		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://www.moneycontrol.com/fixed-income/calculator/state-bank-of-india/fixed-deposit-calculator-SBI-BSB001.html");
		driver.manage().window().maximize();	
		
		String filepath = System.getProperty("user.dir")+"\\TestData\\SimpleInterestTestData.xlsx";
		
	//Get Row count from utility class by calling method	
		int rows = S41_ExcelUtilityFile.getRowCount(filepath, "SimpleInterestData");
		
		for(int i=1; i<=rows; i++)   //starts from Row 1
		{
			
			//1 - Read the data from excel
			String princ = S41_ExcelUtilityFile.getCellData(filepath, "SimpleInterestData", i, 0);
			String rateofinterest = S41_ExcelUtilityFile.getCellData(filepath, "SimpleInterestData", i, 1);
			String period1 = S41_ExcelUtilityFile.getCellData(filepath, "SimpleInterestData", i, 2);
			String period2 = S41_ExcelUtilityFile.getCellData(filepath, "SimpleInterestData", i, 3);
			String frequency = S41_ExcelUtilityFile.getCellData(filepath, "SimpleInterestData", i, 4);
			
			String exp_matvalue = S41_ExcelUtilityFile.getCellData(filepath, "SimpleInterestData", i, 5);
			
			
			//2 - Pass the data into application
			driver.findElement(By.xpath("//input[@id=\"principal\"]")).sendKeys(princ);
			driver.findElement(By.id("interest")).sendKeys(rateofinterest);
			driver.findElement(By.xpath("//input[@id=\"tenure\"]")).sendKeys(period1);
			
			Select dropdown_day = new Select(driver.findElement(By.xpath("//select[@id='tenurePeriod']")));
			dropdown_day.selectByVisibleText(period2);
			
			Select dropdown_fre = new Select (driver.findElement(By.xpath("//select[@id=\"frequency\"]")));
			dropdown_fre.selectByVisibleText(frequency);
			
			driver.findElement(By.xpath("//a[@onclick=\"return getfdMatVal(this);\"]")).click();
			
							
			String act_matvalue = driver.findElement(By.xpath("//span[@id=\"resp_matval\"]//strong")).getText();
			
			
			//3 - Validation of Exp result and Act result
			if(Double.parseDouble(exp_matvalue)==Double.parseDouble(act_matvalue))
			{
				System.out.println("test passed..");
				S41_ExcelUtilityFile.setCellData(filepath, "SimpleInterestData", i, 7, "Passed..");
				S41_ExcelUtilityFile.fillGreenColor(filepath, "SimpleInterestData", i, 7);
			}
			else
			{
				System.out.println("test failed..");
				S41_ExcelUtilityFile.setCellData(filepath, "SimpleInterestData", i, 7, "Failed..");
				S41_ExcelUtilityFile.fillRedColor(filepath, "SimpleInterestData", i, 7);
			}
			
			Thread.sleep(2000);
			driver.findElement(By.xpath("//a[@onclick=\"javascript:reset_fdcalcfrm();\"]")).click();  //Clear button
			
		}  //for loop end
		
		
		Thread.sleep(2000);
		driver.quit();
		

	}

}
