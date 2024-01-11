package testng.datadriven;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {
	private static XSSFWorkbook workbook;
	private static XSSFSheet sheet;
	
	public ExcelUtils(String file, String sheetName) {
		
		try {
			workbook = new XSSFWorkbook(file);
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		sheet = workbook.getSheet(sheetName);
	}
	
	public int getRowCount() {
		return sheet.getPhysicalNumberOfRows();
	}
	
	public int getColCount() {
		return sheet.getRow(0).getPhysicalNumberOfCells();
	}
	
	public String getCellDataString(int row, int col) {
		return sheet.getRow(row).getCell(col).getStringCellValue();
		
	}
}
