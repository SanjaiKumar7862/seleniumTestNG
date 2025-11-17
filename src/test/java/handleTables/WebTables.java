package handleTables;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebTables {

	public static void main(String[] args) {
		
	//WebTables - 1.Static WebTable, 2.Dynamic WebTable, 3.Table with Pagination
		
	//URL - https://testautomationpractice.blogspot.com/; 
		
	
//STATIC WEB TABLES
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		
	//1.Find total no of rows in table
		int rowsize = driver.findElements(By.xpath("//table[@name=\"BookTable\"]//tr")).size(); //7 (usage - multiple table)
		System.out.println("no of rows: " + rowsize);
		
		int allsize = driver.findElements(By.tagName("tr")).size(); //count all table rows (usage - single table)
		System.out.println("all no of rows: " + allsize);

		int colsize = driver.findElements(By.xpath("//table[@name=\"BookTable\"]//tr[1]//th")).size(); //count all cols header count
		System.out.println("no of cols: " + colsize);
		
		int allsize1 = driver.findElements(By.tagName("th")).size(); //all table header count
		System.out.println("all no of cols: " + allsize1);
		
	//2.Read data from specific row and column (Eg: 5th row and 1st column)
		String bookname = driver.findElement(By.xpath("//table[@name=\"BookTable\"]//tr[5]//td[1]")).getText(); //specific data by giving row num and col num
		System.out.println("Table data specific row col: " + bookname);
		
		
	//3.Read data from all the rows and columns (using loop)
		
		for(int r=2; r<=rowsize; r++) //index start from 2 because eliminating header part
		{
			for(int c=1; c<=colsize; c++)
			{
				String value = driver.findElement(By.xpath("//table[@name=\"BookTable\"]//tr["+r+"]//td["+c+"]")).getText(); //Pass parameters(var) to the XPATH syntax - surround with "+r+" "+c+"
				System.out.print("all values iterated using loop: " + value + "\t");
			}
			System.out.println();
		}
		
		
	//4.Retrieve the data based on the conditions. Print bookname whose Auther is Mukesh
		
		for(int r=2; r<=rowsize; r++)
		{
			String authername = driver.findElement(By.xpath("//table[@name=\"BookTable\"]//tr["+r+"]//td[2]")).getText(); //get 2nd column values
			System.out.println("Auther name: " + authername);
			
			if(authername.equals("Mukesh"))
			{
				String booksname = driver.findElement(By.xpath("//table[@name=\"BookTable\"]//tr["+r+"]//td[1]")).getText(); //get 1st column values
				System.out.println("Bookname and authername: " + booksname +"\t" + authername);
			}
		}
		
		
	//5.In price column, capture all prices and want to find total prices for all books
		
		int total = 0;
		for(int r=2; r<=rowsize; r++)
		{
			String price = driver.findElement(By.xpath("//table[@name=\"BookTable\"]//tr["+r+"]//td[4]")).getText(); //get 4th column details
			//price in string format. so convert that to Integer format
			total = total + Integer.parseInt(price);
			
		}
		System.out.println("Total price: " + total);
		
	
		
	}

}
