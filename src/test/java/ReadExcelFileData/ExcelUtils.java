package ReadExcelFileData;

import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils
{
static XSSFWorkbook workbook;
static XSSFSheet sheet;
/*
 * Versions for below dependencies should be same in pom.xml else it won't gives you an import option to import XSSFWorkbook and Sheet
<dependency>
<groupId>org.apache.poi</groupId>
<artifactId>poi-ooxml</artifactId>
<version>3.11</version>
</dependency>

<dependency>
<groupId>org.apache.poi</groupId>
<artifactId>poi</artifactId>
<version>3.11</version>
</dependency>
*/

		public ExcelUtils(String excelFilePath, String sheetName) throws IOException
		{
			workbook =new XSSFWorkbook(excelFilePath);
			sheet=workbook.getSheet(sheetName);
		}
		
		public static int getRowCount()
		{
			int rowCount=sheet.getPhysicalNumberOfRows();
			System.out.println("Total Rows present in mentioned sheet are : "+rowCount);
			return rowCount;
		}
		
		public static int getColumnCount()
		{
			int columnCount=sheet.getRow(0).getPhysicalNumberOfCells();
			System.out.println("Total columns present in mentioned sheet are : "+columnCount);
			return columnCount;
		}
		
		public static String getStringDataValue(int rownum,int colnum)
		{
			String cellData=sheet.getRow(rownum).getCell(colnum).getStringCellValue();
//			System.out.println(cellData); //this method is being called in DataProvider class and was writing same data multiple times on console so commented from this classs
			return cellData;
		}
		
		public static String getNumberDataValue(int rownum,int colnum)
		{
			//Used data formatter becase as in excel it was number format data and was giving exception while runtime Cannot get a text value from a numeric cell ”
			DataFormatter formatter = new DataFormatter();
			String cellData = formatter.formatCellValue(sheet.getRow(rownum).getCell(colnum));
			
//			String cellData=String.valueOf(sheet.getRow(rownum).getCell(colnum).getNumericCellValue());
//			double cellData=sheet.getRow(rownum).getCell(colnum).getNumericCellValue();
//			System.out.println(cellData); //this method is being called in DataProvider class and was writing same data multiple times on console so commented from this classs
			return cellData;
		}
}
