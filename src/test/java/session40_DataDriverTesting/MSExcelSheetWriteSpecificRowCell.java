package session40_DataDriverTesting;

import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class MSExcelSheetWriteSpecificRowCell {

	public static void main(String[] args) throws IOException {

//1 - Write data in Excel file (Pass data at Specific row and cell)

			//Create a new excel file
			FileOutputStream file = new FileOutputStream(System.getProperty("user.dir")+"\\TestData\\write2.xlsx");
			
			//Created new workbook
			XSSFWorkbook workbook = new XSSFWorkbook();
					
			//Create a new Sheet
			XSSFSheet Sheet = workbook.createSheet("Data1");
			
			XSSFRow Row = Sheet.createRow(3);  //3rd Row
			XSSFCell Cell = Row.createCell(3);  //4th Cell
			
			Cell.setCellValue("3rd Row and 3rd Cell");
			
			workbook.write(file);  //Attach data into workbook
			
			workbook.close();
			file.close();
			
			System.out.println("File created..");
			
			
			
			
	}

}
