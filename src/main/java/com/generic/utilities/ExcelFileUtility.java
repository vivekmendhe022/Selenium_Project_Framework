package com.generic.utilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * This class contains all excel data for Data Driven Testing.
 * 
 * @author Vivekanand M
 *
 */
public class ExcelFileUtility {

	/**
	 * This method read data from excel sheet & return the data from caller. This is
	 * the design strategy for data driven testing
	 * 
	 * @param SHEETNAME
	 * @param ROW
	 * @param CELL
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public String readDataFromExcel(String SHEETNAME, int ROW, int CELL)
			throws EncryptedDocumentException, IOException {
		FileInputStream file = new FileInputStream("");
		Workbook book = WorkbookFactory.create(file);
		return book.getSheet(SHEETNAME).getRow(ROW).getCell(CELL).getStringCellValue();
	}

	/**
	 * This method will write data into excel sheet
	 * 
	 * @param SHEETNAME
	 * @param ROW
	 * @param CELL
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public void writeDataInExcel(String SHEETNAME, int ROW, int CELL) throws EncryptedDocumentException, IOException {
		FileInputStream file = new FileInputStream("");
		Workbook book = WorkbookFactory.create(file);
		book.getSheet(SHEETNAME).getRow(ROW).getCell(CELL).getStringCellValue();

		FileOutputStream fileout = new FileOutputStream("");
		book.write(fileout);
		book.close();
	}

	/**
	 * This method will read multiple data from excel sheet
	 * @param SHEETNAME
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public Object[][] readDataFromDataProvider(String SHEETNAME) throws EncryptedDocumentException, IOException {
		FileInputStream file = new FileInputStream("");
		Workbook book = WorkbookFactory.create(file);
		Sheet sheet = book.getSheet(SHEETNAME);

		int row = sheet.getLastRowNum();
		int cell = sheet.getRow(0).getLastCellNum();
		Object[][] data = new Object[row][cell];
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < cell; j++) {
				data[i][j] = sheet.getRow(i).getCell(j).getStringCellValue();
			}
		}
		return data;
	}
}
