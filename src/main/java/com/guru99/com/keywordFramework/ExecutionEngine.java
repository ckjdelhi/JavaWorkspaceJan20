package com.guru99.com.keywordFramework;

public class ExecutionEngine {

	public static void main(String[] args) throws Exception {
		
		ReusableFuntion func=new ReusableFuntion();
		String[][] keywordData = func.fetchDataFromExcelSheet();
		for(int rowId=1; rowId<keywordData.length;rowId++) {
			String actionName=keywordData[rowId][3];
			String locator=keywordData[rowId][4];
			String locator_value=keywordData[rowId][5];
			String param1=keywordData[rowId][6];
			System.out.println(actionName+"\t"+locator+"\t"+locator_value+"\t"+param1);
			if(actionName.equalsIgnoreCase("launchAppl")) {
				func.launchApplication();
				
			}else if(actionName.equalsIgnoreCase("fillText")) {
				
			}else if(actionName.equalsIgnoreCase("click")) {
				
			}
		}
	}

}
