package Utilities;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;

public class ExcelReader {

    @DataProvider(name = "dynamicExcelProvider")
    public static Object[][] getData(Method method) {
        // 1. Get the running Class name and Method name dynamically
        String className = method.getDeclaringClass().getSimpleName();
        String runningMethodName = method.getName();
        
        // 2. Build the path to the individual Excel file (e.g., src/test/resources/testdata/LoginTests.xlsx)
        String filePath = "src/test/resources/" + className + ".xlsx";
        String sheetName = "login"; // Default sheet name used across files
        
        List<Object[]> testDataList = new ArrayList<>();

        // 3. Open and read the Excel file directly here
        try (FileInputStream fis = new FileInputStream(filePath);
             Workbook workbook = WorkbookFactory.create(fis)) {
            
            Sheet sheet = workbook.getSheet(sheetName);
            if (sheet == null) {
                throw new RuntimeException("Sheet '" + sheetName + "' not found in file: " + filePath);
            }
            
            int rowCount = sheet.getLastRowNum();

            // Loop through all rows, skipping the header row (index 0)
            for (int i = 1; i <= rowCount; i++) {
                Row row = sheet.getRow(i);
                if (row == null) continue;

                // Cell 0 holds the Method Name mapping
                Cell firstCell = row.getCell(0);
                String cellMethodName = (firstCell != null) ? firstCell.getStringCellValue().trim() : "";

                // If row belongs to the current test method, extract its data columns
                if (cellMethodName.equalsIgnoreCase(runningMethodName)) {
                    int colCount = row.getLastCellNum();
                    
                    // (colCount - 1) because we skip the first column (MethodName)
                    Object[] rowData = new Object[colCount - 1]; 

                    for (int j = 1; j < colCount; j++) {
                        Cell cell = row.getCell(j);
                        rowData[j - 1] = formatCellToString(cell);
                    }
                    testDataList.add(rowData);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException("Failed to read Excel file at: " + filePath + ". Ensure file exists and naming matches your Test Class.", e);
        }

        // 4. Return data as a 2D array to TestNG
        return testDataList.toArray(new Object[0][]);
    }

    // Helper method inside the same class to sanitize cell variations (String, Numeric, Boolean)
    private static String formatCellToString(Cell cell) {
        if (cell == null) return "";
        
        switch (cell.getCellType()) {
            case STRING:
                return cell.getStringCellValue();
            case NUMERIC:
                if (DateUtil.isCellDateFormatted(cell)) {
                    return cell.getDateCellValue().toString();
                }
                return String.valueOf((long) cell.getNumericCellValue()); // Prevents decimals on whole numbers
            case BOOLEAN:
                return String.valueOf(cell.getBooleanCellValue());
            case BLANK:
                return "";
            default:
                return cell.toString();
        }
    }
}