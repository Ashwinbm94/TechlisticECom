/**
 * 
 */
package com.techlistic.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * @author Ashwin BM
 *
 */
public class ExcelFileReader {

	XSSFWorkbook wb;
	XSSFSheet sheet;

	public ExcelFileReader() {
		try {
			ConfigFileReader config = new ConfigFileReader();
			File excelFile = new File(config.getExcelPath());
			FileInputStream excelfis = new FileInputStream(excelFile);
			wb = new XSSFWorkbook(excelfis);
			sheet = wb.getSheet(config.getExcelSheetName());
		} catch (Exception e) {
			System.out.println("Error in reading Excel File: " + e.getMessage());
		}
	}

	public String getUserName(String userType) {
		String Uname = null;
		int rownum = sheet.getLastRowNum() + 1;
		for (int i = 1; i < rownum; i++) {
			if (sheet.getRow(i).getCell(0).getStringCellValue().equalsIgnoreCase(userType)) {
				if (sheet.getRow(i).getCell(1).getCellType() == CellType.NUMERIC) {
					Uname = NumberToTextConverter.toText(sheet.getRow(i).getCell(1).getNumericCellValue());
				} else
					Uname = sheet.getRow(i).getCell(1).getStringCellValue();
			}

		}
		return Uname;
	}

	public String getPassword(String userType) {
		String pwd = null;
		int rowNum = sheet.getLastRowNum() + 1;
		for (int i = 1; i < rowNum; i++) {
			if (sheet.getRow(i).getCell(0).getStringCellValue().equalsIgnoreCase(userType)) {
				Cell cell = sheet.getRow(i).getCell(2);
				if (cell.getCellType() == CellType.NUMERIC) {
					pwd = NumberToTextConverter.toText(sheet.getRow(i).getCell(2).getNumericCellValue());
				} else {
					pwd = sheet.getRow(i).getCell(2).getStringCellValue();
				}
			}
		}

		return pwd;
	}

	public void closeExcelWB() {
		try {
			wb.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
