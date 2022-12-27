package com.qa.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelHandling {
	FileInputStream fis;
	XSSFWorkbook wb;
	XSSFSheet sheet;

	public String[][] getData(String[] args) {

		String path = "C:\\Users\\MANGESH PC\\newCommerce\\V4\\Excelsheet";
		try {
			fis = new FileInputStream(path);
			wb = new XSSFWorkbook(fis);
			sheet = wb.getSheet("sheetname");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		int rowcount = sheet.getPhysicalNumberOfRows();
		int cellcount = sheet.getRow(0).getLastCellNum();
		String[][] data = new String[rowcount - 1][cellcount];

		for (int i = 0; i < rowcount - 1; i++) {
			for (int j = 0; j < cellcount; j++) {
				DataFormatter df = new DataFormatter();
				data[i][j] = df.formatCellValue(sheet.getRow(i + 1).getCell(j));
			}
		}
		try {
			fis.close();
			wb.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return data;

	}
}
