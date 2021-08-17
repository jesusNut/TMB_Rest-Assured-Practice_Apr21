package com.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DPwithExcelSheet {

	@Test(dataProvider = "getDatawithHashMapAnd2DObjectArray")
	public void dpWithExcelTest(Map<String, String> map) {

		System.out.println(map.get("username"));
		System.out.println(map.get("password"));
		System.out.println(map.get("firstname"));
		System.out.println(map.get("lastname"));

	}
	
	//normal data provider with return type as 2D Array without HASHMAP

	@DataProvider
	public Object[][] getData() throws IOException {

		String excel_sheet_path = System.getProperty("user.dir") + "/excel/DPwithExcel.xlsx";

		FileInputStream fis = new FileInputStream(excel_sheet_path);

		Workbook workbook = new XSSFWorkbook(fis);

		Sheet sheet = workbook.getSheetAt(0);

		int total_rows = sheet.getLastRowNum();

		Row row = sheet.getRow(0);

		int total_col = row.getLastCellNum();

		Object[][] data = new Object[total_rows][total_col];

		for (int i = 1; i <= total_rows; i++) {

			for (int j = 0; j < total_col; j++) {

				data[i - 1][j] = sheet.getRow(i).getCell(j).getStringCellValue();

			}

		}

		return data;
	}
	
	// data provider with return type as 1D Object Array and HASHMAP

	@DataProvider
	public Object[] getDatawithHashMap() throws IOException {

		String excel_sheet_path = System.getProperty("user.dir") + "/excel/DPwithExcel.xlsx";

		FileInputStream fis = new FileInputStream(excel_sheet_path);

		Workbook workbook = new XSSFWorkbook(fis);

		Sheet sheet = workbook.getSheetAt(0);

		int total_rows = sheet.getLastRowNum();

		Row row = sheet.getRow(0);

		int total_col = row.getLastCellNum();

		List<Map<String, String>> list = new ArrayList<Map<String, String>>();

		Map<String, String> datamap = null;

		for (int i = 1; i <= total_rows; i++) {

			datamap = new HashMap<String, String>();

			for (int j = 0; j < total_col; j++) {

				String key = sheet.getRow(0).getCell(j).getStringCellValue();

				String value = sheet.getRow(i).getCell(j).getStringCellValue();

				datamap.put(key, value);

			}

			list.add(datamap);

		}

		return list.toArray();
	}
	
	
	// data provider with return type as 2D Object Array and HASHMAP
	

	@DataProvider
	public Object[][] getDatawithHashMapAnd2DObjectArray() throws IOException {

		String excel_sheet_path = System.getProperty("user.dir") + "/excel/DPwithExcel.xlsx";

		FileInputStream fis = new FileInputStream(excel_sheet_path);

		Workbook workbook = new XSSFWorkbook(fis);

		Sheet sheet = workbook.getSheetAt(0);

		int total_rows = sheet.getLastRowNum();

		Row row = sheet.getRow(0);

		int total_col = row.getLastCellNum();

		Object[][] data = new Object[total_rows][total_col];

		Map<String, String> datamap = null;

		for (int i = 1; i <= total_rows; i++) {

			datamap = new HashMap<String, String>();

			for (int j = 0; j < total_col; j++) {

				String key = sheet.getRow(0).getCell(j).getStringCellValue();

				String value = sheet.getRow(i).getCell(j).getStringCellValue();

				datamap.put(key, value);

			}

			data[i - 1] = new Object[] { datamap };

		}

		return data;
	}

}
