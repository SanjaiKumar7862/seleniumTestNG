package session40_DataDriverTesting;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class S41_ExcelUtilityFile {
	
	public static FileInputStream fi;
	public static FileOutputStream fo;
	public static XSSFWorkbook wb;
	public static XSSFSheet ws;
	public static XSSFRow row;
	public static XSSFCell cell;
	public static CellStyle style;

		public static int getRowCount(String xlfile, String xlsheet) throws IOException 
		{
		    fi = new FileInputStream(xlfile); // Open file input stream
		    wb = new XSSFWorkbook(fi);        // Load workbook
		    ws = wb.getSheet(xlsheet);        // Get sheet by name
		    int rowcount = ws.getLastRowNum(); // Get last row number (0-based)
		    wb.close();  // Close workbook
		    fi.close();  // Close input stream
		    return rowcount;  // Return total rows
		}

		
		public static int getCellCount(String xlfile, String xlsheet, int rownum) throws IOException 
		{
		    fi = new FileInputStream(xlfile); // Open Excel file
		    wb = new XSSFWorkbook(fi);        // Load workbook
		    ws = wb.getSheet(xlsheet);        // Get sheet
		    row = ws.getRow(rownum);          // Get specific row
		    int cellcount = row.getLastCellNum(); // Get number of cells in that row
		    wb.close();
		    fi.close();
		    return cellcount;
		}

		
		public static String getCellData(String xlfile, String xlsheet, int rownum, int column) throws IOException
		{
		    fi = new FileInputStream(xlfile);
		    wb = new XSSFWorkbook(fi);
		    ws = wb.getSheet(xlsheet);
		    row = ws.getRow(rownum);
		    cell = row.getCell(column);

		    String data;
		    try
		    {
		        // data = cell.toString();
		        DataFormatter formatter = new DataFormatter();
		        data = formatter.formatCellValue(cell); // Returns the formatted value of a cell as a String regardless of the cell type.
		    }
		    catch (Exception e)
		    {
		        data = "";
		    }

		    wb.close();
		    fi.close();
		    return data;
		}
		
		
		public static void setCellData(String xlfile, String xlsheet, int rownum, int colnum, String data) throws IOException
		{
		    fi = new FileInputStream(xlfile);
		    wb = new XSSFWorkbook(fi);
		    ws = wb.getSheet(xlsheet);
		    row = ws.getRow(rownum);
		    cell = row.createCell(colnum);
		    cell.setCellValue(data);
		    fo = new FileOutputStream(xlfile);
		    wb.write(fo);
		    wb.close();
		    fi.close();
		    fo.close();
		}

		
		public static void fillGreenColor(String xlfile, String xlsheet, int rownum, int colnum) throws IOException
		{
		    fi = new FileInputStream(xlfile);
		    wb = new XSSFWorkbook(fi);
		    ws = wb.getSheet(xlsheet);
		    row = ws.getRow(rownum);
		    cell = row.getCell(colnum);

		    style = wb.createCellStyle();
		    style.setFillForegroundColor(IndexedColors.BRIGHT_GREEN.getIndex());
		    style.setFillPattern(FillPatternType.SOLID_FOREGROUND);

		    cell.setCellStyle(style);

		    fo = new FileOutputStream(xlfile);
		    wb.write(fo);
		    wb.close();
		    fi.close();
		    fo.close();
		}

		public static void fillRedColor(String xlfile, String xlsheet, int rownum, int colnum) throws IOException
		{
		    fi = new FileInputStream(xlfile);
		    wb = new XSSFWorkbook(fi);
		    ws = wb.getSheet(xlsheet);
		    row = ws.getRow(rownum);
		    cell = row.getCell(colnum);

		    style = wb.createCellStyle();

		    style.setFillForegroundColor(IndexedColors.RED.getIndex());
		    style.setFillPattern(FillPatternType.SOLID_FOREGROUND);

		    cell.setCellStyle(style);
		    fo = new FileOutputStream(xlfile);
		    wb.write(fo);
		    wb.close();
		    fi.close();
		    fo.close();
		}


}
