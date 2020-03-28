package com.guru99.com.keywordFramework;

import java.io.File;
import java.io.FileInputStream;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

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
	WebDriver driver=null;
	public void launchApplication() {
		driver=DriverFactory.getBrowser(fetchProp("browser_name"));
		driver.get(fetchProp("URL"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	public void fillText(String locator, String locator_value, String param1) {
		if(locator.equalsIgnoreCase("Id")) {
			driver.findElement(By.id(fetchProp(locator_value))).sendKeys(param1);
		}else if(locator.equalsIgnoreCase("name")) {
			driver.findElement(By.name(fetchProp(locator_value))).sendKeys(param1);
		}else if(locator.equalsIgnoreCase("xpath")) {
			driver.findElement(By.xpath(fetchProp(locator_value))).sendKeys(param1);
		}
	}
	public void click(String locator, String locator_value) {
		if(locator.equalsIgnoreCase("Id")) {
			driver.findElement(By.id(fetchProp(locator_value))).click();
		}else if(locator.equalsIgnoreCase("name")) {
			driver.findElement(By.name(fetchProp(locator_value))).click();
		}else if(locator.equalsIgnoreCase("xpath")) {
			driver.findElement(By.xpath(fetchProp(locator_value))).click();
		}else if(locator.equalsIgnoreCase("linkText")) {
			driver.findElement(By.linkText(fetchProp(locator_value))).click();
		}
	}
	public void clickRadio(String locator, String locator_value, String param1) {
		By by=null;
		if(locator.equalsIgnoreCase("Id")) {
			by=By.id(locator);
		}else if(locator.equalsIgnoreCase("name")) {
			by=By.name(locator);
		}else if(locator.equalsIgnoreCase("xpath")) {
			by=By.xpath(locator);
		}else if(locator.equalsIgnoreCase("linkText")) {
			by=By.linkText(locator);
		}
		if(by !=null) {
			List<WebElement> genders = driver.findElements(by);
			if(param1.equalsIgnoreCase("Male")) {
				genders.get(0).click();;
			}else {
				genders.get(1).click();;
			}
		}
	}

}
