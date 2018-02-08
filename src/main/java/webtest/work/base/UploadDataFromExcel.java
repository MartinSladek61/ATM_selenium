package webtest.work.base;

import webtest.work.base.ExcelUtils;

public class UploadDataFromExcel {

    private static String excelPath = ".\\src\\main\\java\\webtest\\work\\dataSet\\Default.xlsx";

    public static String setVariablesForNewPerson(String person, int row, int col) throws Exception {
        String cellData;
        ExcelUtils excelUtils = new ExcelUtils();
        excelUtils.setExcelFile(excelPath);
        excelUtils.setExcelWSheet(person);
        cellData = excelUtils.getStringCellData(row, col);
        return cellData;
    }
}
