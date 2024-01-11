package testng.datadriven;

import org.testng.annotations.DataProvider;

public class ExcelDataProvider {

	public static void main(String[] args) {
		getUserData();
	}
	
	@DataProvider(name="ExternalDataSet")
	public static Object[][] getUserData() {
		String file = "/Users/rashed/eclipse-workspace/ostad.sqa3/data/data.xlsx";
		String sheetName = "dataSheet";
		
		ExcelUtils ex = new ExcelUtils(file, sheetName);
		int row = ex.getRowCount();
		int col = ex.getColCount();
		
		Object[][] data = new Object[row - 1][col];
		
		for(int r = 1; r<row; r++) {
			for(int c = 0; c<col; c++) {
				data[r - 1][c] = ex.getCellDataString(r, c);
			}
		}
		return data;
	}
}
