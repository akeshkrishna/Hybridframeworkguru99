package utils;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelReader {
	private org.apache.poi.ss.usermodel.Sheet sheet;

    public ExcelReader(String excelPath, String sheetName) {
        try {
            FileInputStream fis = new FileInputStream(excelPath);
            Workbook workbook = WorkbookFactory.create(fis);
            sheet = workbook.getSheet(sheetName);
            fis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getCellData(int row, int col) {
        return sheet.getRow(row).getCell(col).getStringCellValue();
    }

}
