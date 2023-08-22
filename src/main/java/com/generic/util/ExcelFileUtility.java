package com.generic.util;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelFileUtility {

	public String readDataFromExcelSheet(String SheetName, int row, int cell)
			throws EncryptedDocumentException, IOException {
		FileInputStream file = new FileInputStream("");
		Workbook book = WorkbookFactory.create(file);
		return book.getSheet(SheetName).getRow(row).getCell(cell).getStringCellValue();
	}

	public void writeDataIntoExcelSheet(String SheetName, int row, int cell)
			throws EncryptedDocumentException, IOException {
		FileInputStream file = new FileInputStream("");
		Workbook book = WorkbookFactory.create(file);
		book.getSheet(SheetName).getRow(row).getCell(cell).getStringCellValue();
		FileOutputStream fout = new FileOutputStream("");
		book.write(fout);
		book.close();
	}

	public void readMultipleDataFromExcelSheet(String SheetName, int row, int cell)
			throws EncryptedDocumentException, IOException {
		FileInputStream file = new FileInputStream("");
		Workbook book = WorkbookFactory.create(file);
		Sheet sheet = book.getSheet(SheetName);

		row = sheet.getLastRowNum();
		cell = sheet.getRow(0).getLastCellNum();

		Object[][] data = new Object[row][cell];

		for (int i = 0; i < row; i++) {
			for (int j = 0; j < cell; j++) {
				data[i][j] = sheet.getRow(i).getCell(j).getStringCellValue();
			}
		}
	}

}
