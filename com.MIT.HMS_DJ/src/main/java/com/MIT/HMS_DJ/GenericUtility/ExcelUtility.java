package com.MIT.HMS_DJ.GenericUtility;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {
	Workbook wbook;
	public String getCellData(String sheet,int row,int cell) throws Throwable
	{
		FileInputStream fis1=new FileInputStream("./TestData/MIT.HMS.TestData.xlsx");//"C:\\Users\\Divya Jyothi\\OneDrive\\Desktop\\Tek Pyramid\\HMS Project\\MIT.HMS.TestData.xlsx");
		wbook= WorkbookFactory.create(fis1);
		
		Sheet sh=wbook.getSheet(sheet);
		String data=sh.getRow(row).getCell(cell).getStringCellValue();
		return data;
	}

	public int getRowCount(String sheet) throws Throwable
	{
		FileInputStream fis1=new FileInputStream("./TestData/MIT.HMS.TestData.xlsx"); //("C:\\Users\\Divya Jyothi\\OneDrive\\Desktop\\Tek Pyramid\\HMS Project\\MIT.HMS.TestData.xlsx");
		wbook= WorkbookFactory.create(fis1);
		
		Sheet sh=wbook.getSheet(sheet);
		int rowCount=sh.getLastRowNum();
		return rowCount;
	}
	
	public void CloseExcel() throws Throwable
	{
		wbook.close();
	}
}
