package ReadExcelFileData;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ExcelDataProvider 
{
	//I am creating below constructor so that I can create object of ExcelDataProvider in TestScript class and call this constructor in TestScript class.
	//in this constructor I am calling testData method of same class.
	public ExcelDataProvider(String excelFilePath, String sheetName) 
	{
		try {
			testData(excelFilePath,sheetName);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
//	in below method I have created object of ExcelUtils class to read and store the excel file data using dataproviders
	public static Object[][] testData(String excelFilePath, String sheetName) throws IOException
	{
		ExcelUtils excel=new ExcelUtils(excelFilePath,sheetName);
		int  row=excel.getRowCount();
		int col=excel.getColumnCount();
		
		Object data[][]=new Object[row-1][col];
		switch(sheetName)
		{
		case "Name":
		for(int i=1;i<row;i++)
		{
			for(int j=0;j<col;j++)
			{
				String cellData=excel.getStringDataValue(i, j);
				System.out.println(cellData);
				data[i-1][j]=cellData;
			}
			
		}
		break;
		case "Number":
			for(int i=1;i<row;i++)
			{
				for(int j=0;j<col;j++)
				{
					String cellData=String.valueOf(excel.getNumberDataValue(i, j));
					System.out.println(cellData);
					data[i-1][j]=cellData;
				}
				
			}
			break;
		}
		return data;
	 }
	
//	Below DataProvider and Test code is written in TestScripts class to fetch it from here
//	@DataProvider(name="test-Data")
//	public Object[][] getData() throws IOException
//	{
//		String excelFilePath="C:\\Users\\Avinash\\Documents\\SeleniumTestData.xlsx";
//		Object data[][]=testData(excelFilePath,"NamesOfCandidates");
//		return data;
//	}
	
//	@Test(dataProvider="test-Data")
//	public void readExcelDataFromSheet(String Name)
//	{
//		System.out.println("Names Mentioned in Excel Sheet are : "+Name);
//	}
}
