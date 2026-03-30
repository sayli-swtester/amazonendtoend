package utility;

import java.io.FileInputStream;
import org.apache.poi.ss.usermodel.*;

    	public class ExcelSheetCode {

    	    public static String getCellData(int row, int col) throws Exception {

    	        FileInputStream fis = new FileInputStream(
    	            System.getProperty("user.dir") + "/src/test/resources/testdata/data.xlsx"
    	        );

    	        Workbook wb = WorkbookFactory.create(fis);
    	        Sheet sheet = wb.getSheet("amazon");

    	        String value = sheet.getRow(row).getCell(col).toString();

    	        wb.close();
    	        return value;
    	    }
    	}