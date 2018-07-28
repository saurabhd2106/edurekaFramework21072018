package test;

import utils.ExcelDriver;

public class DemoExcelDriver {

	public static void main(String[] args) throws Exception{
		
		ExcelDriver excelDriver = new ExcelDriver();
		String filename = System.getProperty("user.dir")+ "/output/test.xlsx";
		String sSheetName ="Test Data";
		excelDriver.createExcelWorkbook(filename);
		
		excelDriver.openExcelWorkbook(filename);
		
		excelDriver.createSheet(sSheetName);
		
		excelDriver.setCellData(sSheetName, 1, 1, "Saurabh");
		excelDriver.setCellData(sSheetName, 1, 2, "Dhingra");
		excelDriver.setCellData(sSheetName, 2, 1, "Levi");
		excelDriver.setCellData(sSheetName, 2, 2, "Prakash");
		
		excelDriver.save();
		
		excelDriver.close();

	}

}
