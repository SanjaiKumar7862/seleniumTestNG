package session40_DataDriverTesting;

import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class MSExcelSheetWrite {

	public static void main(String[] args) throws IOException {
		
//1 - Write data in Excel file (Pass static data)
		
		//Created new workbook
		XSSFWorkbook workbook = new XSSFWorkbook();
		
		
		//Create a new Sheet
		XSSFSheet Sheet = workbook.createSheet("Data");

		
		//Create Row1 and set cell value
				XSSFRow Row1 = Sheet.createRow(0);
				
				Row1.createCell(0).setCellValue("Welcome");
				Row1.createCell(1).setCellValue(7878);
				Row1.createCell(2).setCellValue("Java");
		
		
		//Create Row2 and set cell value
				XSSFRow Row2 = Sheet.createRow(1);
				
				Row2.createCell(0).setCellValue("Welcome");
				Row2.createCell(1).setCellValue(7879);
				Row2.createCell(2).setCellValue("Python");
		
		
		//Create Row3 and set cell value
				XSSFRow Row3 = Sheet.createRow(2);
				
				Row3.createCell(0).setCellValue("Welcome");
				Row3.createCell(1).setCellValue(7880);
				Row3.createCell(2).setCellValue("C++");
				
				
		//Create a new excel file
				FileOutputStream file = new FileOutputStream(System.getProperty("user.dir")+"\\TestData\\write.xlsx");
								
		//Finally attach workbook into the file	
				workbook.write(file);
				
				workbook.close();
				file.close();
		
			System.out.println("File is created..");	
				
				
	}

}
