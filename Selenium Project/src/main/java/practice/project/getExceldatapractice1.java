package practice.project;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class getExceldatapractice1 {
public static void main(String[] args) throws EncryptedDocumentException, InvalidFormatException, IOException {
	
	FileInputStream file = new FileInputStream("src/main/resources/testData/TestData.xlsx");
	 Sheet sheet = WorkbookFactory.create(file).getSheet("Sheet2");
	 
	Iterator<Row> rows = sheet.rowIterator();
	Row row = rows.next();
	Iterator<Cell> cells = row.cellIterator();
	int i=0, j=0;
	while(cells.hasNext()) {
		if(cells.next().getStringCellValue().equalsIgnoreCase("Testcase")) {
			j=i;
		}
		i++;
	}
	while(rows.hasNext()) {
		Row r = rows.next();
		if(r.getCell(j).getStringCellValue().equalsIgnoreCase("d")) {
			Iterator<Cell> cell = r.cellIterator();
			while(cell.hasNext()) {
				Cell c = cell.next();
				if(c.getCellTypeEnum() == CellType.STRING) {
					System.out.println(c.getStringCellValue());
				}
				else {
					System.out.println(c.getNumericCellValue());
				}
			}
		}
	}
	
}
}
