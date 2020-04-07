package com.test;

import org.testng.annotations.AfterClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.guru99.com.keywordFramework.ReusableFuntion;

public class DataDrivenTest {
	ReusableFuntion func=new ReusableFuntion();
	
	@Test(dataProvider = "EXCEL_DATA")
	public void canTestExcelData(String testCase,String testStep,String desc,String actionName,String locator,String locator_value,String param1) {
		switch(actionName) {
			case "launchAppl":
				func.launchApplication();
				break;
			case "fillText":
				func.fillText(locator, locator_value, param1);
				break;
			case "click":
				func.click(locator, locator_value);
				break;
			case "clickRadio":
				func.clickRadio(locator, locator_value, param1);
				break;
		}
	}
	@AfterClass
	public void close() {
		func.closeBrowser();
	}
	
	@DataProvider(name = "EXCEL_DATA")
	public Object[][] readData(){
		try {
			return func.fetchDataFromExcelSheet();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	  
}
