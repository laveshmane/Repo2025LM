package practice.project;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Baseclass {

	public ArrayList<String> getExcelData(String sheetname, String testcase) throws EncryptedDocumentException, InvalidFormatException, IOException {
		
		FileInputStream fis = new FileInputStream("src/main/resources/testData/TestData.xlsx");
		Sheet sh = WorkbookFactory.create(fis).getSheet(sheetname);
		
		ArrayList<String> arr = new ArrayList<String>();
		Iterator<Row> rows = sh.rowIterator();
		Row row = rows.next();
		Iterator<Cell> cells = row.cellIterator();
		int i=0; int ro=0;
		while(cells.hasNext()) {
			Cell cell = cells.next();
			if(cell.getStringCellValue().equalsIgnoreCase("Testcase")) {
				ro=i;
			}
			i++;
		}
		System.out.println(ro);
		
		while(rows.hasNext()) {
			Row r = rows.next();
			if(r.getCell(ro).getStringCellValue().equalsIgnoreCase(testcase)) {
			 Iterator<Cell> cell = r.cellIterator();
			 while(cell.hasNext()) {
				 Cell ce = cell.next();
				 String sdata = null;  
				 if(ce.getCellTypeEnum() == CellType.STRING) {
				  sdata = ce.getStringCellValue();
				 }
				 else  {
					 double ndata = ce.getNumericCellValue();
				  sdata=Double.toString(ndata);
				 }
				 //System.out.println(sdata);
				 arr.add(sdata);
				 
			 }
			}
		}
		return arr;
	}
	
	public static void main(String[] args) throws EncryptedDocumentException, InvalidFormatException, IOException {
		Baseclass bs = new Baseclass();
		ArrayList<String> list = bs.getExcelData("eregrgr", "fine");
		System.out.println(list);
	}
}
