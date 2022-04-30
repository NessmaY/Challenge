package data;

import java.io.FileInputStream;
import java.io.IOException;


import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class ExcelReader {

	
	@DataProvider(name = "TestData")
	public static Object[][] loginData() throws IOException {
		String filePath = System.getProperty("user.dir")+"/src/test/java/data/TestData.xlsx";
		Object[][] arrayObject = getExcelData(
				
				filePath,
				"InvalidCredetnials");
		return arrayObject;
	}
	
	
	public static String[][] getExcelData(String fileName, String sheetName) throws IOException {

		FileInputStream fs;
		String[][] data;
		
				fs= new FileInputStream(fileName);
				XSSFWorkbook wb = new XSSFWorkbook(fs);
				XSSFSheet sh = wb.getSheet(sheetName);
				int totalNoOfCols = sh.getRow(0).getLastCellNum();
				int totalNoOfRows = sh.getLastRowNum()+1;
				data = new String[(totalNoOfRows - 1)][totalNoOfCols];
				// Loop through all rows in the sheet
				// Start at row 1 as row 0 is our header row
				for (int i = 1; i <= totalNoOfRows -1 ; i++) {
					XSSFRow row = sh.getRow(i);
					for (int j = 0; j < totalNoOfCols; j++) {

						data[i][j] = row.getCell(j).toString();
					}
					}

		
			
		return data;
		
		
	}
	
}
