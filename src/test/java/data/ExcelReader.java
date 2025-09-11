package data;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {

	String userDataFilePath = System.getProperty("user.dir") + "\\src\\test\\java\\data\\UserData.xlsx";

	private FileInputStream getFileInputStream() {
		File srcFile = new File(userDataFilePath);
		FileInputStream srcFileReader = null;
		try {
			srcFileReader = new FileInputStream(srcFile);

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return srcFileReader;
	}

	public Object[][] getExcelData() throws IOException {
		FileInputStream srcFileReader = getFileInputStream();
		XSSFWorkbook workbook = new XSSFWorkbook(srcFileReader);
		XSSFSheet sheet = workbook.getSheetAt(0);
		XSSFRow row;
		DataFormatter formatter = new DataFormatter();

		int rows = sheet.getLastRowNum() + 1;
		int cols = 4;

		String[][] excelData = new String[rows][cols];

		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				row = sheet.getRow(i);
				excelData[i][j] = formatter.formatCellValue(row.getCell(j), workbook.getCreationHelper().createFormulaEvaluator());
			}
		}
		workbook.close();

		return excelData;
	}

}
