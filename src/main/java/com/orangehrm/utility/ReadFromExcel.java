package com.orangehrm.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadFromExcel {

	public String[][] readData() throws IOException {

		String excelFilePath = "D:\\Login_Data.xlsx";
		File file = new File(excelFilePath);
		FileInputStream fis = new FileInputStream(file);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet1 = wb.getSheet("Sheet1");
		int rowCount = sheet1.getLastRowNum();
		int colCount = sheet1.getRow(1).getLastCellNum();
		
		String[][] data = new String[rowCount][colCount];
		
		for(int i = 1 ;i <= rowCount ; i++) {
			
			for(int j = 0 ; j < colCount ;j++) {
				
				data[i-1][j] = sheet1.getRow(i).getCell(j).getStringCellValue(); 
				System.out.println(data[i-1][j]);
				
			}
		}
		
		return data;
	}
	
	public static void main(String[] args) throws IOException {
		ReadFromExcel obj = new ReadFromExcel();
		obj.readData();
		
	}

	
}
