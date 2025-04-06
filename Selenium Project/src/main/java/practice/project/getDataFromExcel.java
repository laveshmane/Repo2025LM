package practice.project;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;



public class getDataFromExcel {
public static void main(String[] args) throws IOException, EncryptedDocumentException, InvalidFormatException {
	getDataFromExcel thisclass = new getDataFromExcel();
	thisclass.getStringdata();
	thisclass.getalldata();
	
}

public void getalldata() throws EncryptedDocumentException, InvalidFormatException, IOException {
	FileInputStream stream = new FileInputStream("src/main/resources/testData/TestData.xlsx");
	Sheet sh = WorkbookFactory.create(stream).getSheet("Sheet1");
	
	int lastrow = sh.getLastRowNum();
	for(int i=0; i<=lastrow; i++) {
		int lastcell = sh.getRow(i).getLastCellNum();
		
		for(int j=0; j<=lastcell; j++) {
			  @SuppressWarnings("deprecation")
			CellType type = sh.getRow(i).getCell(j).getCellTypeEnum();
			 String val;
			double num;
			boolean boo;
			if(type==CellType.STRING) {
				val = sh.getRow(i).getCell(j).getStringCellValue();
			System.out.println(val+" ");
			}
			 else  if(type==CellType.NUMERIC) {
				 num = sh.getRow(i).getCell(j).getNumericCellValue();
			System.out.println(num+" ");
			 }
			 else  if(type==CellType.BOOLEAN) {
				 boo = sh.getRow(i).getCell(j).getBooleanCellValue();
			System.out.println(boo+" ");
			 }
		}
	}
	
}
public void getStringdata() throws EncryptedDocumentException, InvalidFormatException, IOException {
FileInputStream stream = new FileInputStream("src/main/resources/testData/TestData.xlsx");
	Sheet sh = WorkbookFactory.create(stream).getSheet("Sheet1");
	
	System.out.println(sh.getRow(0).getCell(0).getStringCellValue());
	System.out.println(sh.getRow(0).getCell(1).getStringCellValue());
	System.out.println(sh.getRow(1).getCell(0).getStringCellValue());
	System.out.println(sh.getRow(1).getCell(1).getStringCellValue());
}
}
