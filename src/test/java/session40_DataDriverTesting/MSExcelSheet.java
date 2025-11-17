package session40_DataDriverTesting;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class MSExcelSheet {

	public static void main(String[] args) throws IOException {
		
		//Excel file --> workbook --> Sheets --> Rows --> Cells

		
//1 - Reading data from Excel sheet
		
		// -> Identify the location of the file
		
		//	FileInputStream file = new FileInputStream("C:\\Users\\ssenapathy\\eclipse-workspace\\Javaproject\\TestData\\FnO_Tax_Report_9378344612_01-04-2024_31-03-2025.xlsx");
		//Location of the file hardcoded
		
		FileInputStream file1 = new FileInputStream(System.getProperty("user.dir")+"\\TestData\\FnO_Tax_Report_9378344612_01-04-2024_31-03-2025.xlsx");
		//Location of the file Dynamically (Current project location)
		
		
		// -> Extract workbook from file (pass excel file object file1)
		XSSFWorkbook workbook = new XSSFWorkbook(file1);
		
		
		// -> Extract sheet from workbook using getsheet/getsheetAt(index) method
		XSSFSheet sheet = workbook.getSheet("Trades level");
		
		
		// -> Now Extract Rows and Cells from sheet
		int totalrows = sheet.getLastRowNum(); //Find the total num of rows
		int totalcells = sheet.getRow(0).getLastCellNum(); //From this row get the total num of cells
		
					//getLastRowNum() gives row index (e.g., 60 rows = index 0 to 59).
					//getLastCellNum() returns total number of cells, not index.
		
		System.out.println("No of rows: " + totalrows); //60
		System.out.println("No of cells: " + totalcells); //2
		
		
		for(int r=0; r<=totalrows; r++)   //outer loop representing no.of.rows
		{
			XSSFRow currentrow = sheet.getRow(r);  //Extracting particular row
					
			for(int c=0; c<totalcells; c++)  //inner loop representing no.of.cells/columns
			{
				XSSFCell cells = currentrow.getCell(c);  //Extracting cells from particular row
				System.out.print("Cell values: " + cells.toString()+"\t");
			}
			System.out.println();
		}
			
		workbook.close();
		file1.close();

	}

}
