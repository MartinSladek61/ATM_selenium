package webtest.work.base;

import webtest.work.base.ExcelUtils;

public class UploadDataFromExcel {

    private static String excelPath = ".\\src\\main\\java\\webtest\\work\\dataSet\\Default.xlsx";

    /**
     * Sets a value to variable
     *
     * @param person string name of list in excel sheet (specified by person)
     * @param row number of row
     * @param col number of column
     * @return data from specifies cell
     * @throws Exception e
     */
    public static String setVariablesForNewPerson(String person, int row, int col) throws Exception {
        String cellData;
        ExcelUtils excelUtils = new ExcelUtils();
        excelUtils.setExcelFile(excelPath);
        excelUtils.setExcelWSheet(person);
        cellData = excelUtils.getStringCellData(row, col);
        return cellData;
    }
}
