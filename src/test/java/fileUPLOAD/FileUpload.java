package fileUPLOAD;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FileUpload {

	public static void main(String[] args) throws InterruptedException {
		
//FILE UPLOAD using sendkeys method
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://davidwalsh.name/demo/multiple-file-upload.php");
		driver.manage().window().maximize();
	
	//Single file
		driver.findElement(By.xpath("//input[@id=\"filesToUpload\"]")).sendKeys("C:\\Users\\ssenapathy\\OneDrive - Expleo France\\Desktop\\SanjaiKumar.S_ES6051\\Downloads\\4507686611 - Return.pdf");
		
		WebElement file = driver.findElement(By.xpath("//ul[@id=\"fileList\"]//li"));	
		if(file.getText().equals("4507686611 - Return.pdf"))
		{
			System.out.println("File uploaded successfully");
		}
		else
		{
			System.out.println("File not uploaded");
		}
		
	//Multiple file
		String file1 = "C:\\Users\\ssenapathy\\OneDrive - Expleo France\\Desktop\\SanjaiKumar.S_ES6051\\Downloads\\4507686611 - Return.pdf";
		String file2 = "C:\\Users\\ssenapathy\\OneDrive - Expleo France\\Desktop\\SanjaiKumar.S_ES6051\\Downloads\\4715461024 - Start.pdf";
		
		WebElement fileupload = driver.findElement(By.xpath("//input[@id=\"filesToUpload\"]"));
		fileupload.sendKeys(file1+"\n"+file2);
		
		int filesize = driver.findElements(By.xpath("//ul[@id=\"fileList\"]//li")).size();
		
		
		//Validation of file count
		if(filesize==2)
		{
			System.out.println("File count is correct");
		}
		else
		{
			System.out.println("File count is not correct");
		}
		
		Thread.sleep(2000);
		
		//Validation of file name
		if(driver.findElement(By.xpath("//ul[@id=\"fileList\"]//li[1]")).getText().equals("4507686611 - Return.pdf") 
				&& driver.findElement(By.xpath("//ul[@id=\"fileList\"]//li[2]")).getText().equals("4715461024 - Start.pdf"))
		{
			System.out.println("FIle name is correct");
		}
		else
		{
			System.out.println("FIle name is not correct");
		}
		
		
	}

}
