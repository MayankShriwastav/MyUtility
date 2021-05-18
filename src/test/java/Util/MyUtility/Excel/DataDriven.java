package Util.MyUtility.Excel;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DataDriven {
	
	ArrayList<String> lst = new ArrayList();	
	
	public ArrayList<String> getData(String testCaseName) throws IOException{		
	
		FileInputStream fis = new FileInputStream("D:\\My_Projects\\MyUtility\\data.xlsx");		
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		int sheets = workbook.getNumberOfSheets();
		for(int i=0 ; i<sheets ; i++){
			if(workbook.getSheetName(i).equalsIgnoreCase("testdata")){
				XSSFSheet sheet = workbook.getSheetAt(i);
				
				Iterator <Row> rows = sheet.iterator();
				Row row = rows.next();
				Iterator <Cell> cell = row.cellIterator();
				
				int k=0;
				int column= 0 ;
								
				while(cell.hasNext()){
					Cell value = cell.next();
					if(value.getStringCellValue().equalsIgnoreCase("TestCases")){
						column=k;						
					} 
					k++;
				}				
			System.out.println("TestCases present in Column :"+column);
			
            while(rows.hasNext()){
           	 Row r = rows.next();
           	 if(r.getCell(column).getStringCellValue().equalsIgnoreCase(testCaseName)){
           		 Iterator<Cell> cel = r.cellIterator();
           		 while(cel.hasNext()){
           			 lst.add(cel.next().getStringCellValue());
           		 }
           	 }
            }
             
			}
		}
		return lst;
	}

	public static void main(String[] args) throws IOException {		
		DataDriven dd = new DataDriven();
		ArrayList<String> ls = dd.getData("Add Profile");				
		System.out.println(ls);
	}

}
