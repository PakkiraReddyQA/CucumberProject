package generic_Utility;


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;


public class ExcelFileUtility {
	/**
	 * This method will read data from excel sheet and return the value
	 * @param sheet
	 * @param rowNo
	 * @param cellNo
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public String readDatafromExcel(String sheet,int rowNo,int cellNo) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis=new FileInputStream(Iconstant.ExcelSheetFilepath);
		Workbook book = WorkbookFactory.create(fis);
		Sheet sh = book.getSheet(sheet);
//		Row rw = sh.getRow(rowNo);
		 String value = sh.getRow(rowNo).getCell(cellNo).getStringCellValue();
//   	Cell ce = rw.getCell(cellNo);
//		String value = ce.getStringCellValue();
		book.close();
		return value;
	}
	/**
	 * this method will write data in excel sheet
	 * @param Sheet
	 * @param rowNo
	 * @param cellNo
	 * @param value
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public void writeDataIntoExcel(String Sheet,int rowNo,int cellNo,String value) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis=new FileInputStream(Iconstant.ExcelSheetFilepath);
		Workbook book = WorkbookFactory.create(fis);
		Sheet sh = book.getSheet(Sheet);
	   sh.getRow(rowNo).createCell(cellNo).setCellValue(value);
	   /*alternative soultion*/
//		Cell ce= rw.createCell(cellNo);
//		ce.setCellValue(value);
		
		FileOutputStream fos=new FileOutputStream(Iconstant.ExcelSheetFilepath);
		book.write(fos);
		book.close();	
	}
	/**
	 * this method will read multiple data from excel sheet return the data
	 * @param sheetName
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public Object[][] readmultipleDatafromExcel(String sheetName) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis=new FileInputStream(Iconstant.ExcelSheetFilepath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetName);
		int lastRow = sh.getLastRowNum();
		short lastCel =sh.getRow(0).getLastCellNum();
		//Intialization
		Object[][] data=new Object[lastRow][lastCel];
		
		for(int i=0;i<lastRow;i++)
		{
			for(int j=0;j<lastCel;j++)
			{
				data[i][j]=sh.getRow(i+1).getCell(j).getStringCellValue();
			}
		}
		return data;
	}
	/**
	 * This method will give row count if we give provide particular sheet
	 * @param sheet
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public int getRowCount(String sheet) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis=new FileInputStream(Iconstant.ExcelSheetFilepath);
		Workbook book = WorkbookFactory.create(fis);
		Sheet sh = book.getSheet(sheet);
		int rowcount = sh.getLastRowNum();
		return rowcount;
	}
}
