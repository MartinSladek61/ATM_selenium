package webtest.work.base;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Color;
import org.apache.poi.xssf.usermodel.*;

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
     */
    private String getStringCellData(int rowNum, int colNum) {
        String cellData;
        cell = excelWSheet.getRow(rowNum).getCell(colNum);
        cellData = cell.getStringCellValue();
        return cellData;
    }

   /*
   private List<String> getDataFromColumn(List<String> list, int cellNumber) throws Exception {
        for (int i = 1; i <= getNumberOfTestSteps(); i++)//i=1 because first row in excel is for names of columns
        {
            cell = excelWSheet.getRow(i).getCell(cellNumber);
            if (cell == null) {
                list.add(null);
            } else {
                list.add(getStringCellData(i, cellNumber));
            }
        }
        return list;
    }
    */

}