package webtest.work.base;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;

public class ExcelUtils {

    private XSSFSheet excelWSheet;
    private XSSFWorkbook excelWBook;
    private XSSFCell cell;


    /**
     * open excel file
     *
     * @param path to the file
     * @throws Exception e
     */
    public void setExcelFile(String path) throws Exception {
        FileInputStream excelFile = new FileInputStream(path);
        excelWBook = new XSSFWorkbook(excelFile);

    }

    /**
     * set excel sheet
     *
     * @param sheetName name of the sheet
     */
    public void setExcelWSheet(String sheetName) {
        excelWSheet = excelWBook.getSheet(sheetName);
    }

    /**
     * read data from excel
     *
     * @param rowNum number of the row
     * @param colNum number of the column
     * @return data from cell
     * @throws Exception e
     */
    public String getStringCellData(int rowNum, int colNum) throws Exception {
        String cellData;
        cell = excelWSheet.getRow(rowNum).getCell(colNum);
        cellData = cell.getStringCellValue();
        return cellData;
    }

    public void setCellData(int rowNum, int colNum, String value)
    {
        cell = excelWSheet.getRow(rowNum).getCell(colNum);
        cell.setCellValue(value);
    }

}