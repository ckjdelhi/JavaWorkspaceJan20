package com.guru99.com.keywordFramework;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;

import com.drivers.DriverFactory;

public class ReusableFuntion {

	public String[][] fetchDataFromExcelSheet() throws Exception {
		String path = System.getProperty("user.dir")+"\\"+fetchProp("EXCEL_SHEET_NAME");
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
	public static String fetchProp(String key){
		Properties prop=new Properties();
		String file=System.getProperty("user.dir")+"\\src\\main\\resources\\ObjectRepository.properties";
		FileInputStream fs=null;
		try {
			fs = new FileInputStream(file);
			prop.load(fs);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return prop.getProperty(key);
	}
	
	public void launchApplication() {
		WebDriver driver=DriverFactory.getBrowser(fetchProp("browser_name"));
		driver.get(fetchProp("URL"));
		
	}

}
