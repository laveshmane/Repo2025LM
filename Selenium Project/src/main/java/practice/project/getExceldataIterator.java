package practice.project;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class getExceldataIterator {
	public static void main(String[] args) throws EncryptedDocumentException, InvalidFormatException, IOException {

		FileInputStream stream = new FileInputStream("src/main/resources/testData/TestData.xlsx");
		Workbook wb = WorkbookFactory.create(stream);

		int shcount = wb.getNumberOfSheets();
		ArrayList<String> data = new ArrayList<String>();
		for (int i = 0; i <= shcount; i++) {

			if (wb.getSheetAt(i).getSheetName().equalsIgnoreCase("Testdata")) {
				Sheet sheet = wb.getSheetAt(i);
				Iterator<Row> rows = sheet.rowIterator();
				Row firstrow = rows.next();
				Iterator<Cell> cells = firstrow.cellIterator();
				int k = 0;
				int cl = 0;
				while (cells.hasNext()) {
					Cell firstcell = cells.next();
					if (firstcell.getStringCellValue().equalsIgnoreCase("Data")) {
						cl = k;
					}
					k++;
				}
				System.out.println(cl);

				while (rows.hasNext()) {
					Row r = rows.next();
					if (r.getCell(cl).getStringCellValue().equalsIgnoreCase("Purchase")) {
						Iterator<Cell> actcell = r.cellIterator();
						while (actcell.hasNext()) {
							
							String val = actcell.next().getStringCellValue();
							data.add(val);
							  
						}
					}
				}

			}
		}
		System.out.println("____________");
		for (String piece : data) {
			System.out.println(piece);
		}
	}
}
