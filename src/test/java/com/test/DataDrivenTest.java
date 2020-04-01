package com.test;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataDrivenTest {
	
	@Test(dataProvider = "EXCEL_DATA")
	public void canTestExcelData(String c1,String c2,String c3,String c4,String c5,String c6,String c7) {
		System.out.println(c1);
	}
	
	@DataProvider(name = "EXCEL_DATA")
	public Object[][] readData(){
		try {
			return fetchDataFromExcelSheet();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	public String[][] fetchDataFromExcelSheet() throws Exception {
		String path = System.getProperty("user.dir")+"\\keywordData.xlsx";
		FileInputStream file=new FileInputStream(new File(path));
		String fileExtention= path.substring(path.indexOf(".")+1);
		Workbook workbook;
		if(fileExtention.equals("xlsx")) {
			workbook=new XSSFWorkbook(file);
		}else {
			workbook=new HSSFWorkbook(file);
		}
		Sheet sheet=workbook.getSheet("Sheet1");
		int rowsCount = sheet.getLastRowNum()+1;
		int columnCount = sheet.getRow(0).getLastCellNum();
		
		String [][] data=new String[rowsCount][columnCount];
		for(int i=0;i<rowsCount;i++) {
			Row row=sheet.getRow(i);
			for(int j=0;j<columnCount;j++) {
				Cell cell=row.getCell(j);
				data[i][j]=cell.toString();
			}
		}
		workbook.close();
		file.close();
		return data;
	}
}
