package Util.MyUtility.Excel;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadAllRows {

	public static void main(String[] args) {
		
		try {
			
			FileInputStream fis = new FileInputStream("D:\\My_Projects\\MyUtility\\data.xlsx");
			XSSFWorkbook wb = new XSSFWorkbook(fis);
			XSSFSheet sheet = wb.getSheetAt(1);
			
			Iterator<Row> itr = sheet.iterator();
			while (itr.hasNext()){
				Row row =itr.next();				
				Iterator<Cell> cellIterator = row.cellIterator();
				while(cellIterator.hasNext()){
					Cell cell = cellIterator.next();
					
					switch(cell.getCellType())	{
				
					case Cell.CELL_TYPE_STRING:    //field that represents string cell type  
						System.out.print(cell.getStringCellValue()+ "\t");  
						break;  
						
					case Cell.CELL_TYPE_NUMERIC:    //field that represents number cell type  
						System.out.print(cell.getNumericCellValue()+ "   " );  
						break;  
						default:  
						
					}
					}
				System.out.println("");  
			}					 
		} catch (Exception e) {
			e.printStackTrace();  
			}		
	}
}
