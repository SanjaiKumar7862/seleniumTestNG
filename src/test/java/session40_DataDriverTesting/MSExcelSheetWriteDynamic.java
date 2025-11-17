package session40_DataDriverTesting;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class MSExcelSheetWriteDynamic {

	public static void main(String[] args) throws IOException {
		
//1 - Write data in Excel file (Pass Dynamic data at Run time)

		//Create a new excel file
		FileOutputStream file = new FileOutputStream(System.getProperty("user.dir")+"\\TestData\\write1.xlsx");
		
		//Created new workbook
		XSSFWorkbook workbook = new XSSFWorkbook();
				
		//Create a new Sheet
		XSSFSheet Sheet = workbook.createSheet("Data1");

		//Scanner class to get input from user
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter no of rows: ");
		int noOfrows = sc.nextInt();
		
		System.out.println("Enter no of cells: ");
		int noOfcells = sc.nextInt();
		
		
		for(int r=0; r<=noOfrows; r++)
		{
			XSSFRow rows = Sheet.createRow(r);
			
			for(int c=0; c<noOfcells; c++)
			{
				XSSFCell cells = rows.createCell(c);
				cells.setCellValue(sc.next());
			}
		}
		System.out.println("Cell values entered..");
		System.out.println("File created..");
		
		workbook.close();
		file.close();
		
		
		
	}

}
